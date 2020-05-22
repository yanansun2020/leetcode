from TreeNode import TreeNode
from typing import List
class Solution:
    result = []
    voyage = []
    def flipMatchVoyage(self, root: TreeNode, voyage: List[int]) -> List[int]:
        self.result = []
        curValue = voyage[0]
        self.voyage = voyage
        if root.val != curValue:
            result = []
            result.append(-1)
            return result
        self.flipMatch(root)
        return self.result

    def flipMatch(self, node):
        if not node:
            return
        curValue = self.voyage[0]
        if node.val != curValue:
            self.result = []
            self.result.append(-1)
        if node.val == curValue:
            self.voyage.pop(0)
            if node.left and node.left.val != self.voyage[0]:
                tmp = node.left
                node.left = node.right
                node.right = tmp
                self.result.append(node.val)
            self.flipMatch(node.left)
            self.flipMatch(node.right)



def main():
    sol = Solution()
    # root = TreeNode(1, TreeNode(2, TreeNode(4, None, None), TreeNode(5, None, None)), TreeNode(3, TreeNode(6, None, None), TreeNode(7, None, None)))
    # result = sol.flipMatchVoyage(root, [1,3, 7,6, 2,5,4])
    # root = TreeNode(1, TreeNode(2, None, None), TreeNode(3, None, None))
    root = TreeNode(1, TreeNode(2, TreeNode(3, None, None), None), None)
    result = sol.flipMatchVoyage(root, [1,3,2])
    print(result)

if __name__ == "__main__":
    main()
