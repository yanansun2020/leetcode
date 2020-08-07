package array;

public class ConvertaNumbertoHexadecimal {
    public String toHex(int num) {
        if (num == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        String[] hexStr = {"a", "b", "c", "d", "e", "f"};
        long m = num;
        if(m <0){
            m += Math.pow(2, 32);
        }
        while(m != 0){
            long mod = m%16;
            if(mod < 10){
                sb.append(mod);
            }else{
                sb.append(hexStr[(int)(mod-10)]);
            }
            m >>= 4;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        ConvertaNumbertoHexadecimal test = new ConvertaNumbertoHexadecimal();
        System.out.println(test.toHex(0));
        System.out.println(test.toHex(26));
        System.out.println(test.toHex(-1));
        System.out.println(test.toHex(16));


    }
}