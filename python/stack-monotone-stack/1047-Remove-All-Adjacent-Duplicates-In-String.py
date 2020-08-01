class Solution:
    def removeDuplicates(self, S: str) -> str:
        stack = []
        for ch in S:
            if not stack:
                stack.append(ch)
                continue
            if ch == stack[-1]:
                stack.pop()
            else:
                stack.append(ch)
        return "".join(stack)

def main():
    sol = Solution()
    result = sol.removeDuplicates("abbaca")
    print(result)
    result = sol.removeDuplicates("deeedbbcccbdaa")
    print(result)
    result = sol.removeDuplicates("pbbcggttciiippooaais")
    print(result)
if __name__ == "__main__":
    main()
