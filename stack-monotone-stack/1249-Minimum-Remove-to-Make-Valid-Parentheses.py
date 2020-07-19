class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        N = len(s)
        left_parenthese = "("
        right_parenthese = ")"
        stack = []
        invalid_array = []
        for i in range(N):
            if s[i] == right_parenthese:
                if not stack:
                    invalid_array.append(i)
                else:
                    stack.pop(-1)
            if s[i] == left_parenthese:
                stack.append(i)
        if stack:
            invalid_array.extend(stack)

        if invalid_array:
            i = 0
            prev_index = -1
            result = ""
            while i < len(invalid_array):
                result += s[prev_index + 1:invalid_array[i]]
                prev_index = invalid_array[i]
                i += 1
            result += s[invalid_array[len(invalid_array)-1] + 1:]
            return result
        else:
            return s

def main():
    sol = Solution()

    result = sol.minRemoveToMakeValid(")))t((u)")
    print(result)
    result = sol.minRemoveToMakeValid("())()(((")
    print(result)
    result = sol.minRemoveToMakeValid("abc")
    print(result)
    result = sol.minRemoveToMakeValid("lee(t(c)o)de)")
    print(result)
    result = sol.minRemoveToMakeValid("a)b(c)d")
    print(result)
    result = sol.minRemoveToMakeValid("))((")
    print(result)
    result = sol.minRemoveToMakeValid("(a(b(c)d)")
    print(result)
if __name__ == "__main__":
    main()
