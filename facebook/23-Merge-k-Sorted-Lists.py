# Definition for singly-linked list.
#TODO
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        def mergeTwoList(node1:ListNode, node2:ListNode):
            p1 = node1
            prev = node1
            p2 = node2
            while p1 and p2:
                if p1.val == p2.val:
                    tmp = p1.next
                    p1.next = p2
                    p2 = p2.next
                    p1.next.next = tmp
                if p1.val > p2.val:
                    prev.next = p2
                    while p2:
                        if p2.val < p1.val:
                            p2 = p2.next
                    prev.next.next = p1

                prev = p1
                p1 = p1.next
