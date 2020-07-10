from typing import List
class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        sum_value = sum(nums)
        if sum_value % 2 != 0:
            return False
        partition_value = sum_value //2
        nums.sort()
        dp = [False for i in range(0, partition_value + 1)]
        dp[0] = True
        for num in nums:
            tmp_dp = []
            tmp_dp.append(True)
            for i in range(1, partition_value + 1):
                previous_value = False if i-num <0 else dp[i-num]
                tmp_dp.append(dp[i] or previous_value)
                if i == partition_value and tmp_dp[i] == True:
                    return True
            dp = tmp_dp
        return False

def main():
    sol = Solution()
    result =sol.canPartition([1, 5, 11, 5])
    print(result)
    result =sol.canPartition([1, 2, 3, 5])
    print(result)

if __name__ == "__main__":
    main()

