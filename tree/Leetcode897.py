# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from TreeNode import TreeNode
class Solution:
    # def increasingBST(self, root):
    #     def inorder(node):
    #         if node:
    #             yield from inorder(node.left)
    #             yield node.val
    #             yield from inorder(node.right)
    #     ans = cur = TreeNode(None)
    #     nodes = inorder(root)
    #     for v in nodes:
    #         cur.right = TreeNode(v)
    #         cur = cur.right
    #     return ans.right
    header = None
    curNode = None
    def increasingBST(self, root):
        self.header = self.curNode = TreeNode(None)
        self.increasingBST_helper(root)
        return self.header.right

    def increasingBST_helper(self, root):
        if not root:
            return None
        self.increasingBST_helper(root.left)
        if not self.curNode:
            self.curNode = self.header = TreeNode(root.val)
        else:
            self.curNode.right = TreeNode(root.val)
            self.curNode = self.curNode.right
        self.increasingBST_helper(root.right)


    # def increasingBST_1(self, root):
    #     self.node = self.ret = None
    #     self.inorder(root)
    #     return self.ret

    # def inorder(self, node):
    #     if not node:
    #         return None
    #     self.inorder(node.left)
    #     if not self.ret:
    #         self.ret = self.node = TreeNode(node.val)
    #     else:
    #         self.node.right = TreeNode(node.val)
    #         self.node = self.node.right
    #     self.inorder(node.right)


def main():
    sol = Solution()
    left_1 = TreeNode(3, TreeNode(2, TreeNode(1), None), TreeNode(4))
    root = TreeNode(5, left_1,  TreeNode(6, None, TreeNode(8, TreeNode(7), TreeNode(9))))
    result = sol.increasingBST(root)
    print(result)

if __name__ == "__main__":
    main()

