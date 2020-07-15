class Solution:
    # dp[i] [0-i]可以有的decode 数量
    #dp[i] = dp[i-2] * factor + dp[i-1] * (9 if * else 1)
    def numDecodings(self, s: str) -> int:
        if not s:
            return 0
        if s[0] == '0':
            return 0
        dp = [0 for i in range(len(s))]
        dp[0] = 1 if s[0] != '*' else 9
        for i in range(1, len(s)):
            if s[i] != '0':
                dp[i] = dp[i-1]
            if s[i] == "*":
                dp[i] = dp[i] * 9
            valid_factor = self.getValidNumber(s[i-1:i+1])
            previous = dp[i-2] if i-2 >=0 else 1
            dp[i] += (previous * valid_factor)
        return dp[-1] %(pow(10, 9) + 7)

    def getValidNumber(self, s):
        count = 0
        if s[0].isdigit() and s[1].isdigit():
            if '09'<s<'27':
                count += 1
            return count

        if s[0] == "*" and s[1] == "*":
            for i in range(1, 10):
                for j in range(1, 10):
                    s_ = str(i) + str(j)
                    if '09'<s_<'27':
                        count += 1
            return count

        if s[0].isdigit() and s[1] == "*":
            for i in range(1, 10):
                s_ = s[0] + str(i)
                if '09'<s_<'27':
                    count += 1
            return count
        if s[0] == "*" and s[1].isdigit():
            for i in range(1, 10):
                s_ = str(i) + s[1]
                if '09'<s_<'27':
                    count += 1
            return count

def main():
    sol = Solution()
    # result = sol.numDecodings("211*")
    # print(result)
    result = sol.numDecodings("211*1")
    print(result)
    result = sol.numDecodings("1*")
    print(result)
    result = sol.numDecodings("*")
    print(result)
    result = sol.numDecodings("01")
    print(result)
    result = sol.numDecodings("*********")
    print(result)


if __name__ == "__main__":
    main()
