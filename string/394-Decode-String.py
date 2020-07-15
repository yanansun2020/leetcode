class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        for s_ in s:
            if s_ != ']':
                stack.append(s_)
            else:
                tmp_str = ""
                while stack and stack[-1] != '[':
                    tmp_str += stack[-1]
                    stack.pop(-1)
                stack.pop(-1)
                digit = ""
                while stack and stack[-1].isdigit():
                    digit += stack[-1]
                    stack.pop(-1)
                tmp_str = tmp_str * int(digit[::-1])
                stack.append(tmp_str)
        result = ""
        while stack:
            result += stack[-1]
            stack.pop(-1)
        return result[::-1]
def main():
    sol = Solution()
    result = sol.decodeString("10[q]")
    print(result)
    result = sol.decodeString("3[a]2[bc]")
    print(result)
    result = sol.decodeString("m2[c2[ab]]")
    print(result)
    result = sol.decodeString("3[a2[c]]")
    print(result)
    result = sol.decodeString("2[abc]3[cd]ef")
    print(result)
    result = sol.decodeString("abc3[cd]xyz")
    print(result)

if __name__ == "__main__":
    main()