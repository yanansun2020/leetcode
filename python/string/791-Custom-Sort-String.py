from heapq import heappop, heappush, heapify
from collections import defaultdict
class Solution:
    def customSortString(self, S: str, T: str) -> str:
        memo = defaultdict(int)
        for i in range(len(S)):
            memo[S[i]] = i
        sorted_t = ""
        not_sorted_t = ""
        for i in range(len(T)):
            if T[i] in memo:
                index = self.getIndexofCh(T[i], sorted_t, memo)
                left = sorted_t[0:index]
                right = sorted_t[index:]
                sorted_t = left + T[i] + right
            else:
                not_sorted_t += T[i]
        return sorted_t + not_sorted_t

    def getIndexofCh(self, char,sorted_t, memo):
        left, right = 0, len(sorted_t)
        target_weight = memo[char]
        while left < right:
            mid = left + (right - left)//2
            if target_weight < memo[sorted_t[mid]]:
                right = mid
            else:
                left = mid + 1
        return left

def main():
    sol = Solution()
    result = sol.customSortString("bac", "bbrraabbabbbcd")
    print(result)

if __name__ == "__main__":
    main()