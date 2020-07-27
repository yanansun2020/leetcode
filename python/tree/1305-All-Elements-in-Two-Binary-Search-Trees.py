# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from TreeNode import TreeNode
from typing import List
class Solution:
    def getAllElements(self, root1: TreeNode, root2: TreeNode) -> List[int]:
        def getElements(node, ordered_list):
            if not node:
                return
            getElements(node.left, ordered_list)
            ordered_list.append(node.val)
            getElements(node.right, ordered_list)
            return ordered_list
        if not root1 and not root2:
            return[]
        ordered_list_1 = []
        ordered_list_1 = getElements(root1, ordered_list_1)
        ordered_list_2 = []
        ordered_list_2 = getElements(root2, ordered_list_2)
        if not ordered_list_1:
            ordered_list_1.extend(ordered_list_2)
            ordered_list_1.sort()
            return ordered_list_1
        if not ordered_list_2:
            ordered_list_2.extend(ordered_list_1)
            ordered_list_2.sort()
            return ordered_list_2

def main():
    left = TreeNode(2, TreeNode(1), TreeNode(4))
    right = TreeNode(1,TreeNode(0), TreeNode(3))
    sol = Solution()
    result = sol.getAllElements(left, right)
    print(result)
if __name__ == "__main__":
    main()