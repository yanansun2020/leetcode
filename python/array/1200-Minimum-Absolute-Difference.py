import sys
from typing import List
class Solution:
    def minimumAbsDifference(self, arr: List[int]) -> List[List[int]]:
        if not arr:
            return []
        arr.sort()
        result = []
        N = len(arr)
        minimum_value = sys.maxsize
        for index in range(N):
            if index + 1 < N:
                abs_value = abs(arr[index + 1] - arr[index])
                if abs_value < minimum_value:
                    minimum_value = abs_value
                    result = []
                    result.append([arr[index], arr[index + 1]])
                elif abs_value == minimum_value:
                    result.append([arr[index], arr[index + 1]])
        return result

def main():
    sol = Solution()
    result = sol.minimumAbsDifference([3,8,-10,23,19,-4,-14,27])
    print(result)

if __name__ == "__main__":
    main()