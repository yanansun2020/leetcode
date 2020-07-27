from typing import List
# Q1:  input Array: [ 0.1, 0.2, 18.9, 17.5, 14.3, 12.1, 0.9,10.9] Output: 0.1
# find X, in the range [X, X+1) contains max of the numbers.
class Solution:
    def findMax(self, nums:List[float])->float:

        def bsNumber(start:int, target:float):
            left, right = start, len(nums)-1
            while left <= right:
                mid = (left + right)//2
                if nums[mid] == target:
                    return mid
                if nums[mid] < target:
                    left = mid + 1
                if nums[mid] > target:
                    right = mid -1
            return left

        nums.sort()
        result = nums[0]
        range_ = 0
        for i, num in enumerate(nums):
            idx = bsNumber(i, num +1)
            if idx - i > range_:
                range_ = idx -i
                result = num
        return result
def main():
    sol = Solution()
    result = sol.findMax([ 0.1, 0.2, 18.9, 17.5, 14.3, 12.1, 0.9,10.9])
    print(result)

if __name__ == "__main__":
    main()


