from typing import List
class Solution:
    # search method is used to shrink the range
    # there must be one monotone range either after or before mid
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        left, right = 0, len(nums)-1
        while left <= right:
            mid = left + (right- left)//2
            if nums[mid] == target:
                return mid
            if nums[mid] < nums[0]:
                if nums[mid] <= target <= nums[len(nums)-1]:
                    return self.binarySearch(mid, right, target, nums)
                else:
                    right = mid -1
            else:
                if nums[0]<= target<=nums[mid]:
                    return self.binarySearch(left, mid, target, nums)
                else:
                    left = mid + 1
        return -1

    def binarySearch(self, left, right, target, nums):
        while left <= right:
            mid = left + (right-left)//2
            if nums[mid] > target:
                right = mid -1
            elif nums[mid] < target:
                left = mid + 1
            elif nums[mid] == target:
                return mid
        return -1

def main():
    sol = Solution()
    result = sol.search([5,1,3], 3)
    print(result)
    # result = sol.search([4,5,6,7,0,1,2], 0)
    # print(result)
    # result = sol.search([2,5,6,0,0,1,2], 3)
    # print(result)
    # result = sol.search([7,8,1,2,3,4,5], 3)
    # print(result)
    # result = sol.search([7,8,1,2,3,4,5], 5)
    # print(result)
    # result = sol.search([7,8,1,2,3,4,5], 1)
    # print(result)
    result = sol.search([7,8,1,2,3,4,5], 7)
    print(result)
if __name__ == "__main__":
    main()


    def search_1(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        min_left = nums[0]
        max_right = nums[-1]
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = (left + right)//2
            if nums[mid] == target:
                return mid
            if nums[mid] >= min_left:
                if target >= min_left and target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                if target <= max_right and target > nums[mid]:
                    left = mid + 1
                else:
                    right = mid - 1
        return False

