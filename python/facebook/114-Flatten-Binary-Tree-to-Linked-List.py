# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        def flat(node):
            if not node or not node.left:
                return
            tmp = node.right
            node.right = node.left
            node.left = None
            flat(node.right)
            node.right.right = tmp
        flat(root)
        print(1)

    def flatten_not_in_place(self, root:TreeNode)->None:
        self.head = TreeNode(val=0)
        self.flat_node = self.head
        def flat(node):
            if not node:
                return
            self.flat_node.right = TreeNode(val=node.val)
            self.flat_node = self.flat_node.right
            flat(node.left)
            flat(node.right)
        flat(root)
        root = self.head
        print(1)
def main():
    sol = Solution()
    root = TreeNode(1, TreeNode(2, TreeNode(3), TreeNode(4)), TreeNode(5, None, TreeNode(6)))
    result = sol.flatten(root)
    print(result)
    # result = sol.flatten([1,2,3,0,0,0], 3,[2, 5,6], 3 )
    # print(result)

if __name__ == "__main__":
    main()
