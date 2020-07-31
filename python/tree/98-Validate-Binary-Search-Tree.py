class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        def validate(node, lower, upper):
            if not node:
                return True
            if node.val <= lower or node.val >= upper:
                return False
            left_bst = validate(node.left, lower, node.val)
            if not left_bst:
                return False
            right_bst = validate(node.right, node.val, upper)
            return right_bst
        return validate(root, float('-inf'), float('inf'))
def main():
    sol = Solution()
    root = TreeNode(10, TreeNode(5), TreeNode(15, TreeNode(12, TreeNode(6)), TreeNode(20)))
    result = sol.isValidBST(root)
    print(result)

if __name__ == "__main__":
    main()