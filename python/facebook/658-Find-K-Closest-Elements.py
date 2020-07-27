from typing import List
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        left, right = 0, len(arr) - k
        while left < right:
            mid = left + (right-left)//2
            if x-arr[mid] > arr[mid + k] -x:
                left = mid + 1
            else:
                right = mid
        return arr[left:left+ k]
def main():
    sol = Solution()
    result = sol.findClosestElements([1,2,3,4,5], 4, 3)
    print(result)

if __name__ == "__main__":
    main()
