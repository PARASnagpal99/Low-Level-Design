package SnakeAndLadderGame.Model;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
       Cell[][] cells ;

       public Board(int boardSize , int numberOfSnakes , int numberOfLadders){
           initializeCells(boardSize);
           addSnakesAndLadders(numberOfSnakes , numberOfLadders);
       }

       private void initializeCells(int boardSize){
           cells = new Cell[boardSize][boardSize];
           for(int i = 0 ; i < boardSize ; ++i){
               for(int j = 0 ; j < boardSize ; ++j){
                   Cell cellObj = new Cell();
                   cells[i][j] = cellObj ;
               }
           }
       }

       private void addSnakesAndLadders(int numberOfSnakes , int numberOfLadders){
               while (numberOfSnakes > 0){
                   int snakeHead = ThreadLocalRandom.current().nextInt(1 , cells.length * cells.length - 1) ;
                   int snakeTail = ThreadLocalRandom.current().nextInt(1 , cells.length * cells.length - 1);
                   if(snakeTail >= snakeHead){
                       continue;
                   }
                   Jump snakeObj = new Jump();
                   snakeObj.setStart(snakeHead);
                   snakeObj.setEnd(snakeTail);

                   Cell cell = getCell(snakeHead);
                   cell.setJump(snakeObj);
                   numberOfSnakes--;
               }

               while(numberOfLadders > 0){
                   int ladderHead = ThreadLocalRandom.current().nextInt(1 , cells.length * cells.length - 1) ;
                   int ladderTail = ThreadLocalRandom.current().nextInt(1 , cells.length * cells.length - 1);
                   if(ladderHead >= ladderTail){
                       continue;
                   }
                   Jump ladderObj = new Jump();
                   ladderObj.setStart(ladderHead);
                   ladderObj.setEnd(ladderTail);

                   Cell cell = getCell(ladderHead);
                   cell.setJump(ladderObj);
                   numberOfLadders--;
               }
       }


       Cell getCell(int playerPosition){
            int boardRow = playerPosition / cells.length;
            int boardColumn = playerPosition % cells.length ;
            return cells[boardRow][boardColumn];
       }
}
