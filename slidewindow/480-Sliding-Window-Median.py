from sortedcontainers import SortedList
from typing import List
class Solution:
    def medianSlidingWindow(self, nums: List[int], k: int) -> List[float]:
        if not nums:
            return []
        array = nums[:k]
        array.sort()
        mid = k//2
        result = []
        is_odd = k % 2 == 1
        median = array[mid] if is_odd else (array[mid] + array[mid-1]) /2
        result.append(median)
        for i in range(len(nums) -k):
            discard = nums[i]
            add = nums[i + k]
            self.discard_add(array, discard, add)
            median = array[mid] if is_odd else (array[mid] + array[mid-1]) /2
            result.append(median)
        return result

    def discard_add(self, array, discard, add):
        self.discard(array, discard)
        index = self.add(array, add)
        array.insert(index, add)

    def discard(self, array, discard):
        left, right = 0, len(array)-1
        while left <= right:
            mid = (left + right) //2
            if array[mid] == discard:
                array.pop(mid)
                return
            if array[mid] > discard:
                right = mid -1
            if array[mid] < discard:
                left = mid + 1

    def add(self, array, target):
        left, right = 0, len(array)-1
        while left <= right:
            mid = (left+right)//2
            if array[mid] == target:
                return mid
            if array[mid] > target:
                right = mid -1
            if array[mid] < target:
                left = mid + 1
        return left



    def medianSlidingWindow_1(self, nums: List[int], k: int) -> List[float]:
        if len(nums) == 0:
            return []
        ar = SortedList(nums[:k])
        is_odd = k % 2 == 0
        medians = [(ar[k//2 - 1] + ar[k//2]) / 2.0 if is_odd else ar[k//2]]
        for i in range(len(nums) - k):
            ar.discard(nums[i])
            ar.add(nums[i + k])
            medians.append((ar[k//2 - 1] + ar[k//2]) / 2.0 if is_odd else ar[k//2])
        return medians

def main():
    sol = Solution()
    result = sol.medianSlidingWindow([1,3,-1,-3,5,3,6,7], 3)
    print(result)
    result = sol.medianSlidingWindow([1,4,2,3], 4)
    print(result)

if __name__ == "__main__":
    main()