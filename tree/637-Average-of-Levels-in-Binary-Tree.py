from TreeNode import TreeNode
from typing import List
class Solution:
    def averageOfLevels(self, root: TreeNode) -> List[float]:
        if not root:
            return []
        result = []
        # node, depth
        nodes = [(root, 0)]
        cur_depth = 0
        number_of_nodes = 0
        nodes_value = 0
        for node, depth in nodes:
            if cur_depth != depth:
                result.append(nodes_value/number_of_nodes)
                number_of_nodes = 0
                nodes_value = 0
            if node:
                number_of_nodes += 1
                nodes_value += node.val
                cur_depth = depth
                if node.left:
                    nodes.append((node.left, depth + 1))
                if node.right:
                    nodes.append((node.right, depth + 1))
        result.append(nodes_value/number_of_nodes)
        return result

def main():
    sol = Solution()
    root = TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))
    result = sol.averageOfLevels(root)


    print(result)

if __name__ == "__main__":
    main()
