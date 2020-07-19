from collections import defaultdict
from typing import List
class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        memo = defaultdict()
        for i in range(len(order)):
            memo[order[i]] = i
        for i in range(1, len(words)):
            pre_word = words[i-1]
            cur_word = words[i]
            compre_order = self.compare(pre_word, cur_word, memo)
            if not compre_order:
                return False
        return True

    def compare(self, pre_word, cur_word, memo)->bool:
        pre_length = len(pre_word)
        cur_length = len(cur_word)
        length = min(pre_length, cur_length)
        for i in range(length):
            pre_order = memo[pre_word[i]]
            cur_order = memo[cur_word[i]]
            if pre_order == cur_order:
                continue
            if pre_order < cur_order:
                return True
            else:
                return False
        if i < pre_length -1:
            return False
        return True

def main():
    sol = Solution()
    result = sol.isAlienSorted(["hello","leetcode"], "hlabcdefgijkmnopqrstuvwxyz")
    print(result)
    result = sol.isAlienSorted(["word","world","row"], "worldabcefghijkmnpqstuvxyz")
    print(result)
    result = sol.isAlienSorted(["apple","app"], "abcdefghijklmnopqrstuvwxyz")
    print(result)
    result = sol.isAlienSorted(["wor", "world","word"], "worldabcefghijkmnpqstuvxyz")
    print(result)
if __name__ == "__main__":
    main()