from typing import List
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        dict_seen = dict([(0, -1)])
        count = 0
        result = 0
        for index in range(len(nums)):
            if nums[index] == 0:
                count = count -1
            elif nums[index] == 1:
                count = count + 1
            if count in dict_seen:
                result = max(result, index - dict_seen[count])
            else:
                dict_seen[count] = index
        return result




def main():
    sol = Solution()
    my_dict =dict([(0, -1)])
    my_dict[0]

    result = sol.findMaxLength([0,0,1,0,0,0,1,1])
    print(result)

if __name__ == "__main__":
    main()