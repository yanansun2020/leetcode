class Solution:
    def numSub(self, s: str) -> int:
        count = 0
        stack = []
        s = s + '0'
        for i, ch in enumerate(s):
            if ch =='0':
                len_stack = len(stack)
                count += ((len_stack * (len_stack + 1)) //2)
                stack.clear()
            else:
                stack.append(ch)
        return count % (pow(10, 9) + 7)
def main():
    sol = Solution()
    result = sol.numSub("0110111")
    print(result)
    result = sol.numSub("101")
    print(result)
    result = sol.numSub("111111")
    print(result)
    result = sol.numSub("000")
    print(result)
if __name__ == "__main__":
    main()