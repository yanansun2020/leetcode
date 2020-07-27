from typing import List
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return []
        results = []
        def dfs(start_index, result_array):
            results.append(list(result_array))
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
    result = sol.subsets([1,2, 3])
    print(result)
    # result = sol.subsets(3,2)
    # print(result)

if __name__ == "__main__":
    main()