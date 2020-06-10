#f(1) = 1
#f(2) = 2
# 左子树 BST 数量 × 右子树BST 数量
#f(n) = sum(f(i-1) * f(n-i)) i=(1~n)
class Solution:
    def numTrees(self, n: int) -> int:
        memo = {}
        memo[1] =1
        memo[0] = 1
        if n == 1:
            return 1
        for i in range(2, n+1):
            value = 0
            for j in range(1, i+1):
                value += (memo[j-1] * memo[i-j])
            memo[i] = value
        return memo[n]




def main():
    sol = Solution()
    result = sol.numTrees(4)
    print(result)

if __name__ == "__main__":
    main()