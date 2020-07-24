class Solution:
    # similar questions:
    # 29 divide two integers
    def myPow(self, x: float, n: int) -> float:
        if abs(x) < 1e-40:
            return 0
        if n == 0:
            return 1
        if n < 0:
            return self.myPow(1/x, -n)
        lower = self.myPow(x, n//2)
        if n % 2 == 0:
            return lower*lower
        if n % 2 == 1:
            return lower*lower*x
def main():
    sol = Solution()
    result = sol.myPow(2, 10)
    print(result)
    result = sol.myPow(2, -2)
    print(result)
if __name__ == "__main__":
    main()
