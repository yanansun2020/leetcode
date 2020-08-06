from typing import List
class Solution:
    def findLengthOfLCIS(self, nums: List[int]) -> int:
        if not nums:
            return 0
        i, j = 1, 0
        max_count = 1
        while i < len(nums):
            if nums[i] <= nums[i-1]:
                max_count = max(max_count, i -j)
                j = i
            i += 1
        return max(max_count, i -j)


def main():
    sol = Solution()
    result = sol.findLengthOfLCIS([1])
    print(result)

    result = sol.findLengthOfLCIS([1,3,5,4,7])
    print(result)
    result = sol.findLengthOfLCIS([2,2,2])
    print(result)


if __name__ == "__main__":
    main()