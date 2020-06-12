# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from TreeNode import TreeNode
class FindElements:
    normal_tree = None
    memo = {}
    def __init__(self, root: TreeNode):
        if not root:
            return
        nodes = [(root, 0)]
        root.val = 0
        self.memo[0] =1
        for node, v in nodes:
            if node:
                if node.left:
                    node.left.val = 2 * v + 1
                    self.memo[node.left.val] =1
                    nodes.append((node.left, node.left.val))
                if node.right:
                    node.right.val = 2 * v + 2
                    self.memo[node.right.val] =1
                    nodes.append((node.right, node.right.val))
        self.normal_tree = root

    def find(self, target: int) -> bool:
        if self.memo.get(target) is not None:
            return True
        return False
        # if not target or target < 0:
        #     return False
        # return self.find_target(target, self.normal_tree)

    def find_target(self, target, node):
        if not node:
            return False
        if target == node.val:
            return True
        return self.find_target(target, node.left) or\
            self.find_target(target, node.right)

def main():
    left = TreeNode(-1, TreeNode(-1), TreeNode(-1))
    right = TreeNode(-1,None, TreeNode(-1))
    root = TreeNode(-1, left, right)
    # root = TreeNode(1, TreeNode(2))
    sol = FindElements(root)
    result = sol.find(4)
    print(result)
if __name__ == "__main__":
    main()


# Your FindElements object will be instantiated and called as such:
# obj = FindElements(root)
# param_1 = obj.find(target)