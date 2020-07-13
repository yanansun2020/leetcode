from typing import List
from collections import defaultdict
class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return []
        results = []
        memo = defaultdict()
        def dfs(start_index, result_array):
            tmp_array = list(result_array)
            tmp_array.sort()
            key = str(tmp_array)
            if key not in memo:
                results.append(tmp_array)
                memo[key] = 1
            if start_index == len(nums):
                return
            for i in range(start_index, len(nums)):
                # tm_array = list(result_array)
                result_array.append(nums[i])
                dfs(i+1, result_array)
                result_array.pop(-1)
        dfs(0, [])
        return results
def main():
    sol = Solution()
    # result = sol.combine(4, 2)
    # print(result)
    result = sol.subsetsWithDup([4,4,4,1,4])
    print(result)
    # result = sol.subsets(3,2)
    # print(result)

if __name__ == "__main__":
    main()