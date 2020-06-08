from typing import List
class Solution:
    #b[i]: the maximum number include nums[i]
    def maxSubArray(self, nums: List[int]) -> int:
        N = len(nums)
        b = [0] * N
        max_value = nums[0]
        b[0] = nums[0]
        for index in range(1, N):
            b[index] = max(b[index-1] + nums[index], nums[index])
            if b[index] > max_value:
                max_value = b[index]
        return max_value



def main():
    sol = Solution()
    result = sol.maxSubArray([-2,1,-3,4,-1,2,1,-5,4])
    print(result)

if __name__ == "__main__":
    main()
