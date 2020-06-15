from typing import List
class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x:x[0])
        remaining = []
        for interval in intervals:
            if not remaining:
                remaining.append(interval)
            else:
                prev = remaining[-1]
                if prev[0] == interval[0] and prev[1] < interval[1]:
                    remaining.pop()
                if prev[1] < interval[1]:
                    remaining.append(interval)
        return len(remaining)

def main():
    sol = Solution()
    result = sol.removeCoveredIntervals([[34335,39239],[15875,91969],[29673,66453],[53548,69161],[40618,93111]])
    print(result)

if __name__ == "__main__":
    main()