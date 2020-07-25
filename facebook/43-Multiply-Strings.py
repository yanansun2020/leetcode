class Solution:
    # e.g. 89 * 79 = (80+9) *(70+9) = 80 * 70 + 80 * 9 + 9 * 70 + 9*9
    def multiply(self, num1: str, num2: str) -> str:
        M = len(num1)
        N = len(num2)
        result = 0
        for i in range(M):
            for j in range(N):
                num_i = (ord(num1[i]) - ord('0')) * pow(10, M-i-1)
                num_j = (ord(num2[j]) - ord("0")) * pow(10, N-j -1)
                result += num_i * num_j
        return str(result)
def main():
    sol = Solution()
    result = sol.multiply("10", "3")
    print(result)
    result = sol.multiply("7", "3")
    print(result)
    result = sol.multiply("3", "10")
    print(result)
    result = sol.multiply("2", "3")
    print(result)

if __name__ == "__main__":
    main()
