package oa.wepay.oa;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int i = 0;
        List<String> res = new ArrayList<>();
        while (i < words.length) {
            List<String> lineWords = new ArrayList<>();
            int last = getWordsForALine(i, words, maxWidth, lineWords);
            //last line achived
            if (last > words.length - 1) {
                String lastLine = buildLastLine(lineWords, maxWidth);
                res.add(lastLine);
            } else {
                String midLine = buildMidLine(lineWords, maxWidth);
                res.add(midLine);
            }
            i = last;
        }
        return res;
    }

    private String buildMidLine(List<String> lineWords, int maxWidth) {
        int gap = lineWords.size() - 1;
        StringBuilder sb = new StringBuilder();
        int wordsLength = getSize(lineWords);
        if (gap == 0) {
            return buildLastLine(lineWords, maxWidth);
        }
        int numSpace = (maxWidth - wordsLength) / gap;
        int res = (maxWidth - wordsLength) % gap;
        for (int i = 0; i < gap; i++) {
            sb.append(lineWords.get(i));
            for (int j = 0; j < numSpace; j++) {
                sb.append(" ");
            }
            if (i < res) {
                sb.append(" ");
            }
        }
        sb.append(lineWords.get(lineWords.size() - 1));
        return sb.toString();
    }

    private int getSize(List<String> lineWords) {
        int count = 0;
        for (String s : lineWords) {
            count += s.length();
        }
        return count;
    }

    private String buildLastLine(List<String> lineWords, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; i < lineWords.size() - 1; i ++) {
            sb.append(lineWords.get(i)).append(" ");
        }
        sb.append(lineWords.get(i));
        maxWidth -= sb.length();
        for (int j = 0; j < maxWidth; j++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private int getWordsForALine(int start, String[] words, int maxWidth, List<String> lineWords) {
        int totalChars = 0;
        int i = start;
        for (; i < words.length; i++) {
            totalChars += words[i].length() + 1;//1 space
            if (totalChars - 1 > maxWidth) {
                break;
            }
            lineWords.add(words[i]);
        }
        return i;
    }

    @Test
    public void test() {
        String[] s = new String[]{"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        List<String> ans = fullJustify(s, 16);
    }

}
