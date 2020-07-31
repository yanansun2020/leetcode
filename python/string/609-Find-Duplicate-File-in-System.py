from collections import defaultdict
from typing import List
class Solution:
    def findDuplicate(self, paths: List[str]) -> List[List[str]]:
        ans = []
        if not paths:
            return ans
        memo = defaultdict(list)
        for path in paths:
            path_array = path.split(" ")
            directory = path_array[0]
            for i in range(1, len(path_array)):
                name_content = path_array[i]
                if not name_content:
                    continue
                left_parenthesis = name_content.index('(')
                name = name_content[0:left_parenthesis]
                content = name_content[left_parenthesis + 1: name_content.index(')')]
                memo[content].append(directory + "/" + name)
        for key, value in memo.items():
            if len(value) > 1:
                ans.append(value)
        return ans
def main():
    sol = Solution()
    result = sol.findDuplicate(["root/a 1.txt(abcd) 2.txt(efsfgh)","root/c 3.txt(abdfcd)","root/c/d 4.txt(efggdfh)"])
    print(result)
    result = sol.findDuplicate(["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"])
    print(result)

if __name__ == "__main__":
    main()