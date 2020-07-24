from typing import List
class Solution:
    def minEatingSpeed(self, piles: List[int], H: int) -> int:
        low_speed, high_speed = 1, pow(10, 9)
        while low_speed < high_speed:
            mid_speed = low_speed + (high_speed - low_speed)//2
            hour = 0
            for pile in piles:
                hour += (pile//mid_speed)
                if pile % mid_speed != 0:
                    hour += 1
            if hour > H:
                low_speed = mid_speed + 1
            else:
                high_speed = mid_speed
        return low_speed

def main():
    sol = Solution()
    result = sol.minEatingSpeed([3,6,7,11], 8)
    print(result)
    result = sol.minEatingSpeed([30,11,23,4,20], 5)
    print(result)
    result = sol.minEatingSpeed([30,11,23,4,20], 6)
    print(result)


if __name__ == "__main__":
    main()
