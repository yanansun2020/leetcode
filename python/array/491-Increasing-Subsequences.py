from typing import List
class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        ans = []
        def dfs(index, array):
            if len(array) >= 2:
                ans.append(array)
            if index == len(nums):
                return
            sets = set()
            for i in range(index, len(nums)):
                if nums[i] in sets:
                    continue
                if not array or nums[i] >= array[-1]:
                    sets.add(nums[i])
                    dfs(i+1, array+[nums[i]])
        dfs(0, [])
        return ans
def main():
    sol = Solution()
    result = sol.findSubsequences([7, 7])
    print(result)
    result = sol.findSubsequences([4,6,7, 7])
    print(result)
    # result = sol.search([1,3,1,1,1], 3)
    # print(result)
if __name__ == "__main__":
    main()