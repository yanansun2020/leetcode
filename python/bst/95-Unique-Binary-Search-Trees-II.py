# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from TreeNode import TreeNode
from typing import List
class Solution:
    def generateTrees(self, n: int) -> List[TreeNode]:
        treeNodeList = []
        if n == 0:
            return treeNodeList
        return self.generate(1, n+1)
    def generate(self, start, end):
        if start >= end:
            return [None]
        treeNodeList = []
        for i in range(start, end):
            lefts = self.generate(start, i)
            rights = self.generate(i + 1, end)
            for left in lefts:
                for right in rights:
                    node = TreeNode(i)
                    node.left = left
                    node.right = right
                    treeNodeList.append(node)
        return treeNodeList

def main():
    sol = Solution()
    result = sol.generateTrees(2)
    print(result)

if __name__ == "__main__":
    main()

