package array;

import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class AnalyzeUserWebsiteVisitPattern {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair<Integer, String>>> map = new TreeMap<>();

        for(int i=0; i<username.length; i++){
            if(!map.containsKey(username[i])) map.put(username[i], new ArrayList<>());
            map.get(username[i]).add(new Pair(timestamp[i], website[i]));
        }

        Map<String, Integer> countMap = new TreeMap<>();

        for(String user: map.keySet()){
            List<Pair<Integer, String>> currList = map.get(user);
            Collections.sort(currList, (n1, n2) -> (n1.getKey() - n2.getKey()));
            StringBuilder sb = new StringBuilder();
            Set<String> set = new HashSet<>();
            for(int i=0; i<currList.size()-2; i++){
                int length1 = sb.length();
                sb.append(currList.get(i).getValue());
                for(int j=i+1; j<currList.size()-1; j++){
                    int length2 = sb.length();
                    sb.append("-");
                    sb.append(currList.get(j).getValue());
                    for(int k=j+1; k<currList.size(); k++){
                        int length3 = sb.length();
                        sb.append("-");
                        sb.append(currList.get(k).getValue());
                        if(!set.contains(sb.toString())){
                            countMap.put(sb.toString(), countMap.getOrDefault(sb.toString(), 0) + 1);
                            set.add(sb.toString());
                        }
                        sb.delete(length3, sb.length());
                    }
                    sb.delete(length2, sb.length());
                }
                sb.delete(length1, sb.length());
            }
        }
        int maxCount = Collections.max(countMap.values());
        List<String> list = new ArrayList<>();
        for(String s: countMap.keySet()){
            if(countMap.get(s) == maxCount){
                list.add(s);
            }
        }
        Collections.sort(list);
        return Arrays.asList(list.get(0).split("-"));
    }
    @Test
    public void test(){
        String[] username = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] timestamp = {1,2,3,4,5,6,7,8,9,10};
        String[] website = {"home","about","career","home","cart","maps","home","home","about","career"};
        List<String> aa = mostVisitedPattern(username, timestamp, website);
        String[] userName1 = {"u1","u1","u1","u2","u2","u2"};
        int[] time1 = {1,2,3,4,5,6};
        String[] website1 = {"a","b","a","a","b","c"};
        List<String> bb = mostVisitedPattern(userName1, time1, website1);
    }
}
class WebsiteTime{
    String website;
    Integer time;
    WebsiteTime(){}
    WebsiteTime(String website, Integer time){
        this.website = website;
        this.time = time;
    }
}
