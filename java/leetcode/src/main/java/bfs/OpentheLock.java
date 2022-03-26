package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpentheLock {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet();
        for (String d: deadends){
            dead.add(d);
        }

        String start = "0000";
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int step = 0;
        Set<String> visited = new HashSet<>();
        visited.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (target.equals(String.valueOf(cur))) {
                    return step;
                }

                //for each char, move forward or backward
                for (int j = 0; j < cur.length(); j++) {
                    char[] tmp = cur.toCharArray();
                    int c = Character.getNumericValue(tmp[j]);
                    int f = (c + 1)%10;
                    tmp[j] = (char)(f + '0');
                    String cs = String.valueOf(tmp);
                    if (!dead.contains(cs) && !visited.contains(cs)) {
                        queue.offer(cs);
                        visited.add(cs);
                    }
                    int b = (c - 1 + 10)%10;
                    tmp[j] = (char)(b + '0');
                    cs = String.valueOf(tmp);
                    if (!dead.contains(cs) && !visited.contains(cs)) {
                        queue.offer(cs);
                        visited.add(cs);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] dead = new String[]{"0201","0101","0102","1212","2002"};
        String target = "0202";
        OpentheLock opentheLock = new OpentheLock();
        int res = opentheLock.openLock(dead, target);
        dead = new String[]{"8888"};
        target = "0009";
        res = opentheLock.openLock(dead, target);
        dead = new String[]{"8888"};
        target = "0009";

        System.out.println((int)Math.sqrt(12));
    }
}
