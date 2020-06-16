from typing import List
class Solution:
    def maxEqualRowsAfterFlips(self, matrix: List[List[int]]) -> int:
        patterns = {}
        for row in matrix:
            patterns[tuple(row)] = patterns.get(tuple(row),0) + 1
            flip = [1-c for c in row]
            patterns[tuple(flip)] = patterns.get(tuple(flip),0) + 1
        return max(patterns.values())

def main():
    sol = Solution()
    result = sol.maxEqualRowsAfterFlips([[0,0,0],[0,0,1],[1,1,0]])
    print(result)

if __name__ == "__main__":
    main()