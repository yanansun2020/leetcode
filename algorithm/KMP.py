class Solution:
    def build_kmp_table(self, s:str):
        N = len(s)
        lps = [0] * N
        j = 0
        for i in range(1, N):
            while j >0 and s[i] != s[j] :
                j = lps[j-1]
            if j == 0 and s[i] != s[j]:
                lps[i] = j
                continue
            if s[i] == s[j]:
                lps[i] = j + 1
                i += 1
                j += 1
        return lps
def main():
    sol = Solution()
    result = sol.build_kmp_table("acacabacacabacacac")
    print(result)
    s = 'acacabacacabacacac'
    result = sol.build_kmp_table(s)
    print(s[0:result[-1]])
if __name__ == "__main__":
    main()



