package oa.robinhood;

public class SubstringDivisible {
    public int getDivisibleSubstring(String s, int k){
        int count = 0;
        Integer original = Integer.parseInt(s);
        for(int i =0; i<=s.length()-k; i++){
            String sub = s.substring(i, i+k);
            Integer sub_int = removeZerosAndGetInt(sub);
            if(sub_int == 0){
                continue;
            }
            if (original % sub_int == 0){
                count++;
            }
        }
        return count;
    }
    public int removeZerosAndGetInt(String s){
        int i = 0;
        for(i=0; i< s.length(); i++){
            if(s.charAt(i) != '0'){
                break;
            }
        }
        s = s.substring(i);
        if(s.isEmpty()){
            return 0;
        }
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        SubstringDivisible test = new SubstringDivisible();
//        System.out.println(test.getDivisibleSubstring("120", 2));

        System.out.println(test.getDivisibleSubstring("1005", 2));
    }
}
