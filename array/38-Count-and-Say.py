class Solution:
    def countAndSay(self, n: int) -> str:
        num_str = '1#'
        stack = []
        for i in range(2, n+1):
            tmp_num_str = ''
            for ch in num_str:
                if stack and stack[-1] != ch:
                    length = len(stack)
                    value = stack[0]
                    tmp_num_str += str(length)
                    tmp_num_str += value
                    stack.clear()
                if ch != '#':
                    stack.append(ch)
            num_str = tmp_num_str + "#"
        return num_str[:-1]

def main():
    sol = Solution()
    result = sol.countAndSay(1)
    print(result)
    result = sol.countAndSay(2)
    print(result)
    result = sol.countAndSay(3)
    print(result)
    result = sol.countAndSay(4)
    print(result)
    result = sol.countAndSay(5)
    print(result)

if __name__ == "__main__":
    main()