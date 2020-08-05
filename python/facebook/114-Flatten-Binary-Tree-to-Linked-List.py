# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    #iterative pre-order in-place flat bottom up
    def flatten(self, root: TreeNode) -> None:
        stack = []
        node = root
        while stack or node:
            while node:
                stack.append(node)
                node = node.left
            node = stack.pop()
            tmp = node.right
            node.right = node.left
            node.left = None
            cur = node
            while cur.right:
                cur = cur.right
            cur.right = tmp
            node = node.right
        print(1)
    #recursibe in-place flat bottom up
    def flatten_in_place(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        def flat(node):
            if not node:
                return
            flat(node.left)
            flat(node.right)
            tmp = node.right
            node.right = node.left
            node.left = None
            cur = node
            while cur.right:
                cur = cur.right
            cur.right = tmp
        flat(root)

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
    root = TreeNode(1, TreeNode(2, TreeNode(3), TreeNode(4)), TreeNode(5, TreeNode(6),None ))
    result = sol.flatten(root)
    print(result)
    # result = sol.flatten([1,2,3,0,0,0], 3,[2, 5,6], 3 )
    # print(result)

if __name__ == "__main__":
    main()
