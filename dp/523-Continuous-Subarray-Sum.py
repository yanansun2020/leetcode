from collections import defaultdict
from typing import List
class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        if not nums:
            return 0
        sum_ = 0
        memo = defaultdict(int)
        # memo: key = sum value=(frequency, index)
        memo[0] = -1
        for i in range(len(nums)):
            sum_ += nums[i]
            if k != 0:
                sum_ = sum_ % k
            if sum_ in memo:
                if i-memo.get(sum_) >= 2:
                    return True
            else:
                memo[sum_] = i
        return False
def main():
    sol = Solution()
    # result = sol.checkSubarraySum([23, 2, 4, 6, 7], 8)
    # print(result)
    # result = sol.checkSubarraySum([23,2,6,4,7], 0)
    # print(result)
    result = sol.checkSubarraySum([5,0,0], 0)
    print(result)

if __name__ == "__main__":
    main()