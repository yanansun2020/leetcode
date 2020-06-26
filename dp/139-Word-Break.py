# find by length
from typing import List
class Solution:
    # code below use dp
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if not s or not wordDict:
            return False
        N = len(s)
        dp = [False] * (N+1)
        dp[0] = True
        for length in range(1, len(s) + 1):
            for i in range(0, length):
                if dp[i] and s[i:length] in wordDict:
                    dp[length] = True
                    break
        return dp[N]

    # code below use recursive
    def wordBreak_recursive(self, s: str, wordDict: List[str]) -> bool:
        self.memo = {}
        if not s or not wordDict:
            return False
        return self.dfs(s, wordDict)

    def dfs(self, word, dict):
        if not word:
            return True
        if self.memo.get(word):
            return self.memo.get(word)
        for length in range(1, len(word) + 1):
            tmp = word[0:length]
            if tmp in dict:
                self.memo[tmp] = True
                if self.dfs(word[length:], dict):
                    return True
        self.memo[word] = False
        return False

def main():
    sol = Solution()
    # result = sol.wordBreak("catsandog",["cats", "dog", "sand", "and", "cat"])
    # print(result)
    result = sol.wordBreak("leetcode", ["leet", "code"])
    print(result)
    # result = sol.wordBreak("applepenapple123",["apple", "pen"])
    # print(result)

if __name__ == "__main__":
    main()

