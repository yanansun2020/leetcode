class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        i, j = 0, 0
        memo = set()
        ans = 0
        while i <len(s):
            if s[i] in memo:
                ans = max(ans, i-j)
                memo.remove(s[j])
                j += 1
            else:
                memo.add(s[i])
                i += 1
        return max(ans, i-j)
            
            
def main():
    sol = Solution()
    result = sol.lengthOfLongestSubstring("pwwkew")
    print(result)
    result = sol.lengthOfLongestSubstring("abc")
    print(result)
    result = sol.lengthOfLongestSubstring("abcabcbb")
    print(result)

if __name__ == "__main__":
    main()