package oa.c3ai;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        char[] charOfS = s.toCharArray();


        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < charOfS.length; i++) {
            if(stack.isEmpty() && (charOfS[i] == '}' || charOfS[i] == ']' || charOfS[i] == ')')){
                return false;
            }
            if (charOfS[i] == '{' || charOfS[i] == '[' || charOfS[i] == '(') {
                stack.push(charOfS[i] + "");
                continue;
            }
            String firstEle = stack.peek();
            if(charOfS[i] == '}' && !firstEle.equals("{")){
                return false;
            }
            if(charOfS[i] == ']' && !firstEle.equals("[")){
                return false;
            }
            if(charOfS[i] == ')' && !firstEle.equals("(")){
                return false;
            }
            stack.pop();

        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
