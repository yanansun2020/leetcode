#这个题目的核心就是在于必须从叶节点开始处理，因为叶节点只有一个节点是邻居，就是他的父节点，
# 所以要让叶节点变成只有一个coin， 那就必须先把多余或者缺少的coin移到父节点，然后再处理
#if there are leftover in the children node, return the leftover value
#else return need value

from TreeNode import TreeNode

class Solution:
    result = 0
    def distributeCoins(self, root: TreeNode) -> int:
        self.getPath(root)
        return self.result

    def getPath(self, root):
        if not root:
            return 0
        leftover_left = self.getPath(root.left)
        leftover_right = self.getPath(root.right)
        curValue = root.val + leftover_left + leftover_right
        self.result = self.result + abs(leftover_left) + abs(leftover_right)
        return curValue -1
def main():
    sol = Solution()
    result = sol.singleNonDuplicate([1,1,2,3,3])
    print(result)

if __name__ == "__main__":
    main()
