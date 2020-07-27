class Solution:
    def shortestCommonSupersequence(self, str1: str, str2: str) -> str:
        if not str1 or not str2:
            return 0
        memo, dp = self.getPath(str1, str2)
        # find longest common sequence
        common_sequence_index_2 = []
        common_sequence_index_1 = []
        row = len(str2)
        col = len(str1)
        while row >0 and col >0:
            common_tuple = memo.get((row, col))
            if common_tuple:
                if dp[row][col] != dp[common_tuple[0]][common_tuple[1]]:
                    common_sequence_index_2.append(row - 1)
                    common_sequence_index_1.append(col - 1)
                row = common_tuple[0]
                col = common_tuple[1]

        common_sequence_index_2.sort()
        common_sequence_index_1.sort()
        # concte string
        result = ''
        max_index_2 = common_sequence_index_2[-1]
        max_index_1 = common_sequence_index_1[-1]
        start_2 = 0
        start_1 = 0
        while common_sequence_index_2 and common_sequence_index_1:
            end_2 = common_sequence_index_2[0]
            end_1 = common_sequence_index_1[0]
            result += str2[start_2:end_2]
            result += str1[start_1:end_1]
            result += str2[end_2]
            start_1 = end_1 + 1
            start_2 = end_2 + 1
            common_sequence_index_2.pop(0)
            common_sequence_index_1.pop(0)
        result +=  str2[max_index_2 + 1:]
        result += str1[max_index_1 + 1:]
        return result
    def getPath(self, str1: str, str2: str):
        #record the source of dp[i][j]
        memo = {}
        rows = len(str2)
        cols = len(str1)
        dp = [[0 for col in range(cols + 1)] for row in range(rows + 1)]
        for i in range(rows):
            for j in range(cols):
                if str2[i] == str1[j]:
                    dp[i + 1][j + 1] = dp[i][j] + 1
                    memo[(i+1, j+1)] = (i, j)
                else:
                    if dp[i][j + 1] > dp[i + 1][j]:
                        dp[i + 1][j + 1] = dp[i][j + 1]
                        memo[(i+1, j+1)] = (i, j + 1)
                    else:
                        dp[i + 1][j + 1] = dp[i + 1][j]
                        memo[(i+1, j+1)] = (i + 1, j)
        return memo, dp

def main():
    sol = Solution()
    string1 = "abc"
    result = string1[0:2]
    print(result)
    result = sol.shortestCommonSupersequence("abac","cab")
    print(result)

if __name__ == "__main__":
    main()