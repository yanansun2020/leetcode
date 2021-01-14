package bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<String>();
        for(String word : wordList){
            wordSet.add(word);
        }
        if (beginWord == null || beginWord.length() == 0) {
            return 0;
        }
        if (endWord == null || endWord.length() == 0) {
            return 0;
        }
        Queue<Word> wordQueue = new LinkedList<Word>();
        wordQueue.offer(new Word(beginWord, 1));
        Set<String> visited = new HashSet<String>();
        visited.add(beginWord);
        while (!wordQueue.isEmpty()) {
            Word word = wordQueue.poll();
            if (word.word.equals(endWord)) {
                return word.step;
            }
            alterOneLetter(word, wordQueue, wordSet, visited);
        }
        return 0;
    }

    private void alterOneLetter(Word beginWord, Queue<Word> wordQueue, Set<String> wordList, Set<String> visited) {
        char[] charArray = beginWord.word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char temp = charArray[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == charArray[i]) {
                    continue;
                }
                charArray[i] = c;
                String tmp = new String(charArray);
                if( !visited.contains(tmp) && wordList.contains(tmp)){
                    wordQueue.offer(new Word(tmp, beginWord.step + 1));
                    visited.add(tmp);
                }
            }
            charArray[i] = temp;
        }
    }

    class Word {
        String word;
        int step;

        Word(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }
}
