from TreeNode import TreeNode
class Solution:
    def findTarget(self, root: TreeNode, k: int) -> bool:
        orderedList = []
        self.getOrderedList(root, orderedList)
        result = False
        for index, value in enumerate(orderedList):
            remain = k - value
            if self.findReminValue(index + 1, len(orderedList) -1, remain, orderedList):
                result = True
                break
        return result

    def findReminValue(self, startIndex, endIndex, target, orderedList):
        if startIndex > endIndex:
            return False
        middle = int(round((startIndex + endIndex)/2))
        middle_value = orderedList[middle]
        if middle_value == target:
            return True
        if middle_value > target:
            return self.findReminValue(startIndex, middle -1, target, orderedList)
        if middle_value < target:
            return self.findReminValue(middle + 1,  endIndex, target, orderedList)

    def getOrderedList(self, node, orderedList):
        if not node:
            return
        self.getOrderedList(node.left, orderedList)
        orderedList.append(node.val)
        self.getOrderedList(node.right, orderedList)

def main():
    sol = Solution()
    root = TreeNode(5, TreeNode(3, TreeNode(2, None, None), TreeNode(4, None, None)), TreeNode(6, None, TreeNode(7, None, None)))
    result = sol.findTarget(root, 9)
    print(result)
    # root = TreeNode(2, TreeNode(1, None, None), TreeNode(3, None, None))
    result = sol.findTarget(root, 3)
    print(result)

if __name__ == "__main__":
    main()