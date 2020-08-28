package oa.amazon;

import org.junit.Test;

public class CompareProduct {
    boolean compare(int num){
        if(num < 10){
            return false;
        }
        int odd = 1, even = 1;
        while(num > 0){
            int digit = num % 10;
            odd *= digit;
            num = num/10;
            if(num == 0){break;}
            digit = num%10;
            even *= digit;
            num = num/10;
        }
        return odd == even;
    }
    @Test
    public void test(){
        System.out.println(compare(1242));
        System.out.println(compare(22));
    }
}
