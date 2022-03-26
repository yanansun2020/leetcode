package sort;

import java.util.*;

public class AlertUsingSameKey1604 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            List<String> array = map.getOrDefault(keyName[i], new ArrayList<>());
            array.add(keyTime[i]);
            map.put(keyName[i], array);
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> values = entry.getValue();
            if (alert(values)) {
                res.add(key);
            }
        }
        Collections.sort(res);
        return res;
    }

    private boolean alert(List<String> times) {
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String t1, String t2) {
                String t1_hour = t1.split(":")[0];
                String t1_min = t1.split(":")[1];
                String t2_hour = t2.split(":")[0];
                String t2_min = t2.split(":")[1];
                return t1_hour.equals(t2_hour) ? t1_hour.compareTo(t2_hour) : t1_min.compareTo(t2_min);
            }
        };
        Collections.sort(times, comp);
        PriorityQueue<String> queue = new PriorityQueue<String>(comp);
        for (String time : times) {
            if (queue.isEmpty()) {
                queue.add(time);
                continue;
            }
            while (!queue.isEmpty() && moreThanOneHour(queue.peek(), time)) {
                queue.poll();
            }
            queue.offer(time);
            if(queue.size() >= 3) {
                return true;
            }
        }
        return false;
    }

    private boolean moreThanOneHour(String t1, String t2) {
        int t1_hour = Integer.parseInt(t1.split(":")[0]);
        int t2_hour = Integer.parseInt(t2.split(":")[0]);
        if (Math.abs(t1_hour - t2_hour) > 1) {
            return true;
        }
        int minutes = Math.abs(t1_hour - t2_hour) * 60;
        int t1_min = Integer.parseInt(t1.split(":")[1]);
        int t2_min = Integer.parseInt(t2.split(":")[1]);
        minutes += (t2_min - t1_min);
        if (minutes > 60) {
            return true;
        }
        return false;
    }
}
