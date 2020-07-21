class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        i, j, result, carry = len(num1) -1, len(num2) -1, "", 0
        while i >=0 or j >=0 or carry == 1:
            num1_i = int(num1[i]) if i >= 0 else 0
            num2_j = int(num2[j]) if j >= 0 else 0
            result += str((num1_i + num2_j + carry)%10)
            carry = (num1_i + num2_j + carry)//10
            i -= 1
            j -= 1
        return result[::-1]
def main():
    sol = Solution()
    result = sol.addStrings("99", "1")
    print(result)
    result = sol.addStrings("2", "3")
    print(result)
if __name__ == "__main__":
    main()
