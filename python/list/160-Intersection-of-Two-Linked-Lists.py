class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if headA == None or headB == None:
            return None
        head1 = headA
        head2 = headB
        while head1 != head2:
            if head1 == None:
                head1 = headB
            else:
                head1 = head1.next
            if head2 == None:
                head2 = headA
            else:
                head2 = head2.next
        return head1
def main():
    sol = Solution()
    result = sol.getIntersectionNode("127.0.0.1")
    print(result)

if __name__ == "__main__":
    main()
