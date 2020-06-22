from collections import Counter
from TreeNode import TreeNode
#serilize a tree in pre order
class Solution(object):
    def findDuplicateSubtrees(self, root):
        count = Counter()
        ans = []
        def collect(node):
            if not node: return "#"
            serial = "{},{},{}".format(node.val, collect(node.left), collect(node.right))
            count[serial] += 1
            if count[serial] == 2:
                ans.append(node)
            return serial

        collect(root)
        return ans

def main():
    sol = Solution()
    left = TreeNode(2, TreeNode(4))
    right = TreeNode(3, TreeNode(4, TreeNode(4)), TreeNode(4))
    root = TreeNode(1, left, right)
    result = sol.findDuplicateSubtrees(root)
    print(result)

if __name__ == "__main__":
    main()