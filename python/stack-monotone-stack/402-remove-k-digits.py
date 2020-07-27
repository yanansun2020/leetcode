class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        if not num:
            return 0
        stack = []
        for ch in num:
            if k <= 0:
                stack.append(ch)
                continue
            if not stack:
                stack.append(ch)
                continue
            tmp = stack[-1]
            if ch >= tmp:
                stack.append(ch)
            else:
                while stack and ch < tmp and k > 0:
                    stack.pop()
                    k = k -1
                    if stack:
                        tmp = stack[-1]
                    else:
                        tmp = None
                stack.append(ch)
        while k > 0:
            stack.pop()
            k = k -1
        if not stack:
            return '0'
        result = ''
        for ch in stack:
            result += ch
        result = result.lstrip('0')
        if result:
            return result
        else:
            return "0"

def main():
    sol = Solution()
    result = sol.removeKdigits("112", 1)
    print(result)
    result = sol.removeKdigits("1432219", 3)
    print(result)
    result = sol.removeKdigits("10200", 1)
    print(result)
    result = sol.removeKdigits("10", 2)
    print(result)

if __name__ == "__main__":
    main()

