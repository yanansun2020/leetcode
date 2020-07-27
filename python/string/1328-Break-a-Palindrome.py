class Solution:
    def breakPalindrome(self, palindrome: str) -> str:
        if len(palindrome) == 1:
            return ""
        for index in range(len(palindrome)//2):
            if palindrome[index] != 'a':
                return palindrome[0:index] + 'a' + palindrome[index+1:]
        return palindrome[:-1]+'b'
def main():
    sol = Solution()
    result = sol.breakPalindrome("aaa")
    print(result)
    result = sol.breakPalindrome("abccba")
    print(result)
    result = sol.breakPalindrome("aaaa")
    print(result)

if __name__ == "__main__":
    main()