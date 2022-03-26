package stack;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                number = number * 10 + Integer.parseInt(ch + "");
                continue;
            }
            if (number > 0) {
                stack.push(String.valueOf(number));
                number = 0; 
            }
            if (ch == ']') {
                String s1 = getFromStack(stack);
                stack.push(s1);
            } else {
                stack.push(ch + "");
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
    
    private String getFromStack(Stack<String> stack) {
        StringBuilder sb = new StringBuilder();
        String tmp = stack.pop();
        while (!stack.isEmpty() && tmp.equals("[")) {
            sb.insert(0, stack.pop());
        }
        String s = sb.toString();
        int times = 1;
        if (!stack.isEmpty()) {
            times = Integer.parseInt(stack.pop());
        }
        //remove tentatively, java8 not support
        //s = s.repeat(times);
        return s;
    }
}
