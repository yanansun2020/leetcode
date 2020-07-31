from typing import List
from collections import defaultdict
from collections import Counter
import copy
class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        ans = []
        def dfs(index, t, array):
            if t == 0 or index == len(candidates):
                if t == 0:
                    ans.append(array)
                return
            for i in range(index, len(candidates)):
                if i > index and candidates[i] == candidates[i-1]:
                    continue
                if candidates[i] > t:
                    continue
                dfs(i + 1, t-candidates[i], array + [candidates[i]])
        candidates.sort()
        dfs(0, target, [])
        return ans

    def combinationSum2_solution2(self, candidates: List[int], target: int) -> List[List[int]]:
        results = []
        memo = defaultdict()
        def getCombs(candidates, array, target1, start):
            if target < target1:
                return
            if target1 == target:
                key = str(array)
                if not memo.get(key):
                    results.append(list(array))
                    memo[key] = 1
                return
            for i in range(start, len(candidates)):
                if target1 + candidates[i] > target:
                    return
                array.append(candidates[i])
                getCombs(candidates, array, target1 + candidates[i], i+1)
                array.pop()
        candidates.sort()
        getCombs(candidates, [], 0, 0)
        return results


def main():
    sol = Solution()
    # result = sol.combinationSum2([1,2,1], 3)
    # print(result)
    result = sol.combinationSum2([10,1,2,7,6,1,5], 8)
    print(result)
    # result = sol.combinationSum2([2,3,5], 8)
    # print(result)
    # result = sol.combinationSum2([2,5,2,1,2], 5)
    # print(result)
    # array = [29,19,14,33,11,5,9,23,23,33,12,9,25,25,12,21,14,11,20,30,17,19,5,6,6,5,5,11,12,25,31,28,31,33,27,7,33,31,17,13,21,24,17,12,6,16,20,16,22,5]
    # array.sort()
    # print(array)
#     result = sol.combinationSum2([29,19,14,33,11,5,9,23,23,33,12,9,25,25,12,21,14,11,20,30,17,19,5,6,6,5,5,11,12,25,31,28,31,33,27,7,33,31,17,13,21,24,17,12,6,16,20,16,22,5]
# ,28)
    # result = sol.combinationSum2(array, 28)
    # print(result)

if __name__ == "__main__":
    main()