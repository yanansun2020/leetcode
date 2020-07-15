from typing import List
class Solution:
    # For each bar, the water it can trapped = min(max(left), max(right)) - bar_height
    def trap(self, height: List[int]) -> int:
        N = len(height)
        left_max = [0]
        for i in range(1, N):
            left_max.append(max( left_max[i-1], height[i-1]))
        right_max = [0 for i in range(N)]
        for i in range(N-2, -1, -1):
            right_max[i] = max(right_max[i+1], height[i+1])
        sum_water = 0
        for i, h in enumerate(height):
            water = min(left_max[i], right_max[i]) -height[i]
            sum_water += (water if water > 0 else 0)
        return sum_water

def main():
    sol = Solution()
    result = sol.trap([0,1,0,2,1,0,1,3,2,1,2,1])
    print(result)
    result = sol.trap([1,2])
    print(result)

if __name__ == "__main__":
    main()