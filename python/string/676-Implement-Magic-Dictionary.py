# Your MagicDictionary object will be instantiated and called as such:
# obj = MagicDictionary()
# obj.buildDict(dict)
# param_2 = obj.search(word)
from collections import defaultdict
from typing import List
# Solution1 Trie
# Solution2-HashMap - {.ello-h; h.llo-e; he.lo-l; hel.o-l; hell.-o}
class Trie:
    def __init__(self):
        self.trieMap = defaultdict(Trie)
        self.isEnd = False

    def getNodeByCh(self, ch):
        if ch in self.trieMap:
            return self.trieMap[ch]
        return None
    def appendNode(self, ch, node):
        self.trieMap[ch] = node

    def getMapKeys(self):
        return list(self.trieMap.keys())

class MagicDictionary:

    def __init__(self):
        self.root = Trie()
        self.letters = "abcdefghijklmnopqrstuvwxyz"

    def buildDict(self, dict: List[str]) -> None:
        for word in dict:
            trie = self.root
            for ch in word:
                node = trie.getNodeByCh(ch)
                if not node:
                    node = Trie()
                    trie.appendNode(ch, node)
                trie = node
            trie.isEnd = True

    def search(self, word: str) -> bool:
        trie = self.root
        def dfs(index, trie, word_):
            if index == len(word_):
                return trie.isEnd
            ch = word_[index]
            node = trie.getNodeByCh(ch)
            if not node:
                return False
            return dfs(index + 1, node, word_)

        for index in range(len(word)):
            for s in self.letters:
                if s == word[index]:
                    continue
                word_ = word[0:index] + s + word[index+1:]
                if dfs(0, trie, word_):
                    return True
        return False


    # def dfs(index, trie, has_changed):
    #         if index == len(word):
    #             return trie.isEnd and has_changed
    #         ch = word[index]
    #         node = trie.getNodeByCh(ch)
    #         if node:
    #             return dfs(index + 1, node, has_changed)
    #         else:
    #             if has_changed:
    #                 return False
    #             else:
    #                 ch_candidates = trie.getMapKeys()
    #                 for ch_candidate in ch_candidates:
    #                     result = dfs(index+1, trie.getNodeByCh(ch_candidate), True)
    #                     if result:
    #                         return True
    #                 return False
    #     return dfs(0, trie, False)

def main():
    sol = MagicDictionary()
    # result = sol.buildDict(["hello", "leetcode"])
    # print(result)
    # result = sol.search("hello")
    # print(result)
    # result = sol.search("hhllo")
    # print(result)
    # result = sol.search("hell")
    # print(result)
    # result = sol.search("leetcoded")
    # print(result)
    result = sol.buildDict(["hello","hallo","leetcode"])
    result = sol.search("hello")
    print(result)
    result = sol.search("hhllo")
    print(result)
    result = sol.search("hell")
    print(result)
    result = sol.search("leetcoded")
    print(result)
if __name__ == "__main__":
    main()






