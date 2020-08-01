class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        # store ch and number of ch
        stack = []
        for ch in s:
            if not stack or stack[-1][0] != ch:
                stack.append((ch, 1))
                continue
            s_, count = stack[-1]
            if s_ == ch:
                if count == k -1:
                    stack.pop()
                else:
                    stack[-1] = (ch, count + 1)
        ans = ""
        while stack:
            ans += stack[-1][0] * stack[-1][1]
            stack.pop()
        return ans[::-1]
def main():
    sol = Solution()
    result = sol.removeDuplicates("abcd", 2)
    print(result)
    result = sol.removeDuplicates("deeedbbcccbdaa", 3)
    print(result)
    result = sol.removeDuplicates("pbbcggttciiippooaais", 2)
    print(result)


if __name__ == "__main__":
    main()
