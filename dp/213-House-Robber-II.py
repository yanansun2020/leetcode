from typing import List
class Solution:
    def rob(self, nums: List[int]) -> int:
        reversedNums = nums[::-1]
        dp1 = nums[:]
        dp2 = reversedNums[:]
        for i in range(2,len(nums)-1):
            dp1[i] += max(dp1[:i-1])
            dp2[i] += max(dp2[:i-1])
        if len(dp1 + dp2):
            return max(dp1 + dp2)
        return 0

def main():
    sol = Solution()
    result = sol.rob([1,2,3,1])
    print(result)

if __name__ == "__main__":
    main()
