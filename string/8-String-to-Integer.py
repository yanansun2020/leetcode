class Solution:
    def myAtoi(self, str: str) -> int:
        if not str:
            return 0
        sign = '+'
        number = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
        number_array = []
        i = 0
        while i < len(str):
            if str[i] == ' ':
                i += 1
                continue
            if str[i] == '+' or str[i] == '-':
                sign = str[i]
                if i == len(str)-1 or str[i+1] not in number:
                    return 0
                i += 1
                continue
            if str[i] not in number and not number_array:
                return 0
            while i < len(str) and str[i] in number and str[i] != '-' and str[i] != '+':
                number_array.append(ord(str[i]) - 48)
                i += 1
            break
        result = 0
        for i in range(len(number_array)):
            result += (number_array[i] * pow(10, (len(number_array) -1 - i)))
        if sign == '+':
            if result > pow(2, 31) -1:
                result =  pow(2, 31) -1
        if sign == '-':
            result = result * (-1)
            if result < -pow(2, 31):
                result = -pow(2, 31)
        return result

def main():
    sol = Solution()
    result = sol.myAtoi("    -42  ab  c")
    print(result)
    result = sol.myAtoi("4193 with words")
    print(result)
    result = sol.myAtoi("words and 987")
    print(result)
    result = sol.myAtoi("-91283472332")
    print(result)
    result = sol.myAtoi("+")
    print(result)
    result = sol.myAtoi("+1")
    print(result)
    result = sol.myAtoi("+-1")
    print(result)

if __name__ == "__main__":
    main()