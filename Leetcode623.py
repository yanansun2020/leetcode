from TreeNode import TreeNode
class Solution:
    def addOneRow(self, root: TreeNode, v: int, d: int) -> TreeNode:
        if d == 1:
            return TreeNode(v, root, None)

        self.addNode(root, v, 0, d)
        return root

    def addNode(self, node, v, depth, d):
        if not node:
            return
        depth = depth + 1
        if d == (depth + 1):
            left = TreeNode(v, node.left, None)
            right = TreeNode(v, None, node.right)
            node.left = left
            node.right = right
            # if node.left:

            #     node.left = left
            # if node.right:
            #     right = TreeNode(v, None, node.right)
            #     node.right = right
            # if not node.left and not node.right:
            #     node.left = TreeNode(v, None, None)
            #     node.right =
            return
        self.addNode(node.left, v, depth, d)
        self.addNode(node.right, v, depth, d)




def main():
    sol = Solution()
    # root = TreeNode(4, TreeNode(2, TreeNode(3, None, None), TreeNode(1, None, None)), TreeNode(6, TreeNode(5, None, None), None))
    # result = sol.addOneRow(root, 1, 2)
    # root = TreeNode(4, TreeNode(2, TreeNode(3, None, None),TreeNode(1, None, None)), None)
    # result = sol.addOneRow(root, 1, 3)
    # root = TreeNode(1, TreeNode(2, TreeNode(4, None, None)), TreeNode(3, None, None))
    # result = sol.addOneRow(root, 5, 4)

    root = TreeNode(4, TreeNode(2, TreeNode(3, None, None), TreeNode(1, None, None)), TreeNode(6,  TreeNode(5, None, None), None))
    result = sol.addOneRow(root, 1, 1)
    print(result)
if __name__ == "__main__":
    main()