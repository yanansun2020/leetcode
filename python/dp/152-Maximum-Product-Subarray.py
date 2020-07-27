from typing import List
class Solution:
    # dp[i] = (min, max) on i
    def maxProduct(self, nums: List[int]) -> int:
        if not nums:
            return 0
        N = len(nums)
        dp = [N]
        dp[0] = (nums[0], nums[0])
        max_ = nums[0]
        for i in range(1, N):
            tuple = dp[i-1]
            min_value = min(nums[i], nums[i] * tuple[0],  nums[i] * tuple[1])
            max_value = max(nums[i], nums[i] * tuple[0],  nums[i] * tuple[1])
            dp.append((min_value, max_value))
            if max_ < max_value:
                max_ = max_value
        return max_

def main():
    sol = Solution()
    result = sol.maxProduct([2,3,-2,4])
    print(result)
    result = sol.maxProduct([-2,0,-1])
    print(result)
    result = sol.maxProduct([-4, -3, -2, -2])
    print(result)



if __name__ == "__main__":
    main()
