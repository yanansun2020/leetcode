from typing import List
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        tmp_result = []
        stack = []
        nums.extend(nums)
        N = len(nums)
        for i in range(N- 1, -1, -1):
            if not stack:
                stack.append((i, nums[i]))
            else:
                top_ele = stack[-1]
                while stack and top_ele[1] <= nums[i]:
                    stack.pop()
                    top_ele = stack[-1] if stack else None
                if not stack:
                    tmp_result.append(-1)
                else:
                    tmp_result.append(stack[-1][1])
                stack.append((i, nums[i]))
        tmp_result.reverse()
        result = []
        for i in range(N//2):
            result.append(tmp_result[i])
        return result

def main():
    sol = Solution()
    result = sol.nextGreaterElements([5,4,3,2,1])
    print(result)
if __name__ == "__main__":
    main()
