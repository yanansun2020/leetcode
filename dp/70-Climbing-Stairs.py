#f(n) = f(n-1) + f(n-2)
class Solution:
    memo={}
    def climbStairs(self, n: int) -> int:
        if n == 1:
            return 1
        if n ==2:
            return 2
        if self.memo.get(n):
            return self.memo.get(n)
        steps = self.climbStairs(n-1) + self.climbStairs(n-2)
        self.memo[n] = steps
        return self.memo.get(n)



def main():
    sol = Solution()
    result = sol.climbStairs(4)
    print(result)

if __name__ == "__main__":
    main()
