from typing import List
from collections import defaultdict
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        memo_num1 = defaultdict(int)
        memo_num2 = defaultdict(int)
        for num in nums1:
            memo_num1[num] += 1
        for num in nums2:
            memo_num2[num] += 1
        ans = []
        for key, value in memo_num1.items():
            if key in memo_num2:
                count = min(value, memo_num2[key])
                while count > 0:
                    ans.append(key)
                    count -= 1
        return ans

def main():
    sol = Solution()
    result = sol.intersect([1,2,2,1], [2,2])
    print(result)
    result = sol.intersect([4,9,5], [2,2])
    print(result)

if __name__ == "__main__":
    main()