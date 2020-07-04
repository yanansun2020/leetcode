from typing import List
class Solution:
    def search(self, nums: List[int], target: int) -> int:
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

def main():
    sol = Solution()
    # result = sol.search([4,5,6,7,0,1,2], 0)
    # print(result)
    # result = sol.search([2,5,6,0,0,1,2], 3)
    # print(result)
    result = sol.search([1,3,1,1,1], 3)
    print(result)
if __name__ == "__main__":
    main()
