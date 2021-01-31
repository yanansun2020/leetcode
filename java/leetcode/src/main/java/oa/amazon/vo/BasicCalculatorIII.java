package oa.amazon.vo;

import org.junit.Test;

import java.util.Stack;

public class BasicCalculatorIII {
    public int calculate(String s) {
        return cal(0, s.trim())[0];
    }
    private int[] cal(int start, String s) {
        Stack<Integer> stack = new Stack<>();
        char preOperator = '+';
        int num = 0;
        int i = start;
        for (; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (c == '(') {
                int[] tmpRes = cal(i + 1, s);
                num = tmpRes[0];
                i = tmpRes[1];
//                continue;
            }

            if (i >= s.length() -1 || c == '+' || c=='-' || c == '*' || c == '/' ||c == ')') {
                cal(preOperator, stack, num);
                preOperator = c;
                num = 0;
            }
            if (c == ')') {
                break;
            }
        }
//        cal(preOperator, stack, num);
        int value = 0;
        while (!stack.isEmpty()) {
            value += stack.pop();
        }
        return new int[]{value, i};

    }

    private int getNumIndex(int cur, String s) {
        while (cur < s.length() && Character.isDigit(s.charAt(cur))) {
            cur++;
        }
        return cur;
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
    public void test() {
        String s  = "2*(1+1)";
        int ans = calculate(s);
        s = "1 + 1";
        ans = calculate(s);
        s = " 6-4 / 2 ";
        ans = calculate(s);
        s = "2*(5+5*2)";
        ans = calculate(s);
        s = "2*(5+5*2)/3+(6/2+8)";
        ans = calculate(s);
    }
}

