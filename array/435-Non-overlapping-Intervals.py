from typing import List
class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda l:l[0])
        end = intervals[0][1]
        result = 0
        for index in range(1, len(intervals)):
            if intervals[index][0] < end:
                result += 1
                end = min(intervals[index][1], end)
            else:
                end = intervals[index][1]
        return result
    #the beginning of interval1 is less than the beginning of interval2
    def isOverlapped(self, interval1, interval2):
        if interval1[1] <= interval2[0]:
            return False
        return True


def main():
    sol = Solution()
    result = sol.eraseOverlapIntervals([[1,2],[1,2],[1,2]])
    print(result)
if __name__ == "__main__":
    main()