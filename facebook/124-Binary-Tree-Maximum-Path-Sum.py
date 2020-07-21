import sys
sys.path.append("/home/yanan/work/leetcode")
from tree.TreeNode import *
class Solution:
    def maxPathSum(self, root: TreeNode) -> int:
        self.max_path_sum = -sys.maxsize-1
        def getValue(node):
            if not node:
                return 0
            left = getValue(node.left)
            right = getValue(node.right)
            max_with_root = max(left+node.val, right + node.val)
            left_1 = left if node.left else -sys.maxsize-1
            right_1 = right if node.right else -sys.maxsize-1
            max_without_root = max(left_1, right_1)
            self.max_path_sum = max(self.max_path_sum, max_without_root, left + right + node.val, max_with_root, node.val)
            return max_with_root

        getValue(root)
        return self.max_path_sum

def main():
    sol = Solution()
    treeNode = TreeNode(-10, TreeNode(-9), TreeNode(-20, TreeNode(-15), TreeNode(-7)))
    result = sol.maxPathSum(treeNode)
    print(result)
    treeNode = TreeNode(0)
    result = sol.maxPathSum(treeNode)
    print(result)
    treeNode = TreeNode(-3)
    result = sol.maxPathSum(treeNode)
    print(result)
    treeNode = TreeNode(1, TreeNode(2), TreeNode(3))
    result = sol.maxPathSum(treeNode)
    print(result)
    result = sol.maxPathSum(treeNode)
    print(result)
if __name__ == "__main__":
    main()
