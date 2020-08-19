package amazon.oa2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ProductBox {
    long getMaxUnit(int num, ArrayList<Integer> boxes, int unitSize, ArrayList<Integer> unitsPerBox, long truckSize){
        if(num != unitSize || boxes == null || boxes.size() == 0||
            unitsPerBox == null || unitsPerBox.size() == 0){
            return 0L;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[1]-a[1]);
        for (int i=0;i<num;i++){
            pq.add(new int  [] {boxes.get(i),unitsPerBox.get(i)});
        }
        long max=0;
        while(truckSize>0){
            int [] cur= pq.remove();
            int units=cur[1];
            int box=cur[0];
            max= max + (units * Math.min(truckSize,box));
            truckSize= truckSize- Math.min(truckSize,box);
        }
        return max;
    }
    @Test
    public void test(){
        ArrayList<Integer> boxes = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
        }};
        ArrayList<Integer> unitsPerBox = new ArrayList<Integer>(){
            {
                add(3);
                add(2);
                add(1);
            }
        };

        long a = getMaxUnit(3, boxes, 3,unitsPerBox, 3L);
    }
}
