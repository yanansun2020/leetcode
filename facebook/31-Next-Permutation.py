from typing import List
class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        def swap(i, j):
            tmp = nums[i]
            nums[i] = nums[j]
            nums[j] = tmp

        i = len(nums)-1
        while i > 0 and nums[i-1] >= nums[i]:
            i -= 1
        if i-1>=0 :
            j = len(nums)-1
            while j>= -0 and nums[j] <=nums[i-1]:
                j -= 1
            swap(i-1, j)
        nums[i:] = nums[i:][::-1]
        print(1)

def main():
    sol = Solution()
    result = sol.nextPermutation([5, 1, 1])
    print(result)
    result = sol.nextPermutation([1,3,2])
    print(result)
    result = sol.nextPermutation([1,2,3])
    print(result)
    result = sol.nextPermutation([3,2,1])
    print(result)
    result = sol.nextPermutation([1,1,3])
    print(result)

if __name__ == "__main__":
    main()
