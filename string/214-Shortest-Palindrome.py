class Solution:
    def shortestPalindrome(self, s: str) -> str:
        j = 0
        for i in range(len(s)-1, -1, -1):
            if s[i] == s[j]:
                j += 1
        if (j == len(s) -1):
            return s
        suffix = s[j:]
        prefix = suffix[::-1]
        mid = shortestPalindrome(s[0:j])
        ans = prefix + mid + suffix
        return ans

def main():
    sol = Solution()
    s = "abc"
    # p = s[::-1]
    # print(p)
    result = sol.shortestPalindrome("aacecaaa")
    print(result)

if __name__ == "__main__":
    main()