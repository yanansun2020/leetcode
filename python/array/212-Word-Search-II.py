from typing import List
class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        trie = Trie()
        for word in words:
            trie.insert(word)
        rows = len(board)
        cols = len(board[0])
        output = []
        for i in range(rows):
            for j in range(cols):
                self.dfs(board, i, j, trie.root, output)
        return output

    def dfs(self, board, i, j, trie, output):
        # print(str(i) + ' ' + str(j))
        if trie.end_node == 1 and trie.end_num > 0:
            output.append(trie.word)
            trie.end_num -= 1
            # trie.end_node = 0
        if i <0 or j < 0 or i>=len(board) or j >= len(board[0]):
            return False
        ch = board[i][j]
        if ch == '$':
            return False
        trie_node = trie.children[ord(ch)- ord('a')]
        if trie_node:
            tmp = str(board[i][j])
            board[i][j] = '$'
            trie = trie_node
            exist = self.dfs(board, i-1, j, trie, output) or\
                self.dfs(board, i+1, j, trie, output) or\
                self.dfs(board, i, j-1, trie, output) or\
                self.dfs(board, i, j+1, trie, output)
            board[i][j] = tmp
        return False


class TrieNode:
    def __init__(self, ch, isEnd, end_number):
        self.ch = ch
        self.children = [None] * 26
        self.end_node = isEnd
        self.end_num = end_number
        self.word = ''
class Trie:
    def __init__(self):
        self.root = TrieNode('', 0, 0)

    def insert(self, word):
        trie = self.root
        for i in word:
            children = trie.children
            index = ord(i) - ord('a')
            if not children[index]:
                children[index] = TrieNode(i, 0, 0)
            trie = children[index]
        trie.word = word
        trie.end_node = 1
        trie.end_num += 1

def main():
    sol = Solution()
    board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
    result = sol.findWords(board, ["oe","oei"])
    print(result)
    result = sol.findWords(board, ["oath","oe","oei","pea","eat","rain", "aa"])
    print(result)
    board = [["s","e","e","n","e","w"],["t","m","r","i","v","a"],["o","b","s","i","b","d"],["w","m","y","s","e","n"],["l","t","s","n","s","a"],["i","e","z","l","g","n"]]
    result = sol.findWords(board, ["bend","benda"])
    print(result)
    # s1 = ["stow","stob","seer","seen","embow","neem","wadna","wave","wene","reem","reest","renew","rine","rive","riva","inerm","irene","vine","vire","avener","avine","bowl","sise","besa","bend","bena","daven","wots","myst","send","teil","sand","sane","sang","anda","anes","anesis","nane"]
    # s2 = ["anda","anes","anesis","avener","avine","bena","bend","benda","besa","besan","bowl","daven","embow","inerm","irene","myst","nane","nanes","neem","reem","reest","renew","rine","riva","rive","riven","sand","sane","sang","seen","seer","send","sise","stob","stow","teil","vine","viner","vire","wadna","wave","wene","wots"]
    # s1.sort()
    # s2.sort()
    # print(s1)
    # print(s2)
if __name__ == "__main__":
    main()