# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from TreeNode import TreeNode
class Solution:
    result = 0
    memo={}
    node_number = 0
    def maxProduct(self, root: TreeNode) -> int:
        self.result = 0
        self.memo={}
        self.node_number = 0
        sum_node = self.sumOfTheTree(root)
        self.node_number = 0
        self.max(root, sum_node)
        return self.result % (10**9 + 7)

    #遍历每个节点 找到最大值
    def max(self, node, sum_node):
        if not node:
            return 0
        self.max(node.left, sum_node)
        self.max(node.right, sum_node)
        self.node_number += 1
        partial_sum = self.memo.get(self.node_number)
        left_sum = sum_node - partial_sum
        product = partial_sum * left_sum
        if product > self.result:
            self.result = product


    def sumOfTheTree(self, node):
        if not node:
            return 0
        left = self.sumOfTheTree(node.left)
        right = self.sumOfTheTree(node.right)
        sum_result = left + right + node.val
        self.node_number += 1
        self.memo[self.node_number] = sum_result
        return sum_result

def main():
    sol = Solution()
    left = TreeNode(2, TreeNode(4), TreeNode(5))
    right = TreeNode(3, TreeNode(6))
    root = TreeNode(1, left, right)
    result = sol.maxProduct(root)
    print(result)
    root = TreeNode(1, TreeNode(1))
    result = sol.maxProduct(root)
    print(result)

if __name__ == "__main__":
    main()
