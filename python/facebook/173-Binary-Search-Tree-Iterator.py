# Definition for a binary tree node.
# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class BSTIterator:
    def __init__(self, root: TreeNode):
        self.stack = []
        node = root
        self.put_left(node)

    def next(self) -> int:
        """
        @return the next smallest number
        """
        if self.stack:
            top_node = self.stack[-1]
            self.stack.pop(-1)
            self.put_left(top_node.right)
            return top_node.val

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return self.stack

    def put_left(self, node):
        while node:
            self.stack.append(node)
            node = node.left


def main():
    root = TreeNode(7, TreeNode(3), TreeNode(15, TreeNode(9), TreeNode(20)))
    sol = BSTIterator(root)
    result = sol.next()
    print(result)
    result = sol.next()
    print(result)
    result = sol.hasNext()
    print(result)
    result = sol.next()
    print(result)
    result = sol.hasNext()
    print(result)
    result = sol.next()
    print(result)
    result = sol.hasNext()
    print(result)
    result = sol.next()
    print(result)
    result = sol.hasNext()
    print(result)
if __name__ == "__main__":
    main()
