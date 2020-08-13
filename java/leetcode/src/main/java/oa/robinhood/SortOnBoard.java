package oa.robinhood;

import java.util.List;
import java.util.PriorityQueue;

public class SortOnBoard {
    public List<List<Grid>> getMatrix(int[] query, List<List<Grid>> grid){
        Integer x = query[0];
        Integer y = query[1];
        Integer w = query[2];
        PriorityQueue<Integer> black = new PriorityQueue<>();
        PriorityQueue<Integer> white = new PriorityQueue<>();
        Integer x_range = x + w;
        Integer y_range = y + w;
        for(int i = x; i< x_range; i++){
            for(int j =y; j <y_range; j++ ){
                if(grid.get(i).get(j).colour == 1){
                    black.add(grid.get(i).get(j).number);
                }
                if(grid.get(i).get(j).colour == 0){
                    white.add(grid.get(i).get(j).number);
                }
            }
        }
        for(int i = x; i< x_range; i++){
            for(int j =y; j <y_range; j++ ){
                if(grid.get(i).get(j).colour == 1){
                    grid.get(i).get(j).number = black.poll();
                }
                if(grid.get(i).get(j).colour == 0){
                    grid.get(i).get(j).number = white.poll();
                }
            }
        }
        return grid;
    }
}

class Grid{
    int number;
    int colour;
}
