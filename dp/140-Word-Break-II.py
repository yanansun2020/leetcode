from typing import List
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        if not s or not wordDict:
            return []
        self.words = []
        N = len(s)
        dp = [False] * (N + 1)
        dp[0] = True
        memo = {}
        for length in range(1, N + 1):
            path = memo.get(length)
            if not path:
                path = []
            for i in range(length):
                if dp[i] and s[i:length] in wordDict:
                    path.append((i, length))
                    memo[length] = path
                    dp[length] = True
        #back tracing
        self.dfs(memo, N, [], s)
        # assemble result
        result = []
        if self.words:
            for word_ in self.words:
                result.append(" ".join(reversed(word_)))
        return result

    def dfs(self, memo, key, result, s):
        if key == 0:
            tmp_result = list(result)
            self.words.append(tmp_result)
        if not memo.get(key):
            return
        for tuple_ in memo.get(key):
            result.append(s[tuple_[0]:tuple_[1]])
            self.dfs(memo, tuple_[0], result, s)
            result.pop(-1)

def main():
    sol = Solution()
    result = sol.wordBreak("catsanddog",["cats", "dog", "sand", "and", "cat"])
    print(result)
    result = sol.wordBreak("pineapplepenapple", ["apple", "pen", "applepen", "pine", "pineapple"])
    print(result)
    result = sol.wordBreak("catsandog",["cats", "dog", "sand", "and", "cat"])
    print(result)

if __name__ == "__main__":
    main()