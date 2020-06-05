from collections import Counter
from typing import List
class Solution:
    def findLHS(self, nums: List[int]) -> int:
        counter = Counter(nums)
        result = 0
        for k in counter:
            v = counter[k]
            v_puls_one = counter[k+1]
            if v_puls_one and v+v_puls_one > result:
                result = v+v_puls_one
        return result
def main():
    sol = Solution()
    result = sol.findLHS([1,3,2,2,5,2,3,7])
    print(result)

if __name__ == "__main__":
    main()