class Solution:
    # *( not valid
    # （* and *) valid
    def checkValidString(self, s: str) -> bool:
        stack_star = []
        stack_parenthesis = []
        left_parenthesis = "("
        right_parenthesis = ")"
        star = "*"
        for i in range(len(s)):
            if s[i] == left_parenthesis:
                stack_parenthesis.append(i)
            elif s[i] == star:
                stack_star.append(i)
            elif s[i] == right_parenthesis:
                if stack_parenthesis:
                    stack_parenthesis.pop(-1)
                else:
                    if not stack_star:
                        return False
                    else:
                        stack_star.pop(-1)
        while stack_parenthesis and stack_parenthesis:
            if stack_parenthesis[-1] > stack_star[-1]:
                return False
            stack_parenthesis.pop(-1)
            stack_star.pop(-1)
        return not stack_parenthesis
def main():
    sol = Solution()

    result = sol.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*")
    print(result)
    result = sol.checkValidString("(((******))")
    print(result)
    result = sol.checkValidString("(*()")
    print(result)
    result = sol.checkValidString("(*))")
    print(result)
    result = sol.checkValidString("(*)")
    print(result)
    result = sol.checkValidString("()")
    print(result)
    result = sol.checkValidString("())")
    print(result)
if __name__ == "__main__":
    main()
