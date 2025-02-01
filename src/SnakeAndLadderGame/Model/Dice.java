package SnakeAndLadderGame.Model;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
       int diceCount ;
       int minimum = 1 ;
       int maximum = 6;

       public Dice(int diceCount){
              this.diceCount = diceCount ;
       }

       public int rollDice(){
              int totalSum = 0 ;
              int diceUsed = 0 ;
              while (diceUsed < diceCount){
                  totalSum += ThreadLocalRandom.current().nextInt(minimum , maximum + 1);
                  diceUsed++;
              }
              return totalSum ;
       }

}
