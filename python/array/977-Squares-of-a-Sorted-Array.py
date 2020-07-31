from typing import List
class Solution:
    # find zero first then merge sort
    def sortedSquares(self, A: List[int]) -> List[int]:
        N = len(A)
        # i, j: negative, positive parts
        j = 0
        while j < N and A[j] < 0:
            j += 1
        i = j - 1
        ans = []
        while 0 <= i and j < N:
            if A[i]**2 < A[j]**2:
                ans.append(A[i]**2)
                i -= 1
            else:
                ans.append(A[j]**2)
                j += 1
        while i >= 0:
            ans.append(A[i]**2)
            i -= 1
        while j < N:
            ans.append(A[j]**2)
            j += 1
        return ans

    def lower_bound(self, target, array):
        left, right = 0, len(array) -1
        while left < right:
            mid = left + (right - left )//2
            if array[mid] < target:
                left += 1
            else:
                right = mid
        return left


def main():
    sol = Solution()
    result = sol.sortedSquares([-4,-1,0,3,10])
    print(result)
    result = sol.sortedSquares([-7,-3,2,3,11])
    print(result)

if __name__ == "__main__":
    main()