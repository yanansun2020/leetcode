from typing import List
from collections import defaultdict
class Solution:
    #solution: if there exist a k from i to j, there must exist a sum-k from 0-i and a sum from 0-j
    def subarraySum(self, nums: List[int], k: int) -> int:
        if not nums:
            return 0
        count, sum_ = 0, 0
        memo = defaultdict(int)
        memo[0] = 1
        for num in nums:
            sum_ += num
            if memo.get(sum_ - k):
                count += memo.get(sum_ - k)
            memo[sum_] += 1
        return count
    #TLE
    def subarraySum_TLE(self, nums: List[int], k: int) -> int:
        if not nums:
            return 0
        count = 0
        dp = []
        for i in range(len(nums)):
            if i == 0:
                dp.append(nums[0])
                continue
            dp.append(dp[i-1] + nums[i])
        for i in range(len(nums)):
            for j in range(i, len(nums)):
                left_value = dp[i-1] if i >=1 else 0
                if dp[j] - left_value == k:
                    count += 1
        return count

def main():
    sol = Solution()
    result = sol.subarraySum([1,1,1], 2)
    print(result)
    result = sol.subarraySum([2,4,6], 6)
    print(result)
    # result = sol.subarraySum([0,0,1,1,1,1,0,0], 8)
    # print(result)
if __name__ == "__main__":
    main()
