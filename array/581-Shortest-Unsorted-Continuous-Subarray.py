from typing import List
import sys
# from left and right respectively to find the turning point
class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        start = len(nums)
        end = 0
        stack = []
        top_num = -sys.maxsize
        for i, num in enumerate(nums):
            while stack and stack[-1][0] > num:
                top_num, index = stack[-1]
                stack.pop(-1)
                start = min(start, index)
            stack.append((num, i))
        stack.clear()
        for i in range(len(nums)-1, -1, -1):
            while stack and stack[-1][0] < nums[i]:
                top_num, index = stack[-1]
                stack.pop(-1)
                end = max(end, index)
            stack.append((nums[i], i))
        return end - start + 1 if end - start > 0 else 0
def main():
    sol = Solution()
    # result = sol.findUnsortedSubarray([2, 6, 4, 8, 10, 9, 15])
    # print(result)
    result = sol.findUnsortedSubarray([1,3,2,2,2])
    print(result)
    # result = sol.findUnsortedSubarray([1,2,3,4])
    # print(result)
    # result = sol.findUnsortedSubarray([1,3,2,2,2, 5,5])
    # print(result)
    # result = sol.findUnsortedSubarray([1,2,2,3,2, 5,5])
    # print(result)
    # result = sol.findUnsortedSubarray([2,1])
    # print(result)
    # result = sol.findUnsortedSubarray([2,3,3,2,4])
    # print(result)
    # result = sol.findUnsortedSubarray([1,2,4,5,3])
    # print(result)
    result = sol.findUnsortedSubarray([1,3,5,2,4])
    print(result)
if __name__ == "__main__":
    main()

