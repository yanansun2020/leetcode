package oa.robinhood;

public class EliminateVowl {
    public String eliminate(String s){
        char[] charArray = s.toCharArray();
        int i =0;
        String ans = "";
        while (i<charArray.length){
            switch (charArray[i]){
                default:
                    ans += charArray[i];
                    i++;
                    break;
                case 'a':
                    i++;
                case 'e':
                    i++;
                    break;
                case 'i':
                    i++;
                    break;
                case 'o':
                    i++;
                    break;
                case 'u':
                    i++;
                    break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        EliminateVowl test = new EliminateVowl();
        System.out.println(test.eliminate("apple"));
    }
}
