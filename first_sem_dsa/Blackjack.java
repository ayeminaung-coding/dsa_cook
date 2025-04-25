package first_sem_dsa;
import java.util.Scanner;

public class Blackjack {
    private int[] CardYou;
    private int[] CardComputer;
    private int numYourCard;
    private int sumYou;
    private int sumComputer;
    private String winner;

    public Blackjack() {
        CardYou = new int[5];
        CardComputer = new int[5];
        numYourCard = 5;
        sumYou = 0;
        sumComputer = 0;
        winner = "";
    }

    public void showYourCard(){
        System.out.print("You: ");
        for(int i=0; i<numYourCard; i++){
            System.out.print(CardYou[i] + " ");
        }
        System.out.println();
    }

    public void showComputerCard(){
        System.out.print("Computer: ");
        for(int i=0; i<2; i++){
            System.out.print(CardComputer[i] + " ");
        }
        System.out.println();
    }

    public void addMoreCard(){
        // CardYou[2] = (int)(Math.random()*11)+1;
        numYourCard++;
        for(int i=2; i<numYourCard; i++){
            CardYou[i] = (int)(Math.random()*11)+1;
        }
    }

    public void showSumCard(){
        sumYou = 0;
        sumComputer = 0;
        for(int i=0; i<numYourCard; i++){
            sumYou += CardYou[i];
        }
        for(int i=0; i<2; i++){
            sumComputer += CardComputer[i];
        }
        System.out.println("Sum of your cards = " + sumYou);
        System.out.println("Sum of computer cards = " + sumComputer);
    }

    public boolean isEnd(){
        if(sumYou>21 || sumComputer>21){
            return true;
        }
        return false;
    }

    public void checkWinner(){
        if(sumYou>21){
            winner = "The winner is computer";
        }else if(sumComputer>21){
            winner = "The winner is you";
        }else if(sumYou>sumComputer){
            winner = "The winner is you";
        }else{
            winner = "The winner is computer";
        }
    }

    public String getWinner(){
        return winner;
    }

    //main method
    public  static void main(String[] args){
        Blackjack game = new Blackjack();
        game.CardYou[0] = (int)(Math.random()*11)+1;
        game.CardYou[1] = (int)(Math.random()*11)+1;
        game.CardComputer[0] = (int)(Math.random()*11)+1;
        game.CardComputer[1] = (int)(Math.random()*11)+1;
        game.showYourCard();
        System.out.println("Computer: " + "? ?");

        System.out.println("Want another card?  <y/n> _ _ _");
        Scanner sc = new Scanner(System.in);
        String option = sc.nextLine();

        if(option.equalsIgnoreCase("y") || option.equalsIgnoreCase("yes")){
            
            game.addMoreCard();
        }else{
            game.showSumCard();
        }

        
        
        while(!game.isEnd()){
            game.checkWinner();
            if(game.getWinner().equals("The winner is you") || game.getWinner().equals("The winner is computer")){
                break;
            }
            game.addMoreCard();
            game.showSumCard();
        }
        game.checkWinner();
        System.out.println(game.getWinner());
    } 
}
