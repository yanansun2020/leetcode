from typing import List
from collections import defaultdict
# 总共32位，计算每一位上1 的个数，剩下的是0 的个数， num(1) * num(0) = total number on that bit
# then calculate sum
class Solution:
    def totalHammingDistance(self, nums: List[int]) -> int:
        N = 32
        dp = [0 for i in range(N)]
        reult = 0
        length = len(nums)
        for num in nums:
            for i in range(31, -1, -1):
                if num == 0:
                    break
                dp[i] += (num & 1)
                num >>= 1
        for j in range(31, -1, -1):
            reult += (dp[j] * (length - dp[j]))
        return reult




    def totalHammingDistance_TLE(self, nums: List[int]) -> int:
        result = 0
        memo = defaultdict()
        def hammingDistance(x: int, y: int) -> int:
            result, t = 0, x^y
            while t:
                t = t & (t-1)
                result += 1
            return result

        for i in range(0, len(nums)):
            for j in range(i, len(nums)):
                x = nums[i]
                y = nums[j]
                if i == j or x ==y:
                    result += 0
                else:
                    key = str(x) + '+' + str(y)
                    if memo.get(key) is not None:
                        result += memo.get(key)
                    else:
                        distance = hammingDistance(x, y)
                        result += distance
                        memo[key] = distance
        return result
def main():
    sol = Solution()
    result = sol.totalHammingDistance([ 4, 14, 2])
    print(result)
    result = sol.totalHammingDistance([6,1,8,6,8])
    print(result)
    result = sol.totalHammingDistance([5, 4])
    print(result)



if __name__ == "__main__":
    main()