package greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * monotone stack, keep track of the smallest sequence
 * Notice: Given the frequency map, when iterate the string by chard, and decrease the frequency value
 * The frequency that produced by a specif char must have greater index than the current char
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (stack.contains(c)) {
                map.put(c, map.get(c) - 1);
                continue;
            }
            while (!stack.isEmpty() && c.compareTo(stack.peek()) < 0 && map.get(stack.peek()) > 0) {
                stack.pop();
            }
            stack.push(c);
            map.put(c, map.get(c) - 1);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}
