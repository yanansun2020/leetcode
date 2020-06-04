from Node import Node
from typing import List
class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        nodes = []
        nodes.append(root)
        result = []
        if root:
            tmpList = [root.val]
            result.append(tmpList)
        self.depthLevelOrder(nodes, result)
        return result

    def depthLevelOrder(self, nodes, result):
        if not nodes:
            return
        tmpList = []
        for node in nodes:
            if node and node.children:
                tmpList.extend(node.children)
        if tmpList:
            value_list = []
            for i in tmpList:
                value_list.append(i.val)
            result.append(value_list)
        self.depthLevelOrder(tmpList, result)

def main():
    sol = Solution()
    leaf = [Node(5), Node(6)]
    children = [Node(3, leaf), Node(2), Node(4)]
    root = Node(1, children)
    # root = TreeNode(3, TreeNode(0, None, TreeNode(2, TreeNode(1, None, None), None)), TreeNode(4, None, None))
    result = sol.levelOrder(root)
    print(result)

if __name__ == "__main__":
    main()