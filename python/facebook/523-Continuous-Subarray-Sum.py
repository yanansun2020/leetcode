from collections import defaultdict
class Solution:
    # accum[i] = sum(arr[0:i])
    # sum(arr[i:j]) = accum(arr[j]) -accum(arr[i])
    # if accmu[i] = ak + b and accum[j] = ck + d
    # sum(arr[i:j]) = (c-a) * k + (d-b)
    # if we want sum(arr[i:j]) = n*k  then d = b, so we should store r[i] = accum[i]%k
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