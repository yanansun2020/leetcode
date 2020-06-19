from typing import List
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if not citations:
            return 0
        N = len(citations)
        low = 0
        high = N -1
        while low <= high:
            middle = (low + high) // 2
            if (N- middle) > citations[middle]:
                low = middle + 1
            if (N- middle) < citations[middle]:
                high = middle - 1
            if (N- middle) == citations[middle]:
                return N - middle
        return N - low

def main():
    sol = Solution()
    result = sol.hIndex([0,2])
    print(result)
if __name__ == "__main__":
    main()