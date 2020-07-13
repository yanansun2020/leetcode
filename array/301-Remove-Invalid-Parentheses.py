from typing import List
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        if not s:
            return [""]
        result = []
        visited = set()
        l, r = self.getNumberOfInvalid(s)

        def remove(s_, mis_match):
            visited.add(s_)
            if mis_match == 0:
                result.append(s_)
                return
            for i in range(len(s_)):
                tmp_s = s_[:i] + s_[i+1:]
                if tmp_s not in visited:
                    left, right = self.getNumberOfInvalid(tmp_s)
                    if left + right < mis_match:
                        remove(tmp_s, left + right)
        remove(s,  l+r)
        return result

    def getNumberOfInvalid(self, s:str):
        stack = []
        left_parenthese = "("
        right_parenthese = ")"
        l = 0
        r = 0
        for ch in s:
            if not stack and ch == right_parenthese:
                r += 1
                continue
            if ch == left_parenthese:
                stack.append(left_parenthese)
            if ch == right_parenthese:
                stack.pop(-1)
        l = len(stack)
        return l, r

    # def isValid(self, s:str):
    #     if not s:
    #         return True
    #     stack = []
    #     left_parenthese = "("
    #     right_parenthese = ")"
    #     for ch in s:
    #         if not stack and ch == right_parenthese:
    #             return False
    #         if ch == left_parenthese:
    #             stack.append(ch)
    #         if ch == right_parenthese:
    #             stack.pop(-1)
    #     return True if not stack else False



def main():
    sol = Solution()

    result = sol.removeInvalidParentheses("((()((s((((()")
    print(result)
    # result = sol.removeInvalidParentheses("nwq")
    # print(result)
    # result = sol.removeInvalidParentheses("(nwq))")
    # print(result)
    # result = sol.removeInvalidParentheses("()())()")
    # print(result)
    # result = sol.removeInvalidParentheses("(a)())()")
    # print(result)
    # result = sol.removeInvalidParentheses(")(")
    # print(result)
    # result = sol.removeInvalidParentheses("()()))")
    # print(result)
if __name__ == "__main__":
    main()