class Solution:
    # dividend = divisor *(2^k +2^k-1...)
    def divide(self, dividend: int, divisor: int) -> int:
        max_int = pow(2, 31) -1
        sign = -1 if ((dividend > 0) ^ (divisor > 0)) else 1
        m = abs(dividend)
        n = abs(divisor)
        if divisor == 1 or divisor == -1:
            result = m * sign
            return result if result < max_int else max_int
        tmp_divisor, result = divisor, 0
        while n <= m:
            t, factor = n, 1
            while m >= (t<<1):
                t <<= 1
                factor <<= 1
            result += factor
            m -= t
        return result * sign

def main():
    sol = Solution()
    # result = sol.divide(-2147483648,-1)
    # print(result)
    # result = sol.divide(1, 1)
    # print(result)
    result = sol.divide(10, 3)
    print(result)
    result = sol.divide(7, -3)
    print(result)
    result = sol.divide(3, 10)
    print(result)
    result = sol.divide(3, -10)
    print(result)
    result = sol.divide(-7, -3)
    print(result)
if __name__ == "__main__":
    main()
