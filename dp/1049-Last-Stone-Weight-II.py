class Solution:
    # divide the stones into two group
    # make the difference of sum_group_1, sum_group minimum
    # Which means try to divide stones evnly
    # reference https://leetcode.com/problems/partition-equal-subset-sum/
    def lastStoneWeightII(self, stones: List[int]) -> int:
        memo = {}
        sum_  = 0
        for stone in stones:
            sum_ += stone
            memo[stone] = sum_//2
        dp = [[0 for i in range(sum_//2 + 1)] for j in range(len(stones) + 1)]
        for j in range(sum_//2 + 1):
            if j < stones[0]:
                dp[0][j] = 0
            else:
                dp[0][j] = stones[0]
        for i in range(len(stones)):
            stone = stones[i]
            for j in range(memo.get(stone)):
                if j < stone:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = max(dp[i-1][j-stones[i]] + stones[i], dp[i-1][j])




