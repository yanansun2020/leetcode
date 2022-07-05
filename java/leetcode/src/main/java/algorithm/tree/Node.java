package algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public abstract class Node {
    public abstract int evaluate();
    String v;
    Node left;
    Node right;
    Node(Node left, Node right, String v) {
        this.left = left;
        this.right = right;
        this.v = v;
    }
}

class ExpNode extends Node{
    ExpNode(Node left, Node right, String v) {
        super(left, right, v);
    }

    @Override
    public int evaluate() {
        if (this.v.equals("+")) {
            return this.left.evaluate() + this.right.evaluate();
        }
        if (this.v.equals("-")) {
            return this.left.evaluate() - this.right.evaluate();
        }
        if (this.v.equals("*")) {
            return this.left.evaluate() * this.right.evaluate();
        }
        if (this.v.equals("/")) {
            return this.left.evaluate() / this.right.evaluate();
        }
        return 0;
    }
}


class TreeBuilder {
    Node buildTree(String[] postfix) {
        Stack<ExpNode> stack = new Stack<>();
        for (int i =0; i < postfix.length; i++) {
            if (isNotOPeration(postfix[i])) {
                ExpNode node = new ExpNode(null, null, postfix[i]);
                stack.push(node);
            } else {
                ExpNode right = stack.pop();
                ExpNode left = stack.pop();
                ExpNode cur = new ExpNode(left, right, postfix[i]);
                stack.push(cur);
            }
        }
        return stack.pop();
    }

    private boolean isNotOPeration(String s) {
        List<String> operstions = new ArrayList<>();
        operstions.add("+");
        operstions.add("-");
        operstions.add("*");
        operstions.add("/");
        return operstions.contains(s);
    }
};
