package TicTacToe.Model;

import java.util.ArrayList;
import java.util.List;


public class Board {
    public int size;
    public PlayingPiece[][] board;

    public static volatile Board instance;

    private Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int column, PlayingPiece playingPiece) {
        if (row < 0 || column < 0 || row >= size || column >= size) return false;
        if (board[row][column] != null) return false;
        board[row][column] = playingPiece;
        return true;
    }

    public List<List<Integer>> getFreeCells() {
        List<List<Integer>> freeCells = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (board[i][j] == null) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    freeCells.add(temp);
                }
            }
        }
        return freeCells;
    }

    public void printBoard() {
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pieceType.name() + " ");
                } else {
                    System.out.print(" ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    public static Board getBoardInstance(int size) {
        if (instance == null) {
            synchronized (Board.class) {
                instance = new Board(size);
            }
        }
        return instance;
    }
}
