from TreeNode import TreeNode
class Solution:
    def leafSimilar(self, root1: TreeNode, root2: TreeNode) -> bool:
        leaves_root_1 = []
        leaves_root_2 = []
        self.getLeaves(root1, leaves_root_1)
        self.getLeaves(root2, leaves_root_2)
        return leaves_root_1 == leaves_root_2


    def getLeaves(self, node, leaves_list):
        if not node:
            return None
        if node and (node.left is None) and (node.right is None):
            leaves_list.append(node.val)
            return node.val
        self.getLeaves(node.left, leaves_list)
        # if leaf_left_val is not None:
        #     leaves_list.append(leaf_left_val)
        self.getLeaves(node.right, leaves_list)
        # if leaf_right_val is not None:
        #     leaves_list.append(leaf_right_val)


def main():
    sol = Solution()
    left = TreeNode(5, TreeNode(6, None, None), TreeNode(2, TreeNode(7, None, None), TreeNode(4, None, None)))
    root = TreeNode(3, left, TreeNode(1, TreeNode(9, None, None), TreeNode(8, None, None)))

    right = TreeNode(1, TreeNode(4, None, None), TreeNode(2, TreeNode(9, None, None), TreeNode(8, None, None)))
    root_1 = TreeNode(3, TreeNode(5, TreeNode(6, None, None), TreeNode(7, None, None)), right)
    result = sol.leafSimilar(root, root_1)
    print(result)

    root = TreeNode(1, None, None)
    root_1 = TreeNode(2, None, None)
    result = sol.leafSimilar(root, root_1)
    print(result)
if __name__ == "__main__":
    main()