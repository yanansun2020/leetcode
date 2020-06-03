class Solution:
    def monotoneIncreasingDigits(self, N: int) -> int:
        num_str = list(str(N))
        n = len(num_str)
        j = -1
        for i in range(n-1, -1, -1):
            if i -1 < 0:
                break
            if (num_str[i] >= num_str[i - 1]):
                continue
            num_str[i - 1] = str(int(num_str[i - 1]) - 1)
            j = i
        if j > 0:
            for i in range(j, n):
                num_str[i] = '9'
        return int("".join(num_str))

def main():
    sol = Solution()
    result = sol.monotoneIncreasingDigits(10)
    print(result)
    result = sol.monotoneIncreasingDigits(1234)
    print(result)
    result = sol.monotoneIncreasingDigits(332)
    print(result)


if __name__ == "__main__":
    main()
