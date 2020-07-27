#prefix tree
class Trie:
    children = []
    val = 0
    root = []
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.val = 0
        self.children=[]

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        root_1 = self.root
        for ch in word:
            children_1 = root_1.children
            if not children_1 or not children_1[ch -'a']:
                trie = Trie(1)
                root_1.children[ch -'a'] = trie
            else:
                root1 = children_1[ch -'a']

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """


    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """



def main():
    trie = Trie()
    result = trie.insert("leetcode")
    print(result)

if __name__ == "__main__":
    main()