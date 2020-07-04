from collections import Counter
class Solution:
    def longestPalindrome(self, s: str) -> int:
        memo = dict(Counter(s))
        result = 0
        odd_occur = False
        for k, v in memo.items():
            divide = int(v/2)
            mod = v % 2
            if mod == 0:
                result += v
                continue
            else:
                odd_occur = True
                result += (divide * 2)
        return result if odd_occur == False else result + 1

def main():
    sol = Solution()
    result = sol.longestPalindrome("aaabbccccdd")
    print(result)

if __name__ == "__main__":
    main()