class Solution:
    def simplifyPath(self, path: str) -> str:
        if not path:
            return ""
        paths = path.split(sep="/")
        stack = []
        for p in paths:
            if not p:
                continue
            if p == ".":
                continue
            elif p == '..':
                if stack:
                    stack.pop(-1)
            else:
                stack.append(p)
        ans = ""
        for s in stack:
            ans+= ("/" + s)
        return ans if ans else "/"
def main():
    sol = Solution()
    result = sol.simplifyPath("/home/")
    print(result)
    result = sol.simplifyPath("/../")
    print(result)
    result = sol.simplifyPath("/home//foo/")
    print(result)
    result = sol.simplifyPath("/a/./b/../../c/")
    print(result)
    result = sol.simplifyPath("/a/../../b/../c//.//")
    print(result)
    result = sol.simplifyPath("/a//b////c/d//././/..")
    print(result)

if __name__ == "__main__":
    main()
