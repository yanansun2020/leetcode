from typing import List
from collections import defaultdict
class TrieNode:
    def __init__(self, isEnd=False, children={}):
        # TrieNode map{a:TreeNode(b)}
        self.children = defaultdict(TrieNode)
        self.isEnd = False
        self.string = ""

class Solution:
    # solution2 trie
    def removeSubfolders(self, folder: List[str]) -> List[str]:
        self.root = TrieNode()
        ans = []
        for fod in folder:
            trieNode = self.root
            paths = fod.split("/")
            flag = False
            for i in range(len(paths)):
                if not paths[i]:
                    continue
                if trieNode.isEnd:
                    if trieNode.string not in ans:
                        ans.append(trieNode.string)
                    flag = True
                    break
                if paths[i] not in trieNode.children:
                    node = TrieNode(isEnd=False, children={})
                    trieNode.children[paths[i]] = node
                trieNode = trieNode.children[paths[i]]
                if i == len(paths)-1:
                    trieNode.isEnd = True
                    trieNode.string = fod
            if not flag:
                ans.append(fod)
        return ans

    # solution 1 :sort
    def removeSubfolders_sort(self, folder: List[str]) -> List[str]:
        folder.sort()
        parent_folder = []
        for fod in folder:
            if self.match_parent_folder(fod, parent_folder) == False:
                parent_folder.append(fod)
        return parent_folder

    def match_parent_folder(self, sub_folder, parent_folder):
        sub_folder = sub_folder + "/"
        # left, right = 0, len(parent_folder)-1
        # while left <= right:
        #     mid = left + (right-left)//2
        #     if parent_folder[mid].split
        for parent in parent_folder:
            parent = parent + "/"
            if len(sub_folder) >= len(parent):
                if sub_folder[0:len(parent)] == parent:
                    return True
        return False

def main():
    sol = Solution()
    result = sol.removeSubfolders(["/a","/a/b","/c/d","/c/d/e","/c/f"])
    print(result)
    result = sol.removeSubfolders(["/a","/a/b/c","/a/b/d"])
    print(result)
    result = sol.removeSubfolders(["/a/b/c","/a/b/ca","/a/b/d"])
    print(result)

if __name__ == "__main__":
    main()