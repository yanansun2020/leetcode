from collections import deque
from typing import List
class Solution:
    #max_queue-decrease keep maximum on the first position
    #min_queue -increase, keep minimum on the first position
    # check if the difference of two first elements are exceeded
    def longestSubarray(self, nums: List[int], limit: int) -> int:
        max_queue = deque()
        min_queue = deque()
        j = 0
        ans = 0
        for i in range(len(nums)):
            while max_queue and nums[i] > max_queue[-1][0]:
                max_queue.pop()
            while min_queue and nums[i] < min_queue[-1][0]:
                min_queue.pop()
            max_queue.append((nums[i], i))
            min_queue.append((nums[i], i))
            if max_queue[0][0] - min_queue[0][0] > limit:
                if max_queue[0][1] == j: max_queue.popleft()
                if min_queue[0][1] == j: min_queue.popleft()
                j += 1
            else:
                ans = max(ans, i - j +1)
        return ans

def main():
    sol = Solution()
    result = sol.longestSubarray([8, 2,4,7], 4)
    print(result)
    result = sol.longestSubarray([10,1,2,4,7,2], 5)
    print(result)
    result = sol.longestSubarray([4,2,2,2,4,4,2,2], 0)
    print(result)

if __name__ == "__main__":
    main()