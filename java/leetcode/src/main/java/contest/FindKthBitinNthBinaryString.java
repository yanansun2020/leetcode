package contest;

public class FindKthBitinNthBinaryString {
    public char findKthBit(int n, int k) {
        String previous = "0";
        for(int i =1; i<=n; i++){
            StringBuilder sb = new StringBuilder(previous);
            sb.append("1");
            sb.append(reverseInvert(previous));
            previous = sb.toString();
        }
        return previous.charAt(k-1);
    }
    public String reverseInvert(String S){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < S.length(); i++){
            if (S.charAt(i) == '0'){
                sb.append("1");
            }else{
                sb.append("0");
            }
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        FindKthBitinNthBinaryString test = new FindKthBitinNthBinaryString();
        System.out.println(test.findKthBit(3, 1));
        System.out.println(test.findKthBit(4, 11));
        System.out.println(test.findKthBit(1, 1));
        System.out.println(test.findKthBit(2, 3));
    }
}