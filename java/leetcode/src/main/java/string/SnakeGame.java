package string;

import org.junit.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

public class SnakeGame {
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    Deque<Position> deque;
    int[][] food;
    int score;
    Map<String, int[]> directionsMap;
    int width;
    int height;
    int foodPosition;
    public SnakeGame(int width, int height, int[][] food) {
        deque = new LinkedList<>();
        score = 0;
        this.width = width;
        this.height = height;
        this.food = food;
        this.foodPosition = 0;
        directionsMap = new HashMap<>();
        directionsMap.put("U", new int[]{-1, 0});
        directionsMap.put("L", new int[]{0, -1});
        directionsMap.put("R", new int[]{0, 1});
        directionsMap.put("D", new int[]{1, 0});
        deque.add(new Position(0, 0));
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] directions = directionsMap.get(direction);
        Position head = deque.getLast();
        int x = head.x + directions[0];
        int y = head.y + directions[1];
        if(x <0 || x > height-1 || y < 0 || y > width-1){
            return -1;
        }
        Position header1 = new Position(x, y);
        if(foodPosition < food.length && x == food[foodPosition][0] && y == food[foodPosition][1]){
            foodPosition++;
            score++;
        }else{
            deque.pollFirst();
        }
        if(deque.contains(header1)){
            return -1;
        }
        deque.add(header1);
        return score;
    }
//    @Test
    public static void main(String[] args){
//        int[][] food = {{1,2},{0,1}};
//        SnakeGame snake = new SnakeGame(3, 2, food);
//        int ans1 = snake.move("R");
//        int ans2 = snake.move("D");
//        int ans3 = snake.move("R");
//        int ans4 = snake.move("U");
//        int ans5 = snake.move("L");
//        int ans6 = snake.move("U");
//
//        SnakeGame snake1 = new SnakeGame(2, 2, new int[][]{{0,1}});
//        int ans10 = snake1.move("R");
//        int ans20 = snake1.move("D");
        /*SnakeGame snake1 = new SnakeGame(3, 3, new int[][]{{2,0},{0,0},{0,2},{0,1},{2,2},{0,1}});
        int ans10 = snake1.move("D");
        int ans20 = snake1.move("D");
        int ans21 = snake1.move("R");
        int ans22 = snake1.move("U");
        int ans23 = snake1.move("U");
        int ans24 = snake1.move("L");
        int ans25 = snake1.move("D");
        int ans26 = snake1.move("R");
        int ans11 = snake1.move("R");
        int ans27 = snake1.move("U");
        int ans28 = snake1.move("L");
        int ans29 = snake1.move("L");
        int ans101 = snake1.move("D");
        int ans201 = snake1.move("R");
        int ans203 = snake1.move("U");*/

        SnakeGame snake1 = new SnakeGame(3, 3, new int[][]{{2,0},{0,0},{0,2},{2,2}});
        int ans10 = snake1.move("D");
        int ans20 = snake1.move("D");
        int ans21 = snake1.move("R");
        int ans22 = snake1.move("U");
        int ans23 = snake1.move("U");
        int ans24 = snake1.move("L");
        int ans25 = snake1.move("D");
        int ans26 = snake1.move("R");
        int ans11 = snake1.move("R");
        int ans27 = snake1.move("U");
        int ans214 = snake1.move("L");
        int ans215 = snake1.move("D");
    }
}

class Position{
    int x;
    int y;
    Position(){}
    Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
            y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

