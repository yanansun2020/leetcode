import collections
from typing import List
class Solution:
    def minInteger(self, num: str, k: int) -> str:
        result = self.findMin(num, k, 0)
        return result
    def findMin(self, nums: str, k: int, start:int):
        if k == 0 or start == len(nums):
            return nums
        array = []
        for i in nums:
            array.append(i)
        array.sort()
        str_1 = ''.join(str(e) for e in array)
        if str_1 == nums:
            return nums
        memo = collections.defaultdict(list)
        for i in range(start,len(nums)):
            memo[nums[i]].append(i)
        memo = dict(sorted(memo.items(), key=lambda x:x[0]))
        min_value = list(memo.keys())[0]
        # 最高位不是最小值
        if nums[start] != memo:
            for key, value in memo.items():
                #试图将最小值换到最高位， 否则换次小值
                sorted(value)
                v = value[0]
                if v-start <= k:
                    nums = nums[0:start] + nums[v:v+1] + nums[start:v] + nums[v+1:]
                    # tmp = nums[0]
                    # nums[0] = key
                    # nums[v] = tmp
                    k -= (v-start)
                    start +=1
                    break
        else:
            start += 1
        return self.findMin(nums, k, start)
def main():
    sol = Solution()
    result = sol.minInteger("4321", 4)
    print(result)
    result = sol.minInteger("100", 3)
    print(result)
    result = sol.minInteger("36789", 3)
    print(result)
    result = sol.minInteger("9438957234785635408", 23)
    print(result)

if __name__ == "__main__":
    main()