package amazon;

public class Rotation {
    int countRotation(int list[], int low, int high){
        if(high < low){
            return 0;
        }
        if(high == low){
            return low;
        }
        int mid = low+ (high - low)/2;
        if(mid <high && list[mid + 1] < list[mid]){
            return mid + 1;
        }
        if(mid > low && list[mid] < list[mid-1]){
            return mid;
        }
        if(list[high] > list[mid]){
            return countRotation(list, low, mid);
        }
        return countRotation(list, mid, high);
    }
    int countRotation(int size, int list[]){
        int res = countRotation(list, 0, size-1);
        return res;
    }
}
