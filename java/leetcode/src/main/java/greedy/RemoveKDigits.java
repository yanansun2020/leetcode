package greedy;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        int i = 0;
        for (; i < num.length() && k >0; i++) {
            while (!stack.isEmpty() && k >0  && num.charAt(i) < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while (!stack.isEmpty() && k > 0) {
            stack.pollFirst();
            k--;
        }
        while (!stack.isEmpty() && stack.peekLast() == '0') {
            stack.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String ans = sb.reverse().toString() + num.substring(i);
        return ans.length() == 0? "0" : ans;
    }
}
