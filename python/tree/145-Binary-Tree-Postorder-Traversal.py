class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        stack = []
        ans = []
        previous = None
        while root or stack:
            while root:
                stack.append(root)
                root = root.left
            node = stack[-1]
            if not node.righ or node.right== previous:
                previous = node
                ans.append(node.val)
                stack.pop()
            root = node.right
        return ans