from collections import Counter
from typing import List
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        def twoSum(nums1, target):
            memo = dict(Counter(nums1))
            result = []
            visited = set()
            for num in nums1:
                if num in visited:
                    continue
                visited.add(num)
                visited.add(target - num)
                memo[num] -= 1
                vaue = memo.get(target - num)
                if vaue:
                    result.append([num, target - num])
            return result
        nums1 = sorted(nums)
        memo = {}
        result = []
        for index in range(len(nums1)):
            if not memo.get(nums1[index]):
                two_sum_set = twoSum(nums1[index +1:], 0-nums1[index])
                for array in two_sum_set:
                    array.append(nums1[index])
                    result.append(array)
                memo[nums1[index]] = 1
                memo[0-nums1[index]] = 1
        return result


def main():
    sol = Solution()
    result = sol.threeSum([-1, 0, 1, 2, -1, -4])
    print(result)
if __name__ == "__main__":
    main()
