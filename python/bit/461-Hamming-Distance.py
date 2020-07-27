#t & (t-1) 可以计算二进制数字中1 的个数
class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        result, t = 0, x^y
        while t:
            t = t & (t-1)
            result += 1
        return result
def main():
    sol = Solution()
    result = sol.hammingDistance(1, 4)
    print(result)

if __name__ == "__main__":
    main()