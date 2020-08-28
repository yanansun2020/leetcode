package oa.amazon;

public class ReverseAlphabit {
    String reverse(String s){
        int left = 0, right = s.length() -1;
        char[] imputChar = s.toCharArray();
        while(left < right){
            if(!Character.isAlphabetic(s.charAt(left))){
                left++;
            }else if(!Character.isAlphabetic(s.charAt(right))){
                right--;
            }else{
                char tmp = s.charAt(left);
                imputChar[left] = s.charAt(right);
                imputChar[right] = tmp;
                left ++;
                right ++;
            }
        }
        return new String(imputChar);
    }
}
