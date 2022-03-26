package sort.rank;

import java.util.*;

public class RankTeamsbyVotes   {
    public String rankTeams(String[] votes) {
        int length = votes[0].length();
        String[][] rank = new String[length][length];
        for(int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                rank[i][j] = "0";
            }
        }
        Map<String, Integer> map = getPosMap(votes[0]);
        for (String vote : votes) {
            for (int i = 0; i < length; i++) {
                String curS = vote.charAt(i) + "";
                int index = map.get(curS);
                rank[index][i] = String.valueOf(Integer.parseInt(rank[index][i]) + 1);
            }
        }

        List<Word> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            String s = votes[0].charAt(i) + "";
            int index = map.get(s);
            String[] r = rank[index];
            Word w = new Word(s, r);
            list.add(w);
        }
        Collections.sort(list, (w1, w2)-> {
            String[] arr1 = w1.rank;
            String[] arr2 = w2.rank;
            for (int i = 0; i < arr1.length; i++) {
                String s1 = arr1[i];
                String s2 = arr2[i];
                if (s1.length() == s2.length()) {
                    if (s1.equals(s2)) {
                        continue;
                    } else {
                        return s2.compareTo(s1);
                    }
                } else if (s1.length() > s2.length()) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return w1.s.compareTo(w2.s);
        });
        StringBuilder sb = new StringBuilder();
        for(Word w : list) {
            sb.append(w.s);
        }
        return sb.toString();
    }

    private Map<String, Integer> getPosMap(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length();i++) {
            map.put(s.charAt(i) + "", i);
        }
        return map;
    }
}

