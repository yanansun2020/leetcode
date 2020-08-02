package contest;

public class FindWinnerOfAnArrayGame {
    // The idea is how many rounds the current winner can win before the new winner comes.
    public static int getWinner(int[] arr, int k) {
        int winner = arr[0];
        int wins = 0;
        for(int i = 1; i < arr.length; i++){
            if(winner > arr[i])
                // increment wins count
                wins++;
            else{
                wins = 1;
                // new winner
                winner = arr[i];
            }
            if(wins == k)
                // if wins count is k, then return winner
                break;
        }
        return winner;
    }

    public static void main(String[] args) {
        int[] array = {2,1,3,5,4,6,7};
        int result = getWinner(array, 100);
    }
}
