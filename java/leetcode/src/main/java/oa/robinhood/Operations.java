package oa.robinhood;

import org.junit.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Operations {
    String booleanDeque(int n, String[] operations) {
        char[] s = new char[n];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Set<Integer> nodeList = new HashSet<>();
        for(int i =0; i<n; i++){
            queue.add(i);
            nodeList.add(i);
            s[i] = '0';
        }
        for(String op : operations){
            if(op.startsWith("C")){
                int position = Integer.parseInt(op.substring(1));
                s[position] = '0';
                if(!nodeList.contains(position)){
                    queue.add(position);
                    nodeList.add(position);
                }
                continue;
            }
            if(op.equals("L")){
                if(!queue.isEmpty()){
                    Integer index = queue.poll();
                    if(index != null){
                        s[index] = '1';
                    }
                    nodeList.remove(index);
                }
            }
        }
        return String.valueOf(s);
    }
    @Test
    public void test(){
//        String s0 = booleanDeque(10, new String[]{"L", "L", "C0", "L", "C3"});
        String s1 = booleanDeque(10, new String[]{"C3",
            "L",
            "L",
            "C5",
            "L",
            "L",
            "C5",
            "L",
            "C3",
            "C6"});
//        String s1 = booleanDeque(2, new String[]{"L", "L", "L", "C1"});
    }
}
