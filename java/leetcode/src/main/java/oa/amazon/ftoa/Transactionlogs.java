package oa.amazon.ftoa;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Transactionlogs {
    public String[] processLogFile(String[] logs, int threshold) {
        Map<String, Set<String>> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (String log : logs) {
            String[] logArray = log.split(" ");
            String uid1 = logArray[0].trim();
            String uid2 = logArray[1].trim();
            String transactionId = logArray[2].trim();
            Set<String> uid1Set = map.getOrDefault(uid1, new HashSet<>());
            if (uid1Set.size() < threshold || threshold <= 0) {
                uid1Set.add(transactionId);
                map.put(uid1, uid1Set);
                if (uid1Set.size() >= threshold && !ans.contains(uid1)) {
                    ans.add(uid1);
                }
            }

            if (!uid2.equals(uid1)) {
                Set<String> uid2Set = map.getOrDefault(uid2, new HashSet<>());
                if (uid2Set.size() < threshold || threshold <= 0) {
                    uid2Set.add(transactionId);
                    map.put(uid2, uid2Set);
                    if (uid2Set.size() >= threshold && !ans.contains(uid2)) {
                        ans.add(uid2);
                    }
                }
            }
        }
        Collections.sort(ans, (a, b)-> b.compareTo(a));
        String[] stringArray = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            stringArray[i] = ans.get(i);
        }
        return stringArray;
    }
    @Test
    public void test(){
        String[] logs = new String[]{"88 99 200", "88 99 300", "99 32 100", "12 12 15"};
        String[] ansd = processLogFile(logs, -1);
    }
}
