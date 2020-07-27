import collections
from typing import List
class Solution:
    choice_gene = "ACGT"
    memo = {}
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        if not bank or end not in bank:
            return -1
        self.choice_gene = "ACGT"
        self.memo = {}
        queue = collections.deque()
        queue.append(start)
        gene_depth = {}
        gene_depth[start] = 0
        while queue:
            current_gene = queue.popleft()
            if current_gene == end:
                return gene_depth[current_gene]
            next_gene_list = self.getNextGene(current_gene, bank)
            for gene in next_gene_list:
                if gene == start:
                    continue
                if self.memo.get(gene):
                    continue
                queue.append(gene)
                self.memo[gene] = 1
                gene_depth[gene] = gene_depth[current_gene] + 1
        return 0

    def getNextGene(self, start, bank):
        next_gene_list = []
        for index in range(len(start)):
            left, right = start[:index], start[(index+1):]
            for char in self.choice_gene:
                next_gene = left + char + right
                if next_gene not in bank:
                    continue
                next_gene_list.append(next_gene)
        return next_gene_list



def main():
    sol = Solution()
    result =sol.minMutation("AAAAAAAA","CCCCCCCC",
["AAAAAAAA","AAAAAAAC","AAAAAACC","AAAAACCC","AAAACCCC","AACACCCC","ACCACCCC","ACCCCCCC","CCCCCCCA","CCCCCCCC"])
    # result = sol.ladderLength("hit", "cog", ["hot","dot","dog","lot","log","cog"])
    print(result)

if __name__ == "__main__":
    main()
