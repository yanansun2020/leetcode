from typing import List
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        dp = list(digits)
        dp = [0]+dp
        N = len(dp)
        i = N -1
        carry = 1 if dp[i] == 9 else 0
        if carry == 0:
            dp[-1] = dp[-1] + 1
            return dp[1:]
        while i >=0 and dp[i] == 9:
            dp[i] = 0
            carry = 1
            i -= 1
        if carry == 1:
            dp[i] = dp[i] + 1
        return dp if dp[0] != 0 else dp[1:]

def main():
    sol = Solution()
    result = sol.plusOne([1,2,3])
    print(result)
    result = sol.plusOne([9])
    print(result)
    result = sol.plusOne([2,9,9])
    print(result)
    result = sol.plusOne([4,3,2,1])
    print(result)
    result = sol.plusOne([3, 2,9,9])
    print(result)
    result = sol.plusOne([9,9])
    print(result)
if __name__ == "__main__":
    main()
