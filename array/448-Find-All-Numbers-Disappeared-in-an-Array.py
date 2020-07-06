from typing import List
# Because 1 <= a[i]<= N, 利用indx，如果数据出现过认为index出现过
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        N = len(nums)
        for i in range(N):
            num = abs(nums[i])
            if nums[num-1] > 0:
                nums[num-1]  =  nums[num-1] * (-1)
        result = []
        for j in range(N):
            if nums[j] > 0 :
                result.append(j + 1)
        return result
def main():
    sol = Solution()

    result = sol.findDisappearedNumbers([4,3,2,7,8,2,3,1])
    print(result)
    # result = sol.search([1,3,1,1,1], 3)
    # print(result)
if __name__ == "__main__":
    main()