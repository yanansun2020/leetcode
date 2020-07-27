from collections import defaultdict
from typing import List
class Solution:
    # union find
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        parents = list(range(10001))
        rank = [0 for i in range(10001)]
        emial_name = defaultdict(str)
        email_id = defaultdict(int)
        i = 0
        for index, account in enumerate(accounts):
            name = account[0]
            for email in account[1:]:
                emial_name[email] = name
                if email not in email_id:
                    email_id[email] = i
                    i += 1
                self.union(email_id[account[1]], email_id[email], parents, rank)

        ans = defaultdict(list)
        for email in emial_name:
            ans[self.find(email_id[email], parents)].append(email)

        return [[emial_name[v[0]]] + sorted(v) for v in ans.values()]
    #find + path compress
    def find(self, x, parents):
        if x == parents[x]:
            return parents[x]
        parent_index = self.find(parents[x], parents)
        parents[x] = parent_index
        return parents[x]

    def union(self, x, y, parents, rank):
        parent_x = self.find(x, parents)
        parent_y = self.find(y, parents)
        if rank[parent_x] == rank[parent_y]:
            parents[parent_y] = parent_x
            rank[parent_x] += 1
        elif rank[parent_x] > rank[parent_y]:
             parents[parent_y] = parent_x
        else:
             parents[parent_x] = parent_y
def main():
    sol = Solution()
    result = sol.accountsMerge([["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], \
        ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]])
    print(result)
    # result = sol.accountsMerge("232", 8)
    # print(result)
    # result = sol.accountsMerge("105", 5)
    # print(result)
    # result = sol.accountsMerge("00", 0)
    # print(result)
    # result = sol.accountsMerge("3456237490", 9191)
    # print(result)
if __name__ == "__main__":
    main()