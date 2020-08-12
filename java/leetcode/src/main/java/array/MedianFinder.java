package array;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> max_queue;
    PriorityQueue<Integer> min_queue;
    public MedianFinder() {
        this.max_queue= new PriorityQueue<>((Integer o1, Integer o2 ) -> (o2-o1));
        this.min_queue = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (min_queue.isEmpty()){
            min_queue.offer(num);
        }else{
            if(num > min_queue.peek()){
                min_queue.offer(num);
            }else{
                max_queue.offer(num);
            }
            rebalance();

        }
    }

    public double findMedian() {
        if(min_queue.size() - max_queue.size() ==1){
            return min_queue.peek();
        }
        if(max_queue.size() - min_queue.size() ==1){
            return max_queue.peek();
        }
        return (((double)min_queue.peek() + (double)max_queue.peek())/2);
    }

    public void rebalance(){
        if(min_queue.size() - max_queue.size() > 1){
            Integer top_ele = min_queue.poll();
            max_queue.offer(top_ele);
        }
        if(max_queue.size() - min_queue.size() > 1){
            Integer top_ele = max_queue.poll();
            min_queue.offer(top_ele);
        }
    }

    public static void main(String[] args) {
        MedianFinder test = new MedianFinder();
        test.addNum(-1);
        System.out.println(test.findMedian());
        test.addNum(-2);
        System.out.println(test.findMedian());
        test.addNum(-3);
        System.out.println(test.findMedian());
        test.addNum(-4);
        System.out.println(test.findMedian());
        test.addNum(-5);
        System.out.println(test.findMedian());
    }

}
