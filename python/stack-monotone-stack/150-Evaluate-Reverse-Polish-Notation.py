from typing import List
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        operators = ['+', '-', '*', '/']
        stack = []
        for token in tokens:
            if token not in operators:
                stack.append(token)
            else:
                operand_1 = int(stack[-1])
                stack.pop(-1)
                operand_2 = int(stack[-1])
                stack.pop(-1)
                if token == operators[0]:
                    value = operand_1 + operand_2
                elif token == operators[1]:
                     value = operand_1 - operand_2
                elif token == operators[2]:
                     value = operand_1 * operand_2
                elif token == operators[3]:
                     value = operand_2 / operand_1
                stack.append(value)
        return stack[-1]

def main():
    sol = Solution()
    # result = sol.evalRPN(["2", "1", "+", "3", "*"])
    # print(result)
    result = sol.evalRPN(["4", "13", "5", "/", "+"])
    print(result)
    result = sol.evalRPN(["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"])
    print(result)
    # result = sol.evalRPN([1], 1)
    # print(result)

if __name__ == "__main__":
    main()
