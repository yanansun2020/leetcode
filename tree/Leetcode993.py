from TreeNode import TreeNode
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        queue = []
        queue.append(root)
        queue.append(None)
        showUpx = False;
        showUpY = False;
        while queue:
            parent = queue.pop(0)
            if parent is None:
                 queue.append(None)
            else:
                left = parent.left
                right = parent.right
                if left:
                    queue.append(left)
                if right:
                    queue.append(right)
                showUpx = (left and left.val == x) or (right and right.val == x)
                showUpY = (left and left.val == y) or (right and right.val == y)
                if showUpx and showUpY:
                    return False
                if showUpx and (not showUpY):
                   return self.isShowUp(queue, y)
                if showUpY and (not showUpx):
                    return self.isShowUp(queue, x)
        return False

    def isShowUp(self, queue, number):
        parent2 = queue.pop(0)
        while parent2 is not None:
            parent2Left = parent2.left
            parent2Right = parent2.right
            if (parent2Left and parent2Left.val == number) \
                or (parent2Right and parent2Right.val == number):
                return True
            parent2 = queue.pop(0)
        return False

def main():
    left = TreeNode(6, TreeNode(7, None, None), None)
    root = TreeNode(1, TreeNode(2, None, TreeNode(4, None, None)), TreeNode(3, None, TreeNode(5, left, None)))
    sol = Solution()
    result = sol.isCousins(root, 4, 7)
    print(result)

if __name__ == "__main__":
    main()