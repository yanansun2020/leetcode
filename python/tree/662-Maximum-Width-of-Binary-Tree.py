# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from TreeNode import TreeNode
class Solution:
    max_width = 0
    def widthOfBinaryTree(self, root: TreeNode) -> int:
        queue = [(root, 0, 0)]
        cur_depth = left = ans = 0
        for node, depth, pos in queue:
            if node:
                queue.append((node.left, depth+1, pos*2))
                queue.append((node.right, depth+1, pos*2 + 1))
                if cur_depth != depth:
                    cur_depth = depth
                    left = pos
                ans = max(pos - left + 1, ans)

        return ans


def main():
    sol = Solution()
    # left = TreeNode(2, TreeNode(2, TreeNode(2)), TreeNode(2, TreeNode(2)))
    # right = TreeNode(2, TreeNode(2, None, TreeNode(2)), TreeNode(2, None, TreeNode(2)))
    # root = TreeNode(1, left, right)

    # root1 = TreeNode(1, TreeNode(1, TreeNode(1), TreeNode(1, None, root)), TreeNode(1, TreeNode(1), TreeNode(1)))
    # result = sol.widthOfBinaryTree(root1)
    # list_1 = [' ', ' ', '1', ' ', ' ', "2", ' ']
    # result = sol.removeFirstAndLastSpace(list_1)
    root = TreeNode(1, TreeNode(1, TreeNode(1)), TreeNode(1, None, TreeNode(1)))
    result = sol.widthOfBinaryTree(root)


    print(result)

if __name__ == "__main__":
    main()