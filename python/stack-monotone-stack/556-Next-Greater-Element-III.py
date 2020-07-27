import sys
class Solution:
    def nextGreaterElement(self, n: int) -> int:
        n_str = list(str(n))
        tmp = self.find_smallest_greater(n_str)
        if tmp[0] != -1:
            tmp_1 = n_str[tmp[0]]
            n_str[tmp[0]] = tmp[1][1]
            n_str[tmp[1][0]] = tmp_1
            subarray = []
            for index in range(tmp[0]+ 1, len(n_str)):
                subarray.append(n_str[index])
            subarray.sort()
            result_str = ''
            for index in range(len(n_str)):
                if index < tmp[0] +1:
                    result_str += n_str[index]
                else:
                    result_str += subarray[index - tmp[0] -1]
            return int(result_str) if int(result_str) <= 2147483647 else -1
        return -1

    def find_smallest_greater(self, nums):
        stack = []
        for i in range(len(nums) - 1, -1, -1):
            if not stack:
                stack.append((i, nums[i]))
            else:
                top_ele = stack[-1]
                smallest_greater = None
                while stack and top_ele[1] > nums[i]:
                    smallest_greater = stack.pop()
                    top_ele = stack[-1] if stack else None
                if smallest_greater and smallest_greater[1] > nums[i]:
                    return (i, smallest_greater)
                stack.append((i, nums[i]))
        return (-1, -1)

def main():
    sol = Solution()
    result = sol.nextGreaterElement(1999999999)
    print(result)
    result = sol.nextGreaterElement(21)
    print(result)
if __name__ == "__main__":
    main()
