from typing import List
class Solution:
    #trick1 to process the last element, put [0] to heights array
    #trick2: when the stack is empty, length = i
    def largestRectangleArea(self, heights: List[int]) -> int:
        if not heights:
            return 0
        heights.append(0)
        stack = []
        max_area = 0
        for i, height in enumerate(heights):
            if not stack or stack[-1][1] < height:
                stack.append((i, height))
                continue
            while stack and stack[-1][1] >= height:
                top_index, top_ele = stack[-1]
                stack.pop(-1)
                width = i if not stack else i- stack[-1][0]-1
                area = width * top_ele
                max_area = max(max_area, area)
            stack.append((i, height))
        return max_area


def main():
    sol = Solution()
    result = sol.largestRectangleArea([2,1,5,6,2,3])
    print(result)
    result = sol.largestRectangleArea([2,1,5,6,2,2,2,3])
    print(result)
    result = sol.largestRectangleArea([2,1,1])
    print(result)
if __name__ == "__main__":
    main()