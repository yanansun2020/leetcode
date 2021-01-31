package oa.amazon.vo;

import org.junit.Test;

import java.util.Stack;

/**
 * preOperator：记录前面的操作符
 * 核心思想： 当前ch是操作符时候， 查看preOperator， 并计算前面的值
 */
public class BasicCalculatorII {

    public int calculate(String s) {
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        char preOperator = '+';
        int num = 0;
        while (i < s.length()) {
            Character c = s.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            }
            if (Character.isDigit(c)) {
                int index = getNumIndex(i, s);
                String tmp = s.substring(i, index);
                num = Integer.parseInt(tmp);
                i = index;
                continue;
            }
            if (i == s.length() || c == '+' || c=='-' || c == '*' || c == '/') {
                cal(preOperator, stack, num);
                preOperator = c;
                i++;
            }

        }
        cal(preOperator, stack, num);
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;

    }

    private int getNumIndex(int index, String s) {
        int i = index;
        for (; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!Character.isDigit(c)) {
                break;
            }
        }
        return i;

    }

    private void cal(char preOperator,  Stack<Integer> stack, int num) {

        if(preOperator == '+') {
            stack.push(num);
        } else if (preOperator == '-') {
            stack.push(-num);
        } else if (preOperator == '*') {
            stack.push( stack.pop() * num);
        } else {
            stack.push(stack.pop()/num);
        }
    }

    @Test
    public void test(){
        String s = "5 -4 * 2 + 1";
        int ans = calculate(s);
    }
}
