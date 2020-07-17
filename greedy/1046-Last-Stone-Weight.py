from heapq import heappop, heappush, heapify
from typing import List
class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        max_heap = []
        for stone in stones:
            heappush(max_heap, -stone)
        def smash():
            if len(max_heap) <=1:
                return
            x = -heappop(max_heap)
            y = -heappop(max_heap)
            if x != y:
                stone = abs(x-y)
                heappush(max_heap, -stone)
            smash()
        smash()
        return -heappop(max_heap) if max_heap else 0

def main():
    sol = Solution()
    result = sol.lastStoneWeight([2,7,4,1,8,1])
    print(result)
    result = sol.lastStoneWeight([1,1,1])
    print(result)
    result = sol.lastStoneWeight([1,1,1,1])
    print(result)

if __name__ == "__main__":
    main()