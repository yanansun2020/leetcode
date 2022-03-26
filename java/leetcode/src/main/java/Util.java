public class Util {
    //get the last index that is less than specific value
    private int floorIndex(int[][] items, int val, int high) {
        int low = 0;
        while (low <= high) {
            int mid = (high - low)/2 + low;
            if (items[mid][1] > val) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low - 1;
    }
}
