from TreeNode import TreeNode
from typing import List
class Solution:
    memo = {0: [], 1: [TreeNode(0)]}
    def allPossibleFBT(self, N: int) -> List[TreeNode]:
        if N not in Solution.memo:
            ans = []
            for x in range(N):
                y = N - 1 - x
                for left in self.allPossibleFBT(x):
                    for right in self.allPossibleFBT(y):
                        bns = TreeNode(0)
                        bns.left = left
                        bns.right = right
                        ans.append(bns)
            Solution.memo[N] = ans

        return Solution.memo[N]
def main():
    sol = Solution()
    result = sol.allPossibleFBT(7)
    print(result)

if __name__ == "__main__":
    main()