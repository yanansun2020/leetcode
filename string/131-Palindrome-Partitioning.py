from typing import List
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.result = []
        self.dfs(s, [])
        return self.result

    def dfs(self, s, tmp):
        if not s:
            self.result.append(tmp[:])
            return
        for i in range(1, len(s) + 1):
            if not self.isPalindrome(s[:i]):
                continue
            tmp.append(s[:i])
            self.dfs(s[i:], tmp)
            tmp.pop()

    def isPalindrome(self, s):
        return s == s[::-1]

def main():
    sol = Solution()
    result = sol.partition("aab")
    print(result)

if __name__ == "__main__":
    main()