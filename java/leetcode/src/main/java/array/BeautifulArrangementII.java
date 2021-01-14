package array;

/**
 * if you have n number, the maximum k can be n - 1;
 * if n is 9, max k is 8.
 * This can be done by picking numbers interleavingly from head and tail,
 */
public class BeautifulArrangementII {
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        int left=1, right=n;
        for(int i=0; i<n; i++){
            result[i] = k%2 !=0 ? left++ : right--;
            if(k>1)
                k--;
        }

        return result;
    }
}
