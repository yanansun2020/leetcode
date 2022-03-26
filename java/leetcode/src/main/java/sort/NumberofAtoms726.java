package sort;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class NumberofAtoms726 {
    public String countOfAtoms(String formula) {
        int i = 0;
        char[] arr = formula.toCharArray();
        int n = arr.length;
        String e = "";
        Stack<String[]> stack = new Stack<>();
        while (i < n) {
            char c = arr[i];
            if (Character.isUpperCase(c)) {
                int j = getElement(i, arr);
                e = formula.substring(i, j);
                i = j;
                int k = getNum(i, arr);
                String num = formula.substring(i, k);
                if (num.length() == 0) {
                    num = "1";
                }
                stack.push(new String[]{e, num});
                i = k;
                continue;
            }
            if (c == '(') {
                stack.push(new String[]{"(", ""});
                i++;
                continue;
            }
            if (c==')') {
                int j = getNum(i + 1, arr);
                String numStr = formula.substring(i + 1, j);
                if (numStr.length() == 0) {
                    numStr = "1";
                }
                rebuildStack(stack, Integer.parseInt(numStr));
                i = j;
            }
        }
        TreeMap<String, Integer> map = new TreeMap<>();
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) {
            String[] strFreq = stack.pop();
            map.put(strFreq[0], map.getOrDefault(strFreq[0], 0) + Integer.parseInt(strFreq[1]));
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            res.append(entry.getKey());
            if (entry.getValue() > 1){
                res.append(entry.getValue());
            }
        }
        return res.toString();
    }
    private int getElement(int i , char[] arr) {
        int j = i + 1;
        while (j < arr.length) {
            char next = arr[j];
            if (Character.isLowerCase(next)) {
                j++;
            } else {
                break;
            }
        }
        return j;
    }

    private int getNum(int i, char[] arr) {
        while (i < arr.length) {
            char c = arr[i];
            if (Character.isDigit(c)) {
                i++;
            } else {
                break;
            }
        }
        return i;
    }

    private void rebuildStack(Stack<String[]> stack, int num) {
        Stack<String[]> tmp = new Stack<>();
        while(!stack.isEmpty() && !stack.peek()[0].equals("(")) {
            String[] StrFreq = stack.pop();
            Integer freq = Integer.parseInt(StrFreq[1]) * num;
            tmp.push(new String[]{StrFreq[0], freq + ""});
        }
        stack.pop();
        while(!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
    }

    public static void main(String[] args) {
        NumberofAtoms726 test = new NumberofAtoms726();
        String s = "H20OMb45";
        String res = test.countOfAtoms(s);
    }
}
