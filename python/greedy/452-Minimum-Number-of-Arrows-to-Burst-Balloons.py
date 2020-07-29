from typing import List
class Solution:
    # arrow public positions of all the iterated nodes
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        if not points:
            return 0
        points.sort()
        count = 1
        arrow = (points[0][0],points[0][1])
        for start, end in points:
            if start <= arrow[1]:
                arrow = (max(start, arrow[0]), min(arrow[1], end))
            else:
                count += 1
                arrow = (start, end)
        return count
def main():
    sol = Solution()
    result = sol.findMinArrowShots([[9,12],[1,10],[4,11],[8,12],[3,9],[6,9],[6,7]])
    print(result)
    result = sol.findMinArrowShots([[10,16], [2,8], [1,6], [7,12]])
    print(result)
if __name__ == "__main__":
    main()
