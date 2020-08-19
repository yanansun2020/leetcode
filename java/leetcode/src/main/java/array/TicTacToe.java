package array;

import java.util.HashMap;
import java.util.Map;

public class TicTacToe {
    /** Initialize your data structure here. */
//    first element is for player1
    Map<Integer, int[]> rowMap;
    Map<Integer, int[]> colMap;
    int[] diagonalOccupied ;
    int[] diagonalOccupied1;
    int capacity;
    public TicTacToe(int n) {
        rowMap = new HashMap<>();
        colMap = new HashMap<>();
        diagonalOccupied = new int[2];
        diagonalOccupied1 = new int[2];
        this.capacity = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int[] occupiedRow = rowMap.getOrDefault(row, new int[2]);
        int[] occupiedCol = colMap.getOrDefault(col, new int[2]);
        //check diagonal
        if(row == col){
            diagonalOccupied[player-1] += 1;
            if(diagonalOccupied[player-1] == this.capacity){
                return player;
            }
        }
        if(row + col == capacity-1){
            diagonalOccupied1[player-1] += 1;
            if (diagonalOccupied1[player-1] == this.capacity){
                return player;
            }
        }
        occupiedRow[player-1]++;
        occupiedCol[player-1]++;
        rowMap.put(row, occupiedRow);
        colMap.put(col, occupiedCol);
        if(occupiedRow[0] == this.capacity || occupiedCol[0] == this.capacity){
            return 1;
        }
        if(occupiedRow[1] == this.capacity || occupiedCol[1] == this.capacity){
            return 2;
        }
        return 0;
    }
    public static void main(String[] args){
        TicTacToe toe = new TicTacToe(3);
        int a = toe.move(0,0,1);
        int b = toe.move(0,2,2);
        int c = toe.move(2,2,1);
        int d = toe.move(1,1,2);
        int e = toe.move(2,0,1);
        int f = toe.move(1,0,2);
        int g = toe.move(2,1,1);
    }
}
