from typing import List
class Solution:
    def findNumberOfLIS(self, nums: List[int]) -> int:
        # length and its # occurance
        dp = [[1,1] for i in range(len(nums))]
        max_length = 1
        for i in range(1, len(nums)):
            for j in range(0, i):
                if nums[i] > nums[j]:
                    if 1 + dp[j][0] > dp[i][0]:
                        dp[i][0] = 1 + dp[j][0]
                        dp[i][1] = dp[j][1]
                    elif 1 + dp[j][0] == dp[i][0]:
                        dp[i][1] += dp[j][1]
            max_length = max(max_length, dp[i][0])
        max_frequency = 0
        for count,frequency in dp:
            if count == max_length:
                max_frequency += frequency
        return max_frequency

def main():
    sol = Solution()
    result = sol.findNumberOfLIS([1,1,2,2,3,3])
    print(result)
    result = sol.findNumberOfLIS([1,2,4,3,5,4,7,2])
    print(result)
    result = sol.findNumberOfLIS([2,2,2])
    print(result)
    result = sol.findNumberOfLIS([1,3,5,4,7])
    print(result)

if __name__ == "__main__":
    main()