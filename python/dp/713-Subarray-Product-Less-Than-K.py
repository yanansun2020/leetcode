from typing import List
class Solution:
    # slide window
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        left, right, ans = 0, 0, 0
        N = len(nums)
        prod = 1
        while right < N:
            prod*=nums[right]
            while left<=right and prod>=k:
                prod//=nums[left]
                left+=1
            ans+=right-left+1
            right+=1
        return ans

# time limit exceeed
    def slideWindow(self, nums: List[int], k: int):
        N = len(nums)
        result = 0
        for i in range(N):
            j = i
            dp = [0] * (N-i)
            while j < N:
                if i == j:
                    dp[j-i] = nums[j]
                else:
                    dp[j-i] = dp[j-i-1] * nums[j]
                if dp[j-i] < k:
                    result += 1
                    j += 1
                else:
                    break
        return result

def main():
    sol = Solution()
    result = sol.numSubarrayProductLessThanK([10, 5, 2, 6], 100)
    print(result)

if __name__ == "__main__":
    main()