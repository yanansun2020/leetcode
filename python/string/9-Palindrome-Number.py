class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x is None:
            return False
        str_x = str(x)
        left = 0
        right = len(str_x) -1
        while left <= right:
            if str_x[left] != str_x[right]:
                return False
            left += 1
            right -= 1
        return True


def main():
    sol = Solution()
    result = sol.isPalindrome(0)
    print(result)

if __name__ == "__main__":
    main()