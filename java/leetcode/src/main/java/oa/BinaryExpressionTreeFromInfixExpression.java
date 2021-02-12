package oa;

import org.junit.Test;

import java.util.Stack;

/**
 * priority ( > *=/ > +=-
 */
public class BinaryExpressionTreeFromInfixExpression {
    public Node expTree(String s) {
        String postExp = toPostExpression(s);
        return postToNode(postExp);
    }

    private Node postToNode(String s) {
        char[] array = s.toCharArray();
        Stack<Node> stack = new Stack<>();
        for(char c : array) {
            if (Character.isDigit(c)) {
                stack.push(new Node(c));
                continue;
            }
            Node operatorNode = new Node(c);
            if (!stack.isEmpty()) {
                operatorNode.right = stack.pop();
            }
            if (!stack.isEmpty()) {
                operatorNode.left = stack.pop();
            }
            stack.push(operatorNode);
        }
        return stack.pop();
    }


    private String toPostExpression(String s) {
        char[] array = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (Character.isDigit(c)) {
                sb.append(c);
                continue;
            }
            if (c == '(') {
                stack.push(c);
                continue;
            }
            if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
                continue;
            }
            if (c == '*' || c == '/') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.push(c);
                } else {
                    while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek()=='/')) {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                }
                continue;
            }
            if (c == '+' || c == '-') {
                while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '+' || stack.peek() == '-')) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }


    @Test
    public void test() {
        String s = "1+2+3+4+5";
        expTree(s);
    }
}



class Node {
    char val;
    Node left;
     Node right;
     Node() {this.val = ' ';}
     Node(char val) { this.val = val; }
     Node(char val, Node left, Node right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
