class Solution:
    def addBinary(self, a: str, b: str) -> str:
        i, j, sum, carry = len(a)-1, len(b)-1, "", 0
        while i >=0 or j >=0 or carry ==1:
            int_a = int(a[i]) if i >=0 else 0
            int_b = int(b[j]) if j >=0 else 0
            sum += str((int_a + int_b + carry)%2)
            carry = ((int_a + int_b + carry)//2)
            i -= 1
            j -=1
        return sum[::-1]

    def addBinary_complex(self, a: str, b: str) -> str:
        i = len(a) -1
        j = len(b) -1
        difference = abs(i-j)
        zeros = ""
        for dif in range(difference):
            zeros += "0"
        if i > j:
            b = zeros + b
        if i < j:
            a = zeros + a
        length = len(a)
        result = [0 for i in range(length + 1)]
        i, k = length -1, length
        factor = 0
        while i >=0:
            int_a = int(a[i])
            int_b = int(b[i])
            if int_a + int_b + factor == 2:
                result[k] = 0
                factor = 1
            elif int_a + int_b + factor == 3:
                result[k] = 1
                factor = 1
            elif int_a + int_b + factor < 2:
                result[k] = int_a + int_b + factor
                factor = 0
            k -= 1
            i -= 1
            j -= 1
        if factor == 1:
            result[k] = 1
        result_str = ""
        for i in range(length + 1):
            if i == 0:
                if result[i] == 0:
                    continue
            result_str += str(result[i])
        return result_str

def main():
    sol = Solution()
    # result = sol.addBinary("11", "1")
    # print(result)
    result = sol.addBinary("1010", "1011")
    print(result)

if __name__ == "__main__":
    main()


