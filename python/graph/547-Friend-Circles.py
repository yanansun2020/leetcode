from typing import List
class Solution:
    # solution1-dfs
    def findCircleNum(self, M: List[List[int]]) -> int:
        if not M:
            return 0
        rows = len(M)
        cols = len(M[0])
        vistited = []
        count = 0
        for i in range(rows):
            if i in vistited:
                continue
            self.dfs(i, M, vistited)
            count += 1
        return count

    def dfs(self, i, M, vistited):
        neighbors = M[i]
        for j in range(len(neighbors)):
            if M[i][j] == 1:
                if j in vistited:
                    continue
                vistited.append(j)
                self.dfs(j, M, vistited)

    #union find + path compression
    def findCircleNum_union_find(self, M: List[List[int]]) -> int:
        rows = len(M)
        parent = [i for i in range(rows)]
        rank = [0 for i in range(rows)]
        for i in range(rows):
            for j in range(i+1, rows):
                if M[i][j] == 1:
                    self.unionSet(i, j, parent, rank)
        return len(set(self.findSet(i, parent)for i in parent))

    #find node belongs to which parent
    # path compression
    #union-find can be used to detect cycle
    def findSet(self, i, parentSet):
        parent = parentSet[i]
        if parent == i:
            return parent
        p = self.findSet(parent, parentSet)
        parentSet[i] = p
        return p
    #union two sets
    def unionSet(self, i, j, parents, rank):
        parent_i = self.findSet(i, parents)
        parent_j = self.findSet(j, parents)
        if parent_i == parent_j:
            return
        rank_i = rank[i]
        rank_j = rank[j]
        if rank_i == rank_j:
            parents[parent_j] = parent_i
            rank[parent_i] += 1
        if rank_i > rank_j:
            parents[parent_j] = parent_i
        if rank_i < rank_j:
             parents[parent_i] = parent_j

def main():
    sol = Solution()
    array = [[1,1,1,0,1,1,1,0,0,0],
            [1,1,0,0,0,0,0,1,0,0],
            [1,0,1,0,0,0,0,0,0,0],
            [0,0,0,1,1,0,0,0,1,0],
            [1,0,0,1,1,0,0,0,0,0],
            [1,0,0,0,0,1,0,0,0,0],
            [1,0,0,0,0,0,1,0,1,0],
            [0,1,0,0,0,0,0,1,0,1],
            [0,0,0,1,0,0,1,0,1,1],
            [0,0,0,0,0,0,0,1,1,1]]
    result = sol.findCircleNum_union_find(array)
    print(result)
#     result = sol.findCircleNum_union_find([[1,1,0],
#  [1,1,0],
#  [0,0,1]])
#     print(result)
#     result = sol.findCircleNum_union_find([[1,1,0],
#  [1,1,1],
#  [0,1,1]])
#     print(result)


if __name__ == "__main__":
    main()


