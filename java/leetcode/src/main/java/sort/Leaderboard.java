package sort;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leaderboard {
    Map<Integer, Score> scoreMap;
    public Leaderboard() {
        scoreMap = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        Score sc = scoreMap.getOrDefault(playerId, new Score());
        if (sc.score == score){
            return;
        }
        sc.score = score;
        scoreMap.put(playerId, sc);
    }

    public int top(int K) {
        PriorityQueue<Score> queue = new PriorityQueue<>((o1, o2) -> o1.score - o2.score);
        for (Map.Entry<Integer, Score> entry : scoreMap.entrySet()){
            queue.offer(entry.getValue());
            if (queue.size() > K){
                queue.poll();
            }
        }
        int sum = 0;
        while (!queue.isEmpty()){
            sum += queue.poll().score;
        }
        return sum;
    }

    public void reset(int playerId) {
        scoreMap.put(playerId, new Score(playerId, 0));
    }
}
class Score{
    int playerId;
    int score;
    Score(){}
    Score(int playerId, int score){
        this.playerId = playerId;
        this.score = score;
    }
}
