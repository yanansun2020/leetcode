from Node import Node
from typing import List
class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        result = []
        self.depthPostOrder(root, result)
        result.append(root.val)
        return result

    def depthPostOrder(self, node, result):
        if not node:
            return
        children = node.children
        if not children:
            return
        for child in children:
            self.depthPostOrder(child, result)
            result.append(child.val)



def main():
    sol = Solution()
    leaf = [Node(5), Node(6)]
    children = [Node(3, leaf), Node(2), Node(4)]
    root = Node(1, children)
    # root = TreeNode(3, TreeNode(0, None, TreeNode(2, TreeNode(1, None, None), None)), TreeNode(4, None, None))
    result = sol.postorder(root)
    print(result)

if __name__ == "__main__":
    main()