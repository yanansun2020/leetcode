package array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReorderDatainLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<String>();
        List<String> digitLog = new ArrayList<String>();
        for(String log: logs){
            String[] logArray = log.split(" ");
            if (isNumeric(logArray[1])){
                digitLog.add(log);
            }else{
                letterLogs.add(log);
            }
        }
        Collections.sort(letterLogs, (String o1, String o2)->{
            return o1.substring(o1.indexOf(" ")).compareTo(o2.substring(o2.indexOf(" ")));
        });
        String[] ans = new String[logs.length];
        for(int i =0; i< letterLogs.size(); i++){
            ans[i] = letterLogs.get(i);
        }
        for(int i =0; i< digitLog.size(); i++){
            ans[letterLogs.size()+i] = digitLog.get(i);
        }
        return ans;
    }
    public boolean isNumeric(String str) {
        // null or empty
        if (str == null || str.length() == 0) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    @Test
    public void test(){
        String[] array = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        reorderLogFiles(array);
    }
}
