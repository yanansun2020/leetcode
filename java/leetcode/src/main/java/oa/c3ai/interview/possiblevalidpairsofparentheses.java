package oa.c3ai.interview;

import java.util.ArrayList;
import java.util.List;

public class possiblevalidpairsofparentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generate(n, n, "", result);
        return result;
    }

    void generate(int leftNum,int rightNum,String s,List<String> result) {
        if(leftNum==0&&rightNum==0) {
            result.add(s);
            return;
        }
        if(leftNum>0) {
            generate(leftNum-1,rightNum,s+'(',result);
        }
        // if (leftNum < rightNum) {
        //      generate(leftNum-1, rightNum, s+'(',result);
        //      generate(leftNum, rightNum -1, s+'(',result);
        // }
        if(rightNum>0 && leftNum < rightNum){
            generate(leftNum,rightNum-1,s+')',result);
        }
    }
}
