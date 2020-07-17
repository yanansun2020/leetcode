class Solution:
    def knightDialer(self, N: int) -> int:
        d = {0:[4,6],1:[6,8],2:[7,9],3:[4,8],4:[0,3,9],5:[],6:[0,1,7],7:[2,6],8:[1,3],9:[2,4]}
        dp = [[0]*10 for _ in range(N)]
        mod = 10**9 + 7
        for i in range(10): dp[0][i] = 1

        for i in range(1, N):
            for j in range(10):
                for nex in d[j]:
                    dp[i][j] += dp[i-1][nex]
                dp[i][j] %= mod

        return sum(dp[N-1]) % mod
def main():
    sol = Solution()
    result = sol.knightDialer(2)
    print(result)

if __name__ == "__main__":
    main()