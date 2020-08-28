package oa.amazon;

public class RemoveConsecutiveVowel {
    boolean isVowel(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
    String remove(String str){
        String str1 = "";
        str1 += str.charAt(0);
        for(int i=1; i< str.length(); i++){
            if(!isVowel(str.charAt(i)) || !isVowel(str.charAt(i-1))){
                str1 += str.charAt(i);
            }
        }
        return str1;
    }
}
