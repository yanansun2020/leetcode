# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from TreeNode import TreeNode
class Solution:
    def sumRootToLeaf(self, root: TreeNode) -> int:
        result = []
        self.count = 0
        def getPath(node, stack):
            if not node:
                return
            stack.append(node.val)
            if not node.left and not node.right:
                value = getDecimalValue(stack)
                self.count += value
            getPath(node.left, stack)
            getPath(node.right, stack)
            stack.pop(-1)

        def getDecimalValue(stack):
            value = 0
            N = len(stack)
            for index in range(N):
                value += stack[index] * pow(2, N- index -1)
            return value
        getPath(root, result)
        return self.count


def main():
    sol = Solution()
    left = TreeNode(0, TreeNode(0), TreeNode(1))
    right = TreeNode(1, TreeNode(0), TreeNode(1))
    root = TreeNode(1, left, right)
    result = sol.sumRootToLeaf(root)
    print(result)

if __name__ == "__main__":
    main()