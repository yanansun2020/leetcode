from typing import List
class Solution:
    def maximumProduct(self, nums: List[int]) -> int:
        nums.sort()
        N = len(nums)
        product_negative = 0
        if nums[0] < 0:
            product_negative = nums[0] * nums[1]
        product_positive = nums[N-1] * nums[N-2]
        return max((product_negative * nums[N-1]), (product_positive * nums[N-3]))


def main():
    sol = Solution()
    result = sol.maximumProduct([1,2,3, 4])
    print(result)
    result = sol.maximumProduct([-1, -2, -3])
    print(result)
if __name__ == "__main__":
    main()