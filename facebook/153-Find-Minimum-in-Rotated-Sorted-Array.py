import sys
from typing import List
class Solution:
    def findMin(self, nums: List[int]) -> int:
        l, r = 0, len(nums)-1
        while l <= r:
            mid = l + (r-l)//2
            left_val = -sys.maxsize-1 if mid == 0 else nums[mid-1]
            right_val = nums[0] if mid == len(nums) -1 else nums[mid+1]
            if nums[mid] < left_val and nums[mid] <= right_val:
                return nums[mid]
            if nums[mid] <= nums[0] and nums[mid] >= left_val:
                r = mid -1
            else:
                l = mid + 1
        return nums[0]

def main():
    sol = Solution()
    result = sol.findMin([10,1,10,10,10])
    print(result)
    result = sol.findMin([3,1, 1, 1,1])
    print(result)
    result = sol.findMin([2,2,2,0,1])
    print(result)
    result = sol.findMin([1, 1,1])
    print(result)
    result = sol.findMin([1, 3, 5])
    print(result)
    result = sol.findMin([3])
    print(result)
    result = sol.findMin([3,4,5,5,1,2])
    print(result)
    result = sol.findMin([4,5,6,7,0,1,2])
    print(result)

if __name__ == "__main__":
    main()