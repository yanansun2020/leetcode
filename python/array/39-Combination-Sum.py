from typing import List
from collections import defaultdict
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        ans = []
        def dfs(t, array):
            if t == 0:
                array.sort()
                if array not in ans:
                    ans.append(array)
                return
            for i in range(0, len(candidates)):
                if candidates[i] > t:
                    continue
                dfs(t-candidates[i], array + [candidates[i]])
        dfs(target, [])
        return ans

    def combinationSum_complex(self, candidates: List[int], target: int) -> List[List[int]]:
        results = []
        memo = defaultdict()
        def getCombs(candidates, array, sum_):
            if sum_ > target:
                return
            if sum_ == target:
                array.sort()
                key = str(array)
                if memo.get(key):
                    return
                results.append(array)
                memo[key] = 1
            for candidate in candidates:
                sum_1 = sum_
                sum_1 += candidate
                tmp_array = list(array)
                tmp_array.append(candidate)
                getCombs(candidates, tmp_array, sum_1)
        getCombs(candidates, [], 0)
        return results


def main():
    sol = Solution()
    result = sol.combinationSum([2,3,6,7], 7)
    print(result)

    result = sol.combinationSum([2,3,5], 8)
    print(result)

if __name__ == "__main__":
    main()