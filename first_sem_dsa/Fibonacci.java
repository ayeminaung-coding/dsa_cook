package first_sem_dsa;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        System.out.print("Please enter number : ");
        int n = key.nextInt();
        int prev = 0;
        int current = 1;
        int next = 0;
        for (int i = 2; i <= n ; i++) {
            next = prev + current;
            prev = current;
            current = next;
        }
        
        System.out.println("Fibonacci result is " + next );
    }

}
