from Node import Node
from typing import List
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        result = []
        self.depthPreOrder(root, result)
        return result

    def depthPreOrder(self, node, result):
        if not node:
            return
        result.append(node.val)
        children = node.children
        if not children:
            return
        for child in children:
            self.depthPreOrder(child, result)



def main():
    sol = Solution()
    leaf = [Node(5), Node(6)]
    children = [Node(3, leaf), Node(2), Node(4)]
    root = Node(1, children)
    # root = TreeNode(3, TreeNode(0, None, TreeNode(2, TreeNode(1, None, None), None)), TreeNode(4, None, None))
    result = sol.preorder(root)
    print(result)

if __name__ == "__main__":
    main()