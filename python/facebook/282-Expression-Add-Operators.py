from typing import List
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        init_num = int(num[0])
        result = []

        def dfs(num1:int, index:int, expression)->int:
            if index == len(num) and target == num1:
                if expression not in result:
                    result.append(expression)
                return
            for i in range(index, len(num)):
                num2 = int(num[index])
                expression_plus = str(expression)
                expression_plus +=  "+" + num[index]
                dfs(num1 + num2, index+1, expression_plus)
                expression_minus = str(expression)
                expression_minus +=  "-" + num[index]
                dfs(num1 - num2, index+1, expression_minus)
                expression_multi = str(expression)
                expression_multi += "*" + num[index]
                dfs(num1 * num2, index+1, expression_multi)
        dfs(init_num, 1, num[0])
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