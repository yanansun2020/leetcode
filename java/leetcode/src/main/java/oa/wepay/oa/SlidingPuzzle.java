package oa.wepay.oa;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * try all directions
 * all possible combinations
 */
public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] correctBoard = new int[row][col];
        initCorrectBoard(correctBoard, row, col);
        Queue<Node> queue = new LinkedList<>();
        initQueue(board, queue);
        return bfs(board, queue, Arrays.deepToString(correctBoard));
    }

    private int bfs(int[][] board, Queue<Node> queue, String target) {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int count = 0;
        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                Node topEle = queue.poll();
                if (target.equals(Arrays.deepToString(topEle.board))) {
                    return count - 1;
                }
                //if the the position has correct value
                //switch with adjacent values
                for (int[] dir : dirs) {
                    int x = topEle.row + dir[0];
                    int y = topEle.col + dir[1];
                    if (!isValid(x, y, board)) {
                        continue;
                    }
                    int[][] tmpBoard = copyBoard(topEle.board);
                    int tmp = tmpBoard[x][y];
                    tmpBoard[x][y] = 0;
                    tmpBoard[topEle.row][topEle.col] = tmp;
                    String tmpBoardStr = Arrays.deepToString(tmpBoard);
                    if (visited.contains(tmpBoardStr)) {
                        continue;
                    }
                    visited.add(tmpBoardStr);
                    queue.offer(new Node(x, y, tmpBoard));
                }
            }
        }
        return - 1;
    }

    private int[][] copyBoard(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            newBoard[i] = board[i].clone();
        }
        return newBoard;
    }

    private boolean isValid(int x, int y, int[][] board) {
        if (x < 0 || x >=board.length || y < 0 || y >= board[0].length) {
            return false;
        }
        return true;
    }

    private void initQueue(int[][] board, Queue<Node> queue) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 0) {
                    queue.offer(new Node(i, j, board));
                    break;
                }
            }
        }

    }

    private void initCorrectBoard(int[][] board, int row, int col) {
        int k = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == row -1 && j == col - 1) board[i][j] = 0;
                else board[i][j] = k++;
            }
        }
    }
    @Test
    public void test() {
        int[][] board = new int[][]{{1,2,3},{4,0,5}};
        int num = slidingPuzzle(board);
        board = new int[][]{{4,1,2},{5,0,3}};
        num = slidingPuzzle(board);
        board = new int[][]{{1,2,3},{5,4,0}};
        num = slidingPuzzle(board);
    }
}

class Node{
    int row;
    int col;
    int[][] board;
    Node(){}
    Node(int row, int col, int[][] board){
        this.row = row;
        this.col = col;
        this.board = board;
    }
}
