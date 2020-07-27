from typing import List
# in-place data change
class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        if not nums:
            return 1
        N = len(nums)
        for i in range(N):
            while nums[i] > 0 and nums[i] < N and nums[i] != nums[nums[i] - 1]:
                tmp = nums[nums[i] -1]
                nums[nums[i] -1] = nums[i]
                nums[i] = tmp
        for i in range(N):
            if i+1 != nums[i]:
                return i + 1
        return N + 1
def main():
    sol = Solution()
    result = sol.firstMissingPositive([1, 1])
    print(result)
    result = sol.firstMissingPositive([1,2,0])
    print(result)
    result = sol.firstMissingPositive([3,4,-1,1])
    print(result)
    result = sol.firstMissingPositive([7,8,9,11,12])
    print(result)

if __name__ == "__main__":
    main()