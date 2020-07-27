from typing import List
class Solution:
    def jump(self, nums: List[int]) -> int:
        max_reach = []
        N = len(nums)
        pos = 0
        jumps = 0
        #The position that each num can reached
        for i, num in enumerate(nums):
            max_reach.append(i + num)
            if i + num >= N -1:
                pos = i
                if num != 0 and i != N -1:
                    jumps = 1
                break
        while pos > 0:
            for j in range(0, pos):
                if max_reach[j] >= pos:
                    pos = j
                    jumps += 1
                    break
        return jumps

def main():
    sol = Solution()
    result = sol.jump([1])
    print(result)
    result = sol.jump([0])
    print(result)
    result = sol.jump([2,3,1,1,4])
    print(result)
    result = sol.jump([2,2,1,1,4])
    print(result)

if __name__ == "__main__":
    main()
