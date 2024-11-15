package TicTacToe;

public class main {
       public static void main(String[] args){
              Game game = new Game();
              game.initializeGame();
              System.out.print("game winner is :  " + game.startGame());
       }
}
