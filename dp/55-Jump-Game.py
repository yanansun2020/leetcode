from typing import List
from collections import defaultdict
# record the max-reachable point
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if not nums:
            return False
        N = len(nums)
        max_reach = 0
        for i in range(N):
            #0- i + nums[i] are all reachable
            if i > max_reach:
                return False
            max_reach = max(max_reach, i + nums[i])
            if max_reach >= N-1:
                return True
        return False

def main():
    sol = Solution()
    result = sol.canJump([0])
    print(result)
    result = sol.canJump([3,0,8,2,0])
    print(result)
    result = sol.canJump([2,3,1,1,4])
    print(result)
    result = sol.canJump([3,2,1,0,4])
    print(result)

if __name__ == "__main__":
    main()
