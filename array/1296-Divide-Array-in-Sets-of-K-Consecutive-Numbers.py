from collections import Counter
from collections import OrderedDict
from typing import List
class Solution:
    def isPossibleDivide(self, nums: List[int], k: int) -> bool:
        memo = (Counter(nums))
        for num in sorted(list(memo.keys())):
            if num in memo:
                for i in range(k - 1, -1, -1):
                    memo[num + i] -= memo[num]
                    if memo[num + i] == 0:
                        del memo[num + i]
                    if memo[num + i] < 0:
                        return False
        return (True if not memo else False)

def main():
    sol = Solution()
    result = sol.isPossibleDivide([1,2,3,3,4,4,5,6], 4)
    print(result)

if __name__ == "__main__":
    main()