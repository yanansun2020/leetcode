class Solution:
    def missingElement(self, nums:List[int], k:int)->int:
        if not nums:
            return 0
        # find the number of missing numbers in the array
        N = len(nums)
        count_missing = (nums[N-1] - nums[0] + 1) - N
        if count_missing > k:
            return nums[N-1] + (k- count_missing)
        left, right = 0, N-1
        while left + 1< right:
            mid = left + (right-left)//2
            missing_number_middle_to_left = (nums[mid]-nums[left] + 1) - (mid-left+1)
            if missing_number_middle_to_left < k:
                left = mid
                k -= missing_number_middle_to_left
            if missing_number_middle_to_left >= k:
                right = mid
        return nums[left] + k

