from typing import List
class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        if not nums:
            return False
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = (left + right)//2
            if nums[mid] == target:
                return True
            if nums[mid] == nums[left] and nums[mid] == nums[right]:
                left += 1
                right -= 1
                continue
            if nums[mid] >= nums[left]:
                if target >= nums[left] and target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                if target <= nums[right] and target > nums[mid]:
                    left = mid + 1
                else:
                    right = mid - 1
        return False

def main():
    sol = Solution()
    # result = sol.search([2,5,6,0,0,1,2], 1)
    # print(result)
    result = sol.search([1, 3,1,1,1], 3)
    print(result)
    # result = sol.search([1,3,1,1,1], 3)
    # print(result)
if __name__ == "__main__":
    main()