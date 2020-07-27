from TreeNode import TreeNode
import sys
class Solution:
    #BST 中序遍历得到的结果是从小到大的顺序
    previous_value = None
    min_value = sys.maxsize
    def getMinimumDifference(self, root: TreeNode) -> int:
        previous_value = None
        min_value = sys.maxsize
        self.minimum(root)
        return self.min_value

    def minimum(self, root):
        if not root:
            return
        self.minimum(root.left)
        if self.previous_value is not None:
            self.min_value = min( self.min_value, abs(self.previous_value - root.val))
        self.previous_value = root.val
        self.minimum(root.right)


def main():
    sol = Solution()
    # root = TreeNode(236, TreeNode(104, None, TreeNode(227)), TreeNode(701, None, TreeNode(911)))
    root = TreeNode(0, None, TreeNode(2236, TreeNode(1277, TreeNode(519)), TreeNode(2776)))
    result = sol.getMinimumDifference(root)
    print(result)

if __name__ == "__main__":
    main()