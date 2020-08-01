from typing import List
from collections import defaultdict
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        memo_num1 = defaultdict(int)
        ans = []
        for num in nums1:
            memo_num1[num] += 1
        for num in nums2:
            if num in memo_num1 and memo_num1[num]>0:
                ans.append(num)
                memo_num1[num] -= 1
        return ans

def main():
    sol = Solution()
    result = sol.intersect([1,2,2,1], [2,2])
    print(result)
    result = sol.intersect([4,9,5], [9,4,9,8,4])
    print(result)

if __name__ == "__main__":
    main()