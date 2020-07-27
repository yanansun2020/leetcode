from collections import Counter
from typing import List
from collections import defaultdict
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        num_set = set(nums)
        max_length = 0
        for i in range(len(nums)):
            tmp = nums[i]
            if tmp -1 not in num_set:
                length = 1
                max_length = max(max_length, length)
                while tmp+1 in num_set:
                    # length += nums_map[tmp+1]
                    length += 1
                    tmp = tmp + 1
                max_length = max(max_length, length)
        return max_length
def main():
    sol = Solution()
    # result = sol.combine(4, 2)
    # print(result)
    result = sol.longestConsecutive([0, 0])
    print(result)
    result = sol.longestConsecutive([100, 4, 200, 1, 3, 2])
    print(result)
    # result = sol.subsets(3,2)
    # print(result)

if __name__ == "__main__":
    main()