from typing import List
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        left, right = 0, len(nums) -1
        result = []
        def searchLeftEdge(left, right, target):
            while left <= right:
                mid = (left + right)//2
                if nums[mid] == target:
                    if mid-1 <0 or nums[mid-1] < target:
                        return mid
                    else:
                        right = mid - 1
                if nums[mid] < target:
                    left = mid + 1
            return -1

        def searchRightEdge(left, right, target):
            while left <= right:
                mid = (left + right)//2
                if nums[mid] == target:
                    if mid+1 >= len(nums) or nums[mid+1] > target:
                        return mid
                    else:
                        left = mid +1
                if nums[mid] > target:
                    right = mid - 1
            return -1

        while left <= right:
            mid = (left + right) //2
            if nums[mid] == target:
                left_edge = searchLeftEdge(0, mid, target)
                right_edge = searchRightEdge(mid, len(nums) -1, target)
                result.append(left_edge)
                result.append(right_edge)
                return result
            if nums[mid] > target:
                right = mid - 1
            if nums[mid] < target:
                left = mid + 1
        return [-1, -1]

def main():
    sol = Solution()
    result = sol.searchRange([0, 1, 1, 4], 1)
    print(result)

    result = sol.searchRange([5,7,7,8,8,10], 8)
    print(result)
    result = sol.searchRange([5,7,7,8,8,10], 6)
    print(result)

    result = sol.searchRange([2,3,5], 3)
    print(result)

if __name__ == "__main__":
    main()