from typing import List
class Solution:
    def numSimilarGroups(self, A: List[str]) -> int:
        parents = [i for i in range(len(A))]
        ranks = [0 for i in range(len(A))]
        for i in range(1, len(A)):
            for j in range(0, i):
                if (self.isimilar(A[i], A[j])):
                    self.union(i, j, A, ranks, parents)
        for i in range(len(parents)):
            self.find(i, parents)
        parents_set = set()
        for i in parents:
            parents_set.add(i)
        return len(parents_set)

    def union(self, i, j, A, ranks, parents):
        parent_i = self.find(i, parents)
        parent_j = self.find(j, parents)
        if parent_i != parent_j:
            rank_i = ranks[parent_i]
            rank_j = ranks[parent_j]
            if rank_i == rank_j:
                parents[i] = parent_j
                parents[parent_i] = parent_j
                ranks[j] += 1
            elif rank_i > rank_j:
                parents[j] = parent_i
                parents[parent_j] = parent_i
            else:
                parents[i] = parent_j
                parents[parent_i] = parent_j

    def find(self, i, parents):
        if parents[i] == i:
            return parents[i]
        parent_ = self.find(parents[i], parents)
        parents[i] = parent_
        return parent_

    def isimilar(self, x, y):
        N = len(x)
        i, difference = 0, 0
        while i < N:
            if x[i] != y[i]:
                if difference == 2:
                    return False
                difference += 1
            i+=1
        return True
def main():
    sol = Solution()
    result = sol.numSimilarGroups(["ajdidocuyh","djdyaohuic","ddjyhuicoa","djdhaoyuic","ddjoiuycha","ddhoiuycja","ajdydocuih","ddjiouycha","ajdydohuic"])
    print(result)

    result = sol.numSimilarGroups(["coswcmcgkc","cowkccmsgc","cosgmccwkc","sgmkwcccoc","coswmccgkc"])
    # result = sol.isimilar("cosgmccwkc", "coswmccgkc")
    # result = sol.isimilar("coswcmcgkc", "coswmccgkc")
    # result = sol.isimilar("coswcmcgkc", "cosgmccwkc")
    print(result)
    result = sol.numSimilarGroups(["tars","rats","arts","star"])
    print(result)

if __name__ == "__main__":
    main()
