from typing import List
import sys
class Solution:
    def minSubArrayLen(self, s: int, nums: List[int]) -> int:
        j = 0
        sum_ = 0
        width = sys.maxsize
        for i, num in enumerate(nums):
            sum_ += num
            while sum_ >= s:
                if i - j + 1 < width:
                    width = i -j + 1
                sum_ -= nums[j]
                j += 1
        return width if width < sys.maxsize else 0

def main():
    sol = Solution()
    result = sol.minSubArrayLen(7, [2,3,1,2,4,3])
    print(result)
    # result = sol.minSubArrayLen("ADOABC", "ABC")
    # print(result)
    # result = sol.minSubArrayLen("ADOABCODEBANC", "ABC")
    # print(result)

if __name__ == "__main__":
    main()