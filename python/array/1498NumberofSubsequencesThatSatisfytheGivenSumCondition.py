from typing import List
class Solution:
    def numSubseq_1(self, nums: List[int], target: int) -> int:
        nums.sort()
        self.count = 0

        def getNumSeq(start, array):
            if start == len(nums):
                return
            for i in range(start, len(nums)):
                if not array:
                    if nums[i] + nums[i] > target:
                        return
                else:
                    if array[0] + nums[i] > target:
                        return
                self.count += 1
                getNumSeq(i+1, array + [nums[i]])
        getNumSeq(0, [])
        return self.count

    def numSubseq(self, nums: List[int], target: int) -> int:
        nums.sort()
        self.count = 0

        def getNumSeq(start, array):
            if start == len(nums):
                return
            for i in range(start, len(nums)):
                array.append(nums[i])
                if array[0] + array[-1] > target:
                    return
                self.count += 1
                getNumSeq(i+1, array)
                array.pop(-1)
        getNumSeq(0, [])
        return self.count

def main():
    sol = Solution()
    result = sol.numSubseq([3,5,6,7], 9)
    result = sol.numSubseq([3,3,6,8], 10)
    print(result)
    result = sol.numSubseq([2,3,3,4,6,7], 12)
    print(result)
    result = sol.numSubseq([5,2,4,1,7,6,8], 16)
    print(result)
if __name__ == "__main__":
    main()

