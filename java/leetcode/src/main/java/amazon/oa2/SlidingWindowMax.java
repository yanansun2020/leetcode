package amazon.oa2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMax {
    public int maxSlidingWindow(int numComputer, List<Integer> hardDiskSpace, int segLength) {
        if(hardDiskSpace == null || hardDiskSpace.size() == 0){
            return -1;
        }
        int golbalMax = Integer.MIN_VALUE;
        Deque<NumIndex> deq = new LinkedList<NumIndex>();
        for(int i =0; i<hardDiskSpace.size(); i++){
            int curSpace = hardDiskSpace.get(i);
            NumIndex numIndex = new NumIndex(curSpace, i);
            while(!deq.isEmpty() && curSpace < deq.peekLast().num){
                deq.pollLast();
            }
            deq.add(numIndex);
            if(deq.peekFirst().index == i-segLength){
                deq.pollFirst();
            }
            if(i >= segLength-1){
                golbalMax = Math.max(deq.peekFirst().num, golbalMax);
            }
        }
        return golbalMax;
    }
    @Test
    public void test(){
        List<Integer> s = new ArrayList<Integer>(){
            {
                add(8);
                add(2);
                add(4);
            }
        };
        List<Integer> s1 = new ArrayList<Integer>(){
            {
                add(1);
                add(3);
                add(-1);
                add(-3);
                add(5);
                add(8);
                add(9);
                add(7);
            }
        };
        int a1 = maxSlidingWindow(3, s1, 3);
    }
}
class NumIndex{
    int num;
    int index;
    NumIndex(){}
    NumIndex(int num, int index){
        this.num = num;
        this.index = index;
    }
}
