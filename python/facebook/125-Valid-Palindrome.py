import string
class Solution:
    def isPalindrome(self, s: str) -> bool:
        left, right = 0, len(s)-1
        while left < right:
            left_ch = s[left]
            right_ch = s[right]
            if left_ch.isalnum() and right_ch.isalnum():
                if left_ch.lower() == right_ch.lower():
                    left += 1
                    right -= 1
                else:
                    return False
            elif not left_ch.isalnum():
                left += 1
            elif not right_ch.isalnum():
                right -= 1
        return True
def main():
    sol = Solution()
    result = sol.isPalindrome("0P")
    print(result)
    result = sol.isPalindrome("A man, a plan, a canal: Panama")
    print(result)
    result = sol.isPalindrome("race a car")
    print(result)
if __name__ == "__main__":
    main()

