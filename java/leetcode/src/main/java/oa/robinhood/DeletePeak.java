package oa.robinhood;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class DeletePeak {
    public List<Integer> removePeak(int[] numbers){
        PriorityQueue<Number> queue = new PriorityQueue<>((Number o1, Number o2)->(o1.n - o2.n));
        LinkedList<Integer> ss = new LinkedList<>();
        for(int i =0; i< numbers.length; i++){
            if(i == 0){
                if(i>numbers[i+1]){
                    queue.add(new Number(numbers[i], i));
                }
                continue;
            }
            if(i == numbers.length-1){
                if(numbers[i] >numbers[i-1]){
                    queue.add(new Number(numbers[i], i));
                }
                continue;
            }
            if(numbers[i-1]<numbers[i] &&  numbers[i]> numbers[i+1]){
                queue.add(new Number(numbers[i], i));
            }
        }
        List<Integer> visited = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()){
            Number topEle = queue.poll();
            Integer startIndex = topEle.index;
            visited.add(startIndex);
            ans.add(topEle.n);
            Integer left = startIndex;
            while(visited.contains(left) && left >=0){
                left--;
            }
            Integer right = startIndex;
            while(visited.contains(right) && right <numbers.length){
                right++;
            }
            //check left element
            if(left < 0 && right >= numbers.length){
                continue;
            }
            if(left < 0){
            }
            if(left >= 0 && numbers[left] > numbers[right] && (left == 0 ||numbers[left] > numbers[left-1] )){
                queue.offer(new Number(numbers[left], left));
            }
            if(right < numbers.length && numbers[right] > numbers[left] && (right == numbers.length -1 ||numbers[right] > numbers[right+1] )){
                queue.offer(new Number(numbers[right], right));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array = {2,7,8,5,1,6,3,9,4};
        DeletePeak test = new DeletePeak();
        System.out.println(test.removePeak(array));
    }
}
class Number{
    int n;
    int index;
    Number(){}
    Number(int n, int index){
        this.n = n;
        this.index = index;
    }
}
