package dp;
// leetcode 1411

public class NumberofWaystoPaintGrid {
    public int numOfWays(int n) {
        long aba = 6;
        long abc = 6;
        long mod =(long)(1e9+7);
        for(int i =2 ; i<n + 1; i++){
            long tmp2 = (aba * 3 + abc * 2) % mod;
            long tmp3 = (aba * 2 + abc * 2) % mod;
            aba = tmp2 ;
            abc = tmp3;
        }
        return (int)((aba + abc)%mod);
    }
    public static void main(String[] args) {
        NumberofWaystoPaintGrid test = new NumberofWaystoPaintGrid();
        System.out.println(test.numOfWays(1));
        System.out.println(test.numOfWays(2));
        System.out.println(test.numOfWays(3));
        System.out.println(test.numOfWays(7));
        System.out.println(test.numOfWays(5000));
    }
}