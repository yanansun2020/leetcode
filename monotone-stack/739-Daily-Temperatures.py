from typing import List
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        result = []
        result.append(0)
        stack = []
        for i in range(len(T) - 1, -1, -1):
            if not stack:
                stack.append((i, T[i]))
            else:
                top_ele = stack[-1]
                while stack and top_ele[1] <= T[i]:
                    stack.pop()
                    top_ele = stack[-1] if stack else None
                if not stack:
                    result.append(0)
                else:
                    result.append(stack[-1][0] - i)
                stack.append((i, T[i]))
        result.reverse()
        return result

def main():
    sol = Solution()
    result = sol.dailyTemperatures([73, 74, 75, 71, 69, 72, 76, 73])
    print(result)


if __name__ == "__main__":
    main()
