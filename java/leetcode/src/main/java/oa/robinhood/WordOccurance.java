package oa.robinhood;

public class WordOccurance {
    public int[] getMaxOccurance(String sequence, String[] words){
        int[] ans = new int[words.length];
        for(int i =0; i < words.length; i++){
            ans[i] = getWordOccurance(sequence, words[i]);
        }
        return ans;
    }

    public int getWordOccurance(String sequence, String word){
        int length = word.length();
        int curCount = 0;
        int globalCount = 0;
        int i = 0;
        while (i<= sequence.length() - length){
            String tmp = sequence.substring(i, i+length);
            if(tmp.equals(word)){
                curCount++;
                globalCount = Math.max(globalCount, curCount);
                i += length;
            }else{
                curCount = 0;
                i++;
            }
        }
        return globalCount;
    }

    public static void main(String[] args) {
        WordOccurance test = new WordOccurance();
        String[] words = {"ab", "babc", "bca"};
        System.out.println(test.getMaxOccurance("ababcbabc", words));
    }
}
