import sys
class Solution:
    def reverse(self, x: int) -> int:
        sign = 1
        if x < 0:
            sign = 0
            x = x * (-1)
        result_array = []
        while x != 0:
            integer_part = int(x/10)
            result_array.append(x%10)
            x = integer_part
        result = 0
        for index in range(len(result_array)):
            result += (result_array[index] * pow(10, (len(result_array) - 1- index)))
        result = (result if sign ==1 else result * (-1))
        if result< -2**(31) or result> 2**(31)-1:
            return 0
        return result
def main():
    sol = Solution()
    result = sol.reverse(120)
    print(result)
    print(sys.maxsize)

if __name__ == "__main__":
    main()