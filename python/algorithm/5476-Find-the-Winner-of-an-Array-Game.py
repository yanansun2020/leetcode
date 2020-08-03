from collections import defaultdict
from typing import List
import sys
class Solution:
    def getWinner(self, arr: List[int], k: int) -> int:
        memo = defaultdict(int)
        max_v = max(arr)
        while arr[0] != max_v:
            first = arr[0]
            second = arr[1]
            max_value = max(first, second)
            min_value = min(first, second)
            memo[max_value] += 1
            if memo[max_value] == k:
                return max_value
            arr.remove(min_value)
            arr.append(min_value)
        return max_v
        # def getWinner(array):
        #     first = array[0]
        #     if first == max_v:
        #         return first
        #     second = array[1]
        #     max_value = max(first, second)
        #     min_value = min(first, second)
        #     memo[max_value] += 1
        #     if memo[max_value] == k:
        #         return max_value
        #     array.remove(min_value)
        #     array.append(min_value)
        #     return getWinner(array)
        # return getWinner(arr)


def main():
    sol = Solution()
    result = sol.getWinner([1,11,22,33,44,55,66,77,88,99], 1000000000)
    print(result)
    result = sol.getWinner([3,2,1], 10)
    print(result)
    result = sol.getWinner([2,1,3,5,4,6,7], 2)
    print(result)

if __name__ == "__main__":
    main()
