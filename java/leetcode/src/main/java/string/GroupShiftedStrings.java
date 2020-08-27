package string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> diffMap = new HashMap<>();
        for(String str : strings){
            StringBuilder sb = new StringBuilder();
            if(str.length() == 1){
                sb.append("0");
            }else{
                for(int i = 1; i < str.length(); i++){
                    int diff = str.charAt(i) - str.charAt(i-1);
                    sb.append(diff > 0 ? diff : 26+diff);
                }
            }
            String key = sb.toString();
            List<String> values = diffMap.getOrDefault(key, new ArrayList<>());
            values.add(str);
            diffMap.put(key, values);
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : diffMap.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
    @Test
    public void test(){
        String[] s = new String[]{"az", "ba"};
        List<List<String>> ans = groupStrings(s);
    }
}
