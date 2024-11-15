package TicTacToe;

import TicTacToe.Model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {
    Deque<Player> players;
    Board gameBoard;

    public void initializeGame() {
        players = new LinkedList<>();

        PlayingPiece crossPlayingPiece = new PlayingPieceX();
        Player player1 = new Player("player1", crossPlayingPiece);

        PlayingPiece zeroPlayingPiece = new PlayingPieceO();
        Player player2 = new Player("player2", zeroPlayingPiece);

        players.add(player1);
        players.add(player2);

        gameBoard = Board.getBoardInstance(3);
    }

    public String startGame() {
        boolean noWinner = true;

        while (noWinner) {

            Player playerTurn = players.removeFirst();

            gameBoard.printBoard();

            List<List<Integer>> freeSpaces = gameBoard.getFreeCells();

            if (freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }

            System.out.print("Player : " + playerTurn.getPlayerId() + "Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.parseInt(values[0]);
            int inputColumn = Integer.parseInt(values[1]);

            boolean canPieceBeAdded = gameBoard.addPiece(inputRow, inputColumn, playerTurn.getPlayingPiece());
            if (!canPieceBeAdded) {
                System.out.println("Position Not Available , Please try again");
                players.addFirst(playerTurn);
                continue;
            }

            players.addLast(playerTurn);

            boolean winner = isCurrentPlayerWinner(playerTurn.getPlayingPiece().pieceType);
            if (winner) {
                return playerTurn.getPlayerId();
            }
        }

        return "Tie";
    }

    public boolean isCurrentPlayerWinner(PieceType pieceType) {
        for (int row = 0; row < gameBoard.size; ++row) {
            int pieceCount = 0;
            for (int col = 0; col < gameBoard.size; ++col) {
                if (gameBoard.board[row][col] != null && gameBoard.board[row][col].pieceType == pieceType) {
                    pieceCount++;
                }
            }
            if (pieceCount == gameBoard.size) return true;
        }

        for (int col = 0; col < gameBoard.size; ++col) {
            int pieceCount = 0;
            for (int row = 0; row < gameBoard.size; ++row) {
                if (gameBoard.board[row][col] != null && gameBoard.board[row][col].pieceType == pieceType) {
                    pieceCount++;
                }
            }
            if (pieceCount == gameBoard.size) return true;
        }

        int diagonalPieceCount = 0;
        for (int i = 0; i < gameBoard.size; ++i) {
            if (gameBoard.board[i][i] != null && gameBoard.board[i][i].pieceType == pieceType) {
                diagonalPieceCount++;
            }
        }
        if (diagonalPieceCount == gameBoard.size) return true;

        diagonalPieceCount = 0;
        int row = 0, col = gameBoard.size - 1;
        while (row < gameBoard.size && col >= 0) {
            if (gameBoard.board[row][col] != null && gameBoard.board[row][col].pieceType == pieceType) {
                diagonalPieceCount++;
            }
            row++;
            col--;
        }

        return diagonalPieceCount == gameBoard.size;
    }

}
