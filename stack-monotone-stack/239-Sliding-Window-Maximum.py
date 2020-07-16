import collections
from typing import List
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        queue = collections.deque()
        result = []
        for i, num in enumerate(nums):
            if not queue:
                queue.append((num, i))
            else:
                if num >= queue[0][0]:
                    queue.clear()
                else:
                    while num >= queue[-1][0]:
                        queue.pop()
                queue.append((num, i))
                if queue[0][1] == i - k:
                    queue.popleft()
            if i >= k-1:
                result.append(queue[0][0])
        return result



def main():
    sol = Solution()
    result = sol.maxSlidingWindow([3, -3, -1, -4], 2)
    print(result)
    result = sol.maxSlidingWindow([1,3,-1,-3,5,3,6,7], 3)
    print(result)
    result = sol.maxSlidingWindow([1,3], 1)
    print(result)
    result = sol.maxSlidingWindow([1], 1)
    print(result)
    result = sol.maxSlidingWindow([], 1)
    print(result)
    result = sol.maxSlidingWindow([1,3,1,2,0,5], 3)
    print(result)
    result = sol.maxSlidingWindow([9,10,9,-7,-4,-8,2,-6], 5)
    print(result)

if __name__ == "__main__":
    main()
