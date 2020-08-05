from typing import List
import sys
class Solution:
    # keeep m1< m2 then find a number > m2
    def increasingTriplet_1space(self, nums: List[int]) -> bool:
        m1, m2 = sys.maxsize, sys.maxsize
        for num in nums:
            if num < m1:
                m1 = num
            if num > m1 and num < m2:
                m2 = num
            if num > m2:
                return True
        return False
    # solution 2-dp dp[i] = # nums[0-i] <=nums[i]
    def increasingTriplet(self, nums: List[int]) -> bool:
        dp = [1 for i in range(len(nums))]
        for i in range(len(nums)):
            for j in range(i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i], 1+dp[j])
                if dp[i] >= 3:
                    return True
        return False

def main():
    sol = Solution()
    result = sol.increasingTriplet([1,0,0,10,0, 0, 11])
    print(result)
    result = sol.increasingTriplet([1,2,3,4,5])
    print(result)
    result = sol.increasingTriplet([1,5,3,4])
    print(result)
    result = sol.increasingTriplet([5,4,3,2,1])
    print(result)
if __name__ == "__main__":
    main()