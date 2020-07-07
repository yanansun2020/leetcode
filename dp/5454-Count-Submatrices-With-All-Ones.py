from typing import List
class Solution:
    def numSubmat(self, mat: List[List[int]]) -> int:
        rows = len(mat)
        cols = len(mat[0])
        def findPrefixCount(p_arr, arr):
            rows = len(mat)
            cols = len(mat[0])
            for i in range(0, rows):
                for j in range(cols - 1, -1, -1):
                    if not mat[i][j]:
                        continue
                    if j != cols - 1:
                        p_arr[i][j] += p_arr[i][j + 1]
                    p_arr[i][j] += arr[i][j]

        # Array to store required prefix count of
        # 1s from right to left for boolean array
        p_arr = [[0 for i in range(cols)] for j in range(rows)]
        findPrefixCount(p_arr, mat)
        # variable to store the final answer
        ans = 0
        # Loop to evaluate each column of
        # the prefix matrix uniquely.
        # For each index of a column we will try to
        # determine the number of sub-matrices
        # starting from that index and has all 1s
        for j in range(0, cols):
            i = rows - 1
            # Stack to store elements and the count
            # of the numbers they popped
            # First part of pair will be the
            # value of inserted element.
            # Second part will be the count
            # of the number of elements pushed
            # before with a greater value */
            q = []
            # variable to store the number of
            # submatrices with all 1s
            to_sum = 0
            while i >= 0:
                c = 0
                while len(q) != 0 and q[-1][0] > p_arr[i][j]:
                    to_sum -= (q[-1][1] + 1) * (q[-1][0] - p_arr[i][j])
                    c += q[-1][1] + 1
                    q.pop()
                to_sum += p_arr[i][j]
                ans += to_sum
                q.append((p_arr[i][j], c))
                i -= 1
        return ans
def main():
    sol = Solution()
    result = sol.numSubmat([ [1, 0, 1],[1, 1, 0],[1, 1, 0]]  )
    print(result)

if __name__ == "__main__":
    main()
