# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)
from collections import defaultdict
from string import ascii_lowercase
class TrieNode:
    def __init__(self, isEnd=False, children={}):
        # TrieNode map{a:TreeNode(b)}
        self.children = defaultdict(TrieNode)
        self.isEnd = False

    def getNodeByCh(self, ch):
        if ch in self.children:
            return self.children[ch]
        return None

    def insertCh(self, ch, trieNode):
        self.children[ch] = trieNode

class WordDictionary:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()

    def addWord(self, word: str) -> None:
        """
        Adds a word into the data structure.
        """
        node = self.root
        for ch in word:
            trieNode = node.getNodeByCh(ch)
            if not trieNode:
                trieNode = TrieNode()
                node.insertCh(ch, trieNode)
            node = trieNode
        node.isEnd = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
        """
        node = self.root
        return self.dfs(0, word, node)

    def dfs(self,start, word, node):
        if start == len(word) and node.isEnd == True:
            return True
        for index in range(start, len(word)):
            if word[index] != ".":
                trieNode = node.getNodeByCh(word[index])
                if not trieNode:
                    return False
                return self.dfs(start + 1, word, trieNode)
            else:
                for ch in ascii_lowercase:
                    trieNode = node.getNodeByCh(ch)
                    if trieNode:
                        result = self.dfs(start + 1, word, trieNode)
                        if result:
                            return True
                return False

    def search_whole_word(self, word):
        node = self.root
        for ch in word:
            trieNode = node.getNodeByCh(ch)
            if not trieNode:
                return False
            node = trieNode
        if node.isEnd:
            return True
        return False

def main():
    sol = WordDictionary()
    result = sol.addWord("bad")
    print(result)
    result = sol.addWord("dad")
    print(result)
    result = sol.addWord("mad")
    print(result)

    # result = sol.addWord("abgd")
    # print(result)
    result = sol.search("pad")
    print(result)
    result = sol.search("bad")
    print(result)
    result = sol.search(".ad")
    print(result)
    result = sol.search("b..")
    print(result)
    # result = sol.search("abg")
    # print(result)
    # result = sol.search("abgd")
    # print(result)
    # result = sol.search("abgh")
    # print(result)
if __name__ == "__main__":
    main()
