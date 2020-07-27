from typing import List
from collections import defaultdict
class Solution:
    def findTargetSumWays(self, nums: List[int], S: int) -> int:
        memo = defaultdict(int)
        for i in range(len(nums)):
            if i == 0:
                memo[nums[i]] += 1
                memo[-nums[i]] += 1
                continue
            tmp_memo = defaultdict(int)
            for k,v in memo.items():
                key_plus = k + nums[i]
                key_minus = k-nums[i]
                tmp_memo[key_plus] += v
                tmp_memo[key_minus] += v
            memo = tmp_memo
        return memo.get(S) if memo.get(S) else 0


    #dfs TLE
    def findTargetSumWays_TLE(self, nums: List[int], S: int) -> int:
        all_nums = nums
        self.result = 0
        def dfs(all_nums, start_index, target, array):
            if start_index > len(all_nums):
                return
            if len(array) == len(all_nums) and target == 0:
                # print(array)
                # print(start_index)
                self.result += 1
            for i in range(start_index, len(all_nums)):
                dfs(all_nums, i+1, target-all_nums[i], array+[all_nums[i]])
                dfs(all_nums, i+1, target+all_nums[i], array+[-1 * all_nums[i]])
        dfs(all_nums, 0, S, [])
        return self.result

def main():
    sol = Solution()
    # result = sol.findTargetSumWays([1, 1],2)
    # print(result)
    result = sol.findTargetSumWays([0,1],1)
    print(result)
    result = sol.findTargetSumWays([1, 1, 1, 1, 1], 3)
    print(result)

    # result = sol.findTargetSumWays([2,3,5], 8)
    # print(result)

if __name__ == "__main__":
    main()