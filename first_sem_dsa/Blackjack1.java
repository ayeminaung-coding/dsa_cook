package first_sem_dsa;
import java.util.Scanner;
import java.util.Random;

public class Blackjack1 {
     private int[] CardYou;
     private int[] CardComputer;
     private int numYourCard;
     private int sumYou;
     private int sumComputer;
     private String winner;

     public Blackjack1() {
          CardYou = new int[5];
          CardComputer = new int[2];
          numYourCard = 2;
          sumYou = 0;
          sumComputer = 0;
          winner = "";
          // Initialize game data
          Random rand = new Random();
          // Player
          CardYou[0] = rand.nextInt(11) + 1;
          CardYou[1] = rand.nextInt(11) + 1;
          CardComputer[0] = rand.nextInt(11) + 1;
          CardComputer[1] = rand.nextInt(11) + 1;
     }

     public void showYourCard() {
          System.out.print("You: ");
          for (int i = 0; i < CardYou.length; i++) {
               System.out.print(CardYou[i] + " ");
          }
          System.out.println("\nComputer: ? ?");
     }

     public void showComputerCard() {
          System.out.print("Computer: ");
          for (int i = 0; i < 2; i++) {
               System.out.print(CardComputer[i] + " ");
          }
          System.out.println();
     }

     public void addMoreCard() {
          Random rand = new Random();
          numYourCard += 1;
          CardYou[numYourCard - 1] = rand.nextInt(11) + 1;
     }

     public void showSumCard() {
          System.out.println("Sum of your cards = " + sumYou);
          System.out.println("Sum of computer cards = " + sumComputer);
     }

     public void CalculateSum() {
          sumYou = 0;
          sumComputer = 0;
          for (int i = 0; i < numYourCard; i++) {
               sumYou += CardYou[i];
          }
          for (int i = 0; i < 2; i++) {
               sumComputer += CardComputer[i];
          }
     }

     public boolean isEnd() {
          CalculateSum();
          if (sumYou > 21) {
               return true;
          }
          return false;
     }

     public void checkWinner() {
          if (sumYou > 21) {
               winner = "The winner is computer";
          } else if (sumComputer > 21) {
               winner = "The winner is you";
          } else if (sumYou > sumComputer) {
               winner = "The winner is you";
          } else {
               winner = "The winner is computer";
          }
     }

     public String getWinner() {
          return winner;
     }

     // Main method
     public static void main(String[] args) {
          Blackjack1 game = new Blackjack1();
          
          game.showYourCard();
          Scanner sc = new Scanner(System.in);
          do {
               System.out.print("Want another card? <y/n> _ _ _");
               String option = sc.nextLine();
               if (option.equalsIgnoreCase("y") ||
                    option.equalsIgnoreCase("yes")) {
                    game.addMoreCard();
                    game.showYourCard();

                    // Check if the game ends
                    if (game.isEnd()) {
                         break;
                    }
               } else {
                    break;
               }
          } while (game.numYourCard < 5);
          game.CalculateSum();
          game.showSumCard();
          game.checkWinner();
          System.out.println("Winner is : " + game.getWinner());
     }
}