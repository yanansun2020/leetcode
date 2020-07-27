class Solution:
    def reverseBits(self, n: int) -> int:
        ret, power = 0, 31
        while n:
            ret += (n & 1) << power
            n = n >> 1
            power -= 1
        return ret
def main():
    sol = Solution()
    result = sol.reverseBits(2)
    print(result)
    k = 2 << 1
    print(pow(2, 30))

if __name__ == "__main__":
    main()