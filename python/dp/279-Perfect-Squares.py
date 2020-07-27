import math
class Solution:
    def numSquares(self, n: int) -> int:
        if n == 0:
            return 1
        if n == 1:
            return 1
        return 0


def main():
    sol = Solution()
    result = 13
    a = math.sqrt(result)
    # result = sol.numSquares(12)
    print(a)

if __name__ == "__main__":
    main()
