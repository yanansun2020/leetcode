package oa.robinhood;

public class Matrix {
    public int matrixSum(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int i=0, j, sum = 0;
        while (i<m){
            j = 0;
            while(j <n){
                int a = matrix[i][j++];
                sum += a;
            }
            i++;
        }
        return sum;
    }

    public int reverseNUmber(int n){
        int reverseNUm = 0;
        while(n != 0){
            int remainder = n % 10;
            n = n /10;
            if (n != 0){
                reverseNUm = (reverseNUm + remainder) * 10;
            }else{
                reverseNUm = (reverseNUm + remainder);
            }
        }
        return reverseNUm;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2}, {3, 4}};
        Matrix test = new Matrix();
        System.out.println(test.matrixSum(array));
        System.out.println(test.reverseNUmber(60780));
    }
}
