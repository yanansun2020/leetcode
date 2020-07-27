from typing import List
class NumArray:
    def __init__(self, nums: List[int]):
        if nums:
            self.tmp = nums
            self.sum_nums = [nums[0]]
            for i in range(1, len(nums)):
                self.sum_nums.append(self.sum_nums[i-1] + nums[i])

    def sumRange(self, i: int, j: int) -> int:
        if self.sum_nums:
            low = self.sum_nums[i-1] if i-1 >=0 else 0
            return self.sum_nums[j] - low
        return 0

    def update(self, i: int, val: int) -> None:
        if self.tmp:
            difference = val - self.tmp[i]
            for index in range(i, len(self.sum_nums)):
                self.sum_nums[index] =  self.sum_nums[index] + difference
            self.tmp[i] = val

def main():
    sol = NumArray([7,2,7,2,0])
    result = sol.sumRange(0,2)
    print(result)
    result = sol.update(4, 6)
    result = sol.update(0, 2)
    result = sol.update(0, 9)
    print(result)
    result = sol.sumRange(4, 4)
    result = sol.update(3, 8)
    result = sol.sumRange(0, 4)
    print(result)

if __name__ == "__main__":
    main()

# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# obj.update(i,val)
# param_2 = obj.sumRange(i,j)