from collections import defaultdict
import random
from typing import List
import sys
import bisect
class Solution:
    #正常random 函数，每个数字被获取的概率是相同的，带有权重的随机数可以看做 sum（权重）个随机数，但多个随机数可以对应同样的index
    # e.g. list=[1, 3], can be viewed as four random integer[1, 4], when 1 is get, the index =1, when 2,3,4 is get, the index is 2
    def __init__(self, w: List[int]):
        self.dp = []
        for i, ele in enumerate(w):
            if i == 0:
                self.dp.append(ele)
            else:
                self.dp.append(self.dp[i-1] + ele)

    def pickIndex(self) -> int:
        target = random.randint(0, self.dp[-1] -1)
        return bisect.bisect_right(self.dp, target)
        # left, right = 0, len(self.dp) -1
        # while left <= right:
        #     mid = (left + right)//2
        #     left_bound = 0 if mid == 0 else self.dp[mid -1]
        #     if left_bound < target <= self.dp[mid]:
        #         return mid
        #     if self.dp[mid] < target:
        #         left = mid + 1
        #     else:
        #         mid = right -1
        # return None
def main():
    sol = Solution([1,3])
    result = sol.pickIndex()
    print(result)
    result = sol.pickIndex()
    print(result)
    result = sol.pickIndex()
    print(result)
    result = sol.pickIndex()
    print(result)

if __name__ == "__main__":
    main()
    #memory exceed
    # def __init__(self, w: List[int]):
    #     self.memo = defaultdict()
    #     self.length = 0
    #     key = 0
    #     for i, weight in enumerate(w):
    #         while weight > 0:
    #             self.memo[key] = i
    #             key += 1
    #             weight -= 1
    #             self.length += 1

    # def pickIndex(self) -> int:
    #     random_result = random.randint(0,self.length -1)
    #     return self.memo.get(random_result)




# Your Solution object will be instantiated and called as such:
# obj = Solution(w)
# param_1 = obj.pickIndex()