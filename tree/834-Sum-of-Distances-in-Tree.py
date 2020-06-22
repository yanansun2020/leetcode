from TreeNode import TreeNode

class Solution:
    def sumOfDistancesInTree(self, N: int, edges: List[List[int]]) -> List[int]:
        return []
def main():
    sol = Solution()
    left = TreeNode(1, TreeNode(3), TreeNode(4))
    right = TreeNode(2, TreeNode(5), TreeNode(6))
    root = TreeNode(0, left, right)
    result = sol.smallestFromLeaf(root)

    print(result)

if __name__ == "__main__":
    main()