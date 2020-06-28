import collections
from TreeNode import TreeNode
class Solution:
    def maxLevelSum(self, root: TreeNode) -> int:
        queue = collections.deque()
        queue.append((root, 1))
        cur_depth, max_sum, result_depth = 1, root.val, 1
        tmp_sum = 0
        while queue:
            ele = queue.popleft()
            node = ele[0]
            depth = ele[1]
            if node.left:
                queue.append((node.left, 1 + depth))
            if node.right:
                queue.append((node.right, 1 + depth))
            if cur_depth == depth:
                tmp_sum += node.val
                continue
            if cur_depth != depth:
                if tmp_sum > max_sum:
                    max_sum = tmp_sum
                    result_depth = cur_depth
                tmp_sum = node.val
                cur_depth = depth
        return result_depth

def main():
    sol = Solution()
    left = TreeNode(7, TreeNode(7), TreeNode(-8))
    right = TreeNode(10)
    root = TreeNode(1, left, right)
    # root = TreeNode(989, None, TreeNode(10250, TreeNode(98693), TreeNode(-89388, None, TreeNode(-32127))))
    result = sol.maxLevelSum(root)
    print(result)

if __name__ == "__main__":
    main()