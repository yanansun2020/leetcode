package contest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MakeTheStringGreat {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i =0; i<s.length(); i++){
            if (stack.isEmpty()){
                stack.add(s.charAt(i));
                continue;
            }
            Character lower = Character.toLowerCase(s.charAt(i));
            if(lower.equals(Character.toLowerCase(stack.peek())) ){
                if ((Character.isUpperCase(stack.peek()) && Character.isLowerCase(s.charAt(i))) ||
                (Character.isLowerCase(stack.peek()) && Character.isUpperCase(s.charAt(i)))){
                    stack.pop();
                    continue;
                }
                if(s.charAt(i) == stack.peek()){
                    stack.add(s.charAt(i));
                }
            }else{
                stack.add(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        MakeTheStringGreat test = new MakeTheStringGreat();
        System.out.println(test.makeGood("leEeetcode"));
        System.out.println(test.makeGood("abBAcC"));
        System.out.println(test.makeGood("s"));

    }
}