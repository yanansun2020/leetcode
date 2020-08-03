from typing import List
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        result = []
        def dfs(num1, diff, curNum, expression)->int:
            if not num1:
                if target == curNum and expression not in result:
                    result.append(expression)
                return
            for i in range(1, len(num1)+1):
                cur_str = num1[0:i]
                cur = int(cur_str)
                if (len(cur_str)> 1 and cur_str[0] == '0'):
                    return
                next_num1 = num1[i:]
                if expression:
                    dfs(next_num1, cur, curNum + cur, expression + "+" + cur_str)
                    dfs(next_num1, -cur, curNum-cur, expression + "-" + cur_str)
                    dfs(next_num1, diff * cur, (curNum-diff) + (diff * cur), expression + "*" + cur_str)
                else:
                    dfs(next_num1, cur, cur, cur_str)
        dfs(num, 0, 0, "")
        return result

def main():
    sol = Solution()
    result = sol.addOperators("123", 6)
    print(result)
    result = sol.addOperators("232", 8)
    print(result)
    result = sol.addOperators("105", 5)
    print(result)
    result = sol.addOperators("00", 0)
    print(result)
    result = sol.addOperators("3456237490", 9191)
    print(result)
if __name__ == "__main__":
    main()