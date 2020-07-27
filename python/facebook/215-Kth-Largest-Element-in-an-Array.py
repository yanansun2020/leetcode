from heapq import heappush,heappop,heapify
from typing import List
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        max_heap = []
        for num in nums:
            heappush(max_heap, num)
            if len(max_heap) > k:
                heappop(max_heap)
        return max_heap[0]

def main():
    sol = Solution()
    result = sol.findKthLargest([3,2,1,5,6,4], 2)
    print(result)
    result = sol.findKthLargest([3,2,3,1,2,4,5,5,6], 4)
    print(result)
if __name__ == "__main__":
    main()
