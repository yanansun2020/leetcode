from TreeNode import TreeNode
class Solution:
    nodeLists = None
    def subtreeWithAllDeepest(self, root: TreeNode) -> TreeNode:
        self.nodeLists = []
        self.getNode(root,[])
        if not self.nodeLists:
            return None
        result = None
        nodes = self.nodeLists[0]
        for i in range(len(nodes)):
            all_equal = True
            j = 0
            for j in range(len(self.nodeLists) - 1):
                if self.nodeLists[j][i].val != self.nodeLists[j+1][i].val:
                    all_equal = False
                    break
            if all_equal:
                result = self.nodeLists[j][i]
        return result



        return self.result

    def getNode(self, node, nodeList):
        if not node:
            if not self.nodeLists:
                tmp = list(nodeList)
                self.nodeLists.append(tmp)
            else:
                nodes = self.nodeLists[0]
                if len(nodes) < len(nodeList):
                    self.nodeLists = []
                    tmp = list(nodeList)
                    self.nodeLists.append(tmp)
                elif len(nodes) == len(nodeList):
                    tmp = list(nodeList)
                    self.nodeLists.append(tmp)
            return
        nodeList.append(node)
        self.getNode(node.left, nodeList)
        if node.right:
            self.getNode(node.right, nodeList)
        nodeList.pop()



def main():
    sol = Solution()
    # left = TreeNode(5, TreeNode(6, None, None), TreeNode(2, TreeNode(7, None, None), TreeNode(4, None, None)))
    # root = TreeNode(3, left, TreeNode(1, TreeNode(0, None, None), TreeNode(8, None, None)))
    # result = sol.flipMatchVoyage(root, [1,3, 7,6, 2,5,4])
    # root = TreeNode(1, TreeNode(2, None, None), TreeNode(3, None, None))
    # root = TreeNode(1, TreeNode(2, TreeNode(3, None, None), None), None)
    root = TreeNode(1, None, None)
    result = sol.subtreeWithAllDeepest(root)
    print(result)

if __name__ == "__main__":
    main()