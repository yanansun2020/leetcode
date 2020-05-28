from TreeNode import TreeNode
from typing import List
import collections
#dfs + BFS
# easy to get distance from target to its children
# what about parents to target?-bfs
class Solution:
    result = []
    conn = collections.defaultdict(list)
    def distanceK(self, root: TreeNode, target: TreeNode, K: int) -> List[int]:
        self.result = []
        #DFS get distance from target's children
        self.getDstance(target, K, -1)
        self.conn = collections.defaultdict(list)
        # BFS get distance from target's parents
        self.get_children_parent_map(root, None)

        # find parent of target, The distance from its direct parent to target is 1
        direct_distance = 1
        parent = self.conn.get(target.val)
        while parent:
            target_in_left = False
            if K == direct_distance:
                self.result.append(parent.val)
                return self.result
            if parent.left and parent.left and parent.left.val == target.val:
                target_in_left = True
            if target_in_left:
                self.getDstance(parent.right, K-direct_distance, 0)
            else:
                self.getDstance(parent.left, K-direct_distance, 0)
            target = parent
            parent = self.conn.get(target.val)
            direct_distance = direct_distance + 1
        return self.result

    #get fitable from children of target
    def getDstance(self, node, K, depth):
        if not node:
            return
        depth = depth + 1
        if abs(depth) == K:
            self.result.append(node.val)
            return
        self.getDstance(node.left, K,  depth)
        self.getDstance(node.right,  K,  depth)

    # get childen-parent connection
    def get_children_parent_map(self, root, parent):
        if not root:
            return
        if parent:
            self.conn[root.val] = parent
        else:
            self.conn[root.val] = None
        self.get_children_parent_map(root.left, root)
        self.get_children_parent_map(root.right, root)




def main():
    sol = Solution()
    # left = TreeNode(5, TreeNode(6, None, None), TreeNode(2, TreeNode(7, None, None), TreeNode(4, None, None)))
    # root = TreeNode(3, left, TreeNode(1, TreeNode(0, None, None), TreeNode(8, None, None)))
    # result = sol.distanceK(root, root, 3)
    # print(result)
    # root = TreeNode(0, TreeNode(1, TreeNode(3), TreeNode(2)))
    # result = sol.distanceK(root, TreeNode(2), 2)
    # print(result)
    # root = TreeNode(0, None, TreeNode(1, None, TreeNode(2, None, TreeNode(3))))
    # result = sol.distanceK(root, TreeNode(1, None, TreeNode(2, None, TreeNode(3))), 2)
    # print(result)
    root = TreeNode(0, TreeNode(2), TreeNode(1, TreeNode(3)))
    result =  sol.distanceK(root, TreeNode(3), 3)
    print(result)

if __name__ == "__main__":
    main()