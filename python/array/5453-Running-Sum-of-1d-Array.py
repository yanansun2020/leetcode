class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        if not nums:
            return []
        result = [nums[0]]
        for index in range(1, len(nums)):
            result.append(result[index-1] + nums[index])
        return result

