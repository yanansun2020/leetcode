class Solution:
    def validPalindrome(self, s: str) -> bool:
        def isPalindrome(left, right):
            while left <= right:
                if s[left] != s[right]:
                    return False
                else:
                    left += 1
                    right -= 1
            return True

        left, right = 0, len(s) -1
        while left <= right:
            if s[left] == s[right]:
                left += 1
                right -= 1
            else:
                return isPalindrome(left + 1, right) or isPalindrome(left, right-1)
        return True

def main():
    sol = Solution()
    result = sol.validPalindrome("aba")
    print(result)
    result = sol.validPalindrome("abdmcma")
    print(result)
    result = sol.validPalindrome("abmcma")
    print(result)
    result = sol.validPalindrome("abca")
    print(result)

if __name__ == "__main__":
    main()
