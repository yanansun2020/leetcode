class Solution:
    def findNthDigit(self, n: int) -> int:
        _len = 1
        cnt = 9
        start = 1
        while n > _len * cnt:
            n -= _len * cnt
            _len += 1
            cnt *= 10
            start *= 10
        start += (n - 1) / _len
        t = str(start)
        return int(t[(n - 1) % _len])

def main():
    sol = Solution()
    result = sol.findNthDigit(551)
    print(result)


if __name__ == "__main__":
    main()
