from TreeNode import TreeNode
class Solution:
    def maxDepth(self, root):
        # depth = 0
        # maxDepth = 0
        sol = Solution()
        # maxDepth = sol.getDepth(root, depth)
        return sol.getDepth1(root)

    def getDepth1(self, treeNode):
        if treeNode is None:
            return 0
        else:
            sol = Solution()
            leftDepth = 1 + sol.getDepth1(treeNode.left)
            rightDepth = 1 + sol.getDepth1(treeNode.right)
            if leftDepth > rightDepth:
                return leftDepth
            else:
                return rightDepth

    def getDepth(self, treeNode, depth):
        if treeNode is None:
            return depth
        else:
            depth = depth + 1
            sol = Solution()
            leftDepth = sol.getDepth(treeNode.left, depth)
            rightepth = sol.getDepth(treeNode.right, depth)
            if leftDepth > rightepth:
                return leftDepth
            else:
                return rightepth

        # if treeNode is not None:
        #     sol = Solution()
        #     depth = depth + 1
        #     maxDepth = sol.getDepth(treeNode.left, depth, maxDepth)
        #     maxDepth = sol.getDepth(treeNode.right, depth, maxDepth)
        # else:
        #     if depth > maxDepth:
        #         maxDepth = depth
        # return maxDepth


def main():
    sol = Solution()
    left = TreeNode(5, None, None)
    right = TreeNode(7, None, None)
    right1 = TreeNode(20, left, right)
    root = TreeNode(3, TreeNode(9, None, None), right1)

    result = sol.maxDepth(root)
    print(result)

if __name__ == "__main__":
    main()
