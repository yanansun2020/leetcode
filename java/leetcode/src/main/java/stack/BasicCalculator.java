package stack;

import org.junit.Test;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        int j = 0;
        Stack<String> operand = new Stack<>();
        Stack<String> operator = new Stack<>();
        for(int i =s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            if(ch == ' '){
                continue;
            }
            if(ch == '+' || ch == '-' || ch==')'){
                operator.add(ch+"");
                continue;
            }
            if(ch == '('){
                while(!operand.isEmpty() && !operator.peek().equals(")")){
                    int a = Integer.parseInt(operand.pop());
                    String oper = operator.pop();
                    int b = Integer.parseInt(operand.pop());
                    if("+".equals(oper)){
                        int value = a + b;
                        operand.add(value + "");
                    }else{
                        int value = a - b;
                        operand.add(value + "");
                    }
                }
                if(operator.peek().equals(")")){
                    operator.pop();
                }
            }
            if(Character.isDigit(ch)){
                j = i;
                while(i >= 0 && Character.isDigit(s.charAt(i))){
                    i--;
                }
                operand.add(s.substring(i+1, j+1));
                i++;
            }
        }

        while(!operand.isEmpty() && operand.size() > 1){
            int a = Integer.parseInt(operand.pop());
            int b = Integer.parseInt(operand.pop());
            String oper = operator.pop();
            if("+".equals(oper)){
                int value = a + b;
                operand.add(value + "");
            }else{
                int value = a - b;
                operand.add(value + "");
            }
        }
        return Integer.parseInt(operand.pop());
    }
    @Test
    public void test(){
        String a = "a";
        String b  = a.substring(1,0);
        int ans = calculate(" 1 + 1");
        int ans1 = calculate(" 2-1 + 2 ");
        int ans2 = calculate("(1+(4+5+2)-3)+(6+8)");
        int ans3 = calculate("2- ( 1 + 10 )");
    }
}
