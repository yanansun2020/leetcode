from typing import List
class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        memo = self.find_next_big(nums2)
        result = []
        for num in nums1:
            result.append(memo[num])
        return result

    def find_next_big(self, nums):
        memo = {}
        memo[nums[-1]] = -1
        stack = []
        for i in range(len(nums) - 1, -1, -1):
            if not stack:
                stack.append((i, nums[i]))
            else:
                top_ele = stack[-1]
                while stack and top_ele[1] <= nums[i]:
                    stack.pop()
                    top_ele = stack[-1] if stack else None
                if not stack:
                    memo[nums[i]] = -1
                else:
                    memo[nums[i]] = stack[-1][1]
                stack.append((i, nums[i]))
        return memo
def main():
    sol = Solution()
    result = sol.nextGreaterElement([4,1,2],[1,3,4,2])
    result = sol.nextGreaterElement([2, 4],[1,2,3,4])
    print(result)


if __name__ == "__main__":
    main()
