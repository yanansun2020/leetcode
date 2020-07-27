# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from ListNode import ListNode
from TreeNode import TreeNode
class Solution:
    def isSubPath(self, head: ListNode, root: TreeNode) -> bool:
        if not head:
            return True
        if not root:
            return False
        result = self.subPath(head, root)
        if result == True:
            return result
        return self.isSubPath(head, root.left) or self.isSubPath(head, root.right)

    def subPath(self, head, node):
        if not node and head:
            return False
        if not head:
            return True
        if head.val == node.val:
            return self.subPath(head.next, node.left) or self.subPath(head.next, node.right)
        else:
            return False
def main():
    sol = Solution()
    # left = TreeNode(4, None, TreeNode(2, TreeNode(1)))
    # right = TreeNode(2, TreeNode(6), TreeNode(8, TreeNode(1), TreeNode(3)))
    # root = TreeNode(1, left, TreeNode(4, right))

    # head = ListNode(4, ListNode(2, ListNode(8,  ListNode(1, ListNode(1)))))
    # head = ListNode(1, ListNode(4, ListNode(2,  ListNode(6))))
    # head = ListNode(4, ListNode(2, ListNode(3)))
    root = TreeNode(1, None, TreeNode(1, TreeNode(10, TreeNode(9)), TreeNode(1)))
    head = ListNode(1, ListNode(10))
    result = sol.isSubPath(head, root)
    print(result)

if __name__ == "__main__":
    main()
