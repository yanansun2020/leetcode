from typing import List
class Solution:
    def rob(self, nums: List[int]) -> int:
        length = len(nums)
        if length == 0:
            return 0
        if length == 1:
            return nums[0]
        if length == 2:
            return max(nums[0], nums[1])
        # 抢劫每个节点获得的最大利润
        # f(k) = max(previous k-2) + current(k)
        max_value =[]
        # the max value of first k-2 numbers
        max_value_previous = nums[0]
        max_value_ = 0
        for index in range(length):
            if index == 0 or index == 1:
                max_value.append(nums[index])
            else:
                value = max_value[index-2]
                if max_value_previous < value:
                    max_value_previous = value
                max_ = max_value_previous + nums[index]
                if max_ > max_value_:
                    max_value_ = max_
                max_value.append(max_)
        if length == 3:
            return max(max_value_, nums[1])
        return max_value_



def main():
    sol = Solution()
    result = sol.rob([2,7,9,3,1])
    print(result)

if __name__ == "__main__":
    main()
