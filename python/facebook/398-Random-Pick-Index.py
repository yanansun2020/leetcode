# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.pick(target)
from collections import defaultdict
import random
class Solution:
    def __init__(self, nums: List[int]):
        self.memo = defaultdict(list)
        for index, num in enumerate(nums):
            self.memo[num].append(index)

    def pick(self, target: int) -> int:
        array = self.memo[target]
        return random.choice(array)

