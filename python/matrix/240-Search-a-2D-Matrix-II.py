"""
:type matrix: List[List[int]]
:type target: int
:rtype: bool
"""
from typing import List
class Solution:
    def searchMatrix(self, matrix, target):
        if len(matrix) == 0 or len(matrix[0]) == 0: return False
        for i in range(len(matrix)):
            if matrix[i][0] > target: break
            res = self.searchTarget(matrix[i], target)
            if res != -1:
                return True
        return False
    def searchTarget(self, nums, e):
        # return index of e, if not found, return -1
        l, r = 0, len(nums) - 1
        while l <= r:
            mid = l + (r - l) // 2
            if nums[mid] < e:
                l = mid + 1
            elif nums[mid] > e:
                r = mid - 1
            else:
                return mid
        return -1