class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        pre = ListNode(0)
        pre.next = head
        cur = head
        new_head = pre
        while cur:
            cur = cur.next
            if n ==0:
                pre = pre.next
                continue
            if n > 0:
                n -= 1
        pre.next = pre.next.next
        return new_head.next

def main():
    sol = Solution()
    node = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
    result = sol.removeNthFromEnd(node, 2)
    print(result)
    result = sol.removeNthFromEnd(node,3)
    print(result)
if __name__ == "__main__":
    main()
