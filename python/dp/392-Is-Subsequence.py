class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        N = len(s)
        if N ==0:
            return True
        index = 0
        while index < N:
            ch = s[index]
            for t_1 in t:
                if t_1 == ch:
                    index +=1
                    if index == N:
                        return True
                    ch = s[index]
            return False

        return False


def main():
    sol = Solution()
    result = sol.isSubsequence("mbc", "ahbgdc")
    print(result)

if __name__ == "__main__":
    main()
