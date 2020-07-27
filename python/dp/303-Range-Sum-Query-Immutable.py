from typing import List
class NumArray:
    def __init__(self, nums: List[int]):
        if nums:
            self.sum_nums = [nums[0]]
            for i in range(1, len(nums)):
                self.sum_nums.append(self.sum_nums[i-1] + nums[i])

    def sumRange(self, i: int, j: int) -> int:
        if self.sum_nums:
            low = self.sum_nums[i-1] if i-1 >=0 else 0
            return self.sum_nums[j] - low
        return 0
def main():
    sol = NumArray([-2, 0, 3, -5, 2, -1])
    result = sol.sumRange(0,2)
    print(result)
    result = sol.sumRange(2,5)
    print(result)
    result = sol.sumRange(0,5)
    print(result)

if __name__ == "__main__":
    main()

# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(i,j)