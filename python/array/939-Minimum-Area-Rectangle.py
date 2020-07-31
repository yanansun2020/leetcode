from collections import defaultdict
import sys
from typing import List
class Solution:
    def minAreaRect(self, points: List[List[int]]) -> int:
        points = sorted(points, key=lambda item: (item[0], item[1]))
        cols = defaultdict(list)
        for x,y in points:
            cols[x].append(y)
        lastx = {}
        ans = float('inf')
        for x in cols:
            col = cols[x]
            for i, y1 in enumerate(col):
                for j in range(i):
                    y2 = col[j]
                    if (y2,y1) in lastx:
                        ans = min(ans, abs((x-lastx[y2,y1])*(y2-y1)))
                    lastx[y2,y1] = x
        return 0 if ans==float('inf') else ans

    def minAreaRect_TLE(self, points: List[List[int]]) -> int:
        points.sort()
        memo = defaultdict(list)
        for i, j in points:
            memo[i].append(j)
        ans = sys.maxsize
        for i in range(len(points)):
            x1, y1 = points[i]
            for j in range(len(points)):
                x2, y2 = points[j]
                if x1 == x2 or y1 == y2:
                    continue
                if y2 in memo[x1] and y1 in memo[x2]:
                    ans = min(ans, abs(x2-x1) * abs(y2-y1))
        return ans if ans < sys.maxsize else 0
def main():
    sol = Solution()
    result = sol.minAreaRect([[1,1],[1,3],[3,1],[3,3],[2,2], [1,4], [3,6]])
    print(result)
    result = sol.minAreaRect([[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]])
    print(result)
if __name__ == "__main__":
    main()