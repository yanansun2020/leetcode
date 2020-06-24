from collections import Counter
class Solution:
    def buddyStrings(self, A: str, B: str) -> bool:
        if not A or not B:
            return False
        if A == B:
            count_A = dict(Counter(A).most_common())
            k = list(count_A.keys())[0]
            if count_A.get(k) > 1:
                return True
            return False
        N_A = len(A)
        N_B = len(B)
        if N_A != N_B:
            return False
        no_equal_tupe  = []
        for index in range(N_A):
            if A[index] != B[index]:
                no_equal_tupe.append((A[index], B[index]))
        if len(no_equal_tupe) != 2:
            return False
        if no_equal_tupe[0][0] == no_equal_tupe[1][1] and\
             no_equal_tupe[0][1] == no_equal_tupe[1][0]:
            return True
        return False

def main():
    sol = Solution()
    result = sol.buddyStrings("aab", "aab")
    print(result)

if __name__ == "__main__":
    main()