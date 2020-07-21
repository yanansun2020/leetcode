from heapq import heappop, heappush, heapify
from typing import List
class Solution:
    def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
        max_heap = []
        for x, y in points:
            heappush(max_heap, (-(x**2 + y**2), x, y))
            if len(max_heap) > K:
                heappop(max_heap)
        result = []
        for dist, x, y in max_heap:
            result.append([x, y])
        return result
    def kClosest_sort(self, points: List[List[int]], K: int) -> List[List[int]]:
        points.sort(key = lambda P: P[0]**2 + P[1]**2)
        return points[:K]
def main():
    sol = Solution()
    result = sol.kClosest([[1,3],[-2,2]], 1)
    print(result)
    result = sol.kClosest([[3,3],[5,-1],[-2,4]], 2)
    print(result)


if __name__ == "__main__":
    main()
