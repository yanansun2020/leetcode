from typing import List
class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        if not nums:
            return []
        nums.sort()
        N = len(nums)
        max_length = {}
        max_length[nums[0]] = 0
        memo_index = {}
        for i in range(N):
            value = nums[i]
            max_len = 0
            for j in range(i-1, -1, -1):
                if value % nums[j] == 0:
                    if max_length[nums[j]] + 1 > max_len:
                        max_len = max_length[nums[j]] + 1
                        max_length[value] = max_len
                        memo_index[value] = j
                elif j == 0 and not max_length.get(value):
                    max_length[value] = 0
        #find largest index
        key = max(max_length, key=max_length.get)
        result = [key]
        while memo_index.get(key) is not None:
            index_key = memo_index[key]
            result.append(nums[index_key])
            key = nums[index_key]
        return result
def main():
    sol = Solution()
    result = sol.largestDivisibleSubset([3,4,16,8])
    print(result)

if __name__ == "__main__":
    main()