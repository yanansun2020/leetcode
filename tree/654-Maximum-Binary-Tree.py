# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from TreeNode import TreeNode
from typing import List
class Solution:
    def constructMaximumBinaryTree(self, nums: List[int]) -> TreeNode:
        N = len(nums)
        return self.constructNode(0, N, nums)

    def constructNode(self, start, end, nums):
        if start == end:
            return None
        max_index_value = self.findMaxAndIndex(start, end, nums)
        if max_index_value:
            max_index = max_index_value[0]
            max_value = max_index_value[1]
            node = TreeNode(max_value)
            node.left = self.constructNode(start,max_index, nums)
            node.right = self.constructNode(max_index + 1, end, nums)
            return node

    def findMaxAndIndex(self, start, end, nums):
        if start == end:
            return None
        max_index_value = (start, nums[start])
        for index in range(start, end):
            if nums[index] > max_index_value[1]:
                max_index_value = (index, nums[index])
        return max_index_value

def main():
    sol = Solution()
    result = sol.constructMaximumBinaryTree([3,2,1,6,0,5])
    print(result)

if __name__ == "__main__":
    main()
