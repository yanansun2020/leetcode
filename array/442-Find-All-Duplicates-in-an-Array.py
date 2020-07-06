from typing import List
class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        result = []
        N = len(nums)
        for i in range(N):
            num = abs(nums[i])
            if nums[num-1] > 0:
                nums[num-1]  =  nums[num-1] * (-1)
            else:
                result.append(abs(num))
        return result

def main():
    sol = Solution()

    result = sol.findDuplicates([4,3,2,7,8,2,3,1])
    print(result)
    result = sol.findDuplicates([10,2,5,10,9,1,1,4,3,7])
    print(result)
if __name__ == "__main__":
    main()