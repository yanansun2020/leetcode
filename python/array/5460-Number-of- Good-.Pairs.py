from typing import List
class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        if not nums:
            return 0
        N = len(nums)
        count = 0
        for i in range(N):
            for j in range(i):
                if nums[i] == nums[j] and j <i:
                    count += 1
        return count
def main():
    sol = Solution()
    result = sol.numIdenticalPairs([1,2,3,1,1,3])
    print(result)
    result = sol.numIdenticalPairs([1,1,1,1])
    print(result)
    result = sol.numIdenticalPairs([1,2,3])
    print(result)
if __name__ == "__main__":
    main()