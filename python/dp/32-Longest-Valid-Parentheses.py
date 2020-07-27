class Solution:
    def longestValidParentheses(self, s: str) -> int:
        result = 0
        stack = []
        left_parentheses = '('
        right_parentheses = ')'
        stack.append(-1)
        for index in range(len(s)):
            if s[index]== left_parentheses:
                stack.append(index)
                continue
            if s[index] == right_parentheses:
                stack.pop(-1)
                if not stack:
                    stack.append(index)
                else:
                    result = max(result, index-stack[-1])
        return result
def main():
    sol = Solution()
    result = sol.longestValidParentheses("()(()()")
    print(result)

if __name__ == "__main__":
    main()
