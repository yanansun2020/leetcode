from typing import List
# without memo time limit exceeded
class Solution:
    def numMatchingSubseq(self, S: str, words: List[str]) -> int:
        count = 0
        memo = {}
        for word in words:
            if memo.get(word):
                count +=1
                continue
            else:
                if memo.get(word) == False:
                    continue
                if self.isSubsequence(word, S):
                    count +=1
                    memo[word] = True
                else:
                    memo[word] = False
        return count
    def isSubsequence(self, s: str, t: str) -> bool:
        N = len(s)
        if N ==0:
            return True
        index = 0
        while index < N:
            ch = s[index]
            for t_1 in t:
                if t_1 == ch:
                    index +=1
                    if index == N:
                        return True
                    ch = s[index]
            return False
        return False

def main():
    sol = Solution()
    result = sol.numMatchingSubseq("aaaaaaab", ["ab", "ac", "ab", "ac"])
    print(result)

if __name__ == "__main__":
    main()
