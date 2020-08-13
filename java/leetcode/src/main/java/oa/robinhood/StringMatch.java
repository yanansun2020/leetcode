package oa.robinhood;

public class StringMatch {
    int count = 0;

    public int getMatchCount(String s, String t){
        int count_ = 0;
        for(int i =0; i <= s.length()-5; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i));
            sb.append(s.charAt(i+2));
            sb.append(s.charAt(i+4));
            if (sb.toString().equals(t)){
                count_++;
            }
        }
        return count_;
    }

    public int getMatchCount_dfs(String s, String t){
        count = 0;
        dfs(0,s, "", t);
        return count;
    }
    public void dfs(int index, String s, String curStr, String t){
        if(curStr.length() == t.length()){
            System.out.println(curStr);
        }
        if(index >= s.length()){
            return;
        }
        if(curStr.length() > t.length()){
            return;
        }
        for(int i =index; i<s.length(); i++){
            if((curStr+s.charAt(i)).equals(t)){
                count+=1;
                return;
            }
            if(curStr.length() == t.length()-1){
                return;
            }
            dfs(i+2, s, curStr+s.charAt(i), t);
        }
    }

    public static void main(String[] args) {
        StringMatch test = new StringMatch();
        System.out.println(test.getMatchCount("babca", "bba"));
        System.out.println(test.getMatchCount("ABCDEEG", "BDE"));
    }
}
