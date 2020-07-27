# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from TreeNode import TreeNode
class Solution:
    sameSmallestPrefixRoute = ''
    def smallestFromLeaf(self, root: TreeNode) -> str:
        sameSmallestPrefixRoute = ''
        stack = []
        self.getSameSmallestPrefix(root, stack)
        return self.sameSmallestPrefixRoute

    def getSameSmallestPrefix(self, node, stack):
        if not node:
            return
        stack.append(node.val)
        if node and not node.left and not node.right:
            if not self.sameSmallestPrefixRoute:
                self.sameSmallestPrefixRoute = self.transferArrayToString(stack)
            else:
                self.compareAndSetRoute(stack)
        left = self.getSameSmallestPrefix(node.left, stack)
        right = self.getSameSmallestPrefix(node.right, stack)
        stack.pop()

    def transferArrayToString(self, route):
        string = ''
        for i in route[::-1]:
            string += chr(i+97)
        return string

    def compareAndSetRoute(self, route):
        cur = self.sameSmallestPrefixRoute
        position = ord(cur[0])-ord('a')
        if route[-1] <= position:
            new_route = self.transferArrayToString(route)
            if new_route < cur:
                self.sameSmallestPrefixRoute = new_route





def main():
    sol = Solution()
    left = TreeNode(1, TreeNode(3), TreeNode(4))
    right = TreeNode(2, TreeNode(5), TreeNode(6))
    root = TreeNode(0, left, right)
    result = sol.smallestFromLeaf(root)

    print(result)

if __name__ == "__main__":
    main()