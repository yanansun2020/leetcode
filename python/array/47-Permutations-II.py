from collections import defaultdict
from typing import List
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        results = []
        memo = defaultdict()

        def getPermutations(nums, result):
            if not nums:
                key = str(result)
                if memo.get(key):
                    return
                results.append(result)
                memo[key] = 1
                return
            for i in range(len(nums)):
                tmp_result = list(result)
                tmp_result.append(nums[i])
                tmp_nums = list(nums)
                tmp_nums.pop(i)
                getPermutations(tmp_nums, tmp_result)
        getPermutations(nums, [])
        return results

def main():
    sol = Solution()
    result = sol.permuteUnique([1,1,2])
    print(result)
    result = sol.permuteUnique([1,2])
    print(result)

if __name__ == "__main__":
    main()