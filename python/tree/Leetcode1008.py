from TreeNode import TreeNode

class Solution:
    def bstFromPreorder(self, preorder):
        root = TreeNode(preorder[0], None, None)
        sol = Solution()
        i = 1
        while i < len(preorder):
            sol.createTree(preorder[i], root)
            i = i + 1
        return root

    def createTree(self, value, node):
        tmpNode = TreeNode(value, None, None)
        if value < node.val:
            if node.left is None:
                node.left = tmpNode
                return
            else :
                sol = Solution()
                sol.createTree(value, node.left)
        if value > node.val:
            if node.right is None:
                node.right = tmpNode
                return
            else :
                sol = Solution()
                sol.createTree(value, node.right)
def main():
    sol = Solution()
    result = sol.bstFromPreorder([8,5,1,7,10,12])
    print(result)

if __name__ == "__main__":
    main()