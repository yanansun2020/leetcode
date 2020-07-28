class Solution:
    def minAddToMakeValid(self, S: str) -> int:
        stack = []
        left_parentheses = "("
        right_parentheses = ")"
        result = 0
        for s in S:
            if s == right_parentheses:
                if not stack:
                    result += 1
                else:
                    stack.pop(-1)
            elif s == left_parentheses:
                stack.append(left_parentheses)
        return result + len(stack)

def main():
    sol = Solution()
    result = sol.minAddToMakeValid("())")
    print(result)
    result = sol.minAddToMakeValid("((()))")
    print(result)
    result = sol.minAddToMakeValid("()")
    print(result)
    result = sol.minAddToMakeValid("()))((")
    print(result)


if __name__ == "__main__":
    main()
