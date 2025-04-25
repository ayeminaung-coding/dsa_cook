package first_sem_dsa;
import java.util.Scanner;

public class SimpleRecursion{
      public static void main(String[] args) {
          System.out.print("Please enter number : ");
          Scanner key = new Scanner(System.in);
          int n = key.nextInt();
          SimRecur(n);
      }

      public static void SimRecur(int count) {
          count--;
          System.out.print("The value of the count is "+ count + "\n");
          if(count>0){
               SimRecur(count);
           }
           System.out.println("Now the count is \"" + count + "\"");
           }

           @SuppressWarnings("removal")
        Boolean obj = new Boolean(true);
}



// Factoral(9) Tracing 
// factorial(1) = 1 * 1 = 1
// factorial(2) = 2 * 1 = 2
// factorial(3) = 3 * 2 = 6
// factorial(4) = 4 * 6 = 24
// factorial(5) = 5 * 24 = 120
// factorial(6) = 6 * 120 = 720
// factorial(7) = 7 * 720 = 5040
// factorial(8) = 8 * 5040 = 40320
// factorial(9) = 9 * 40320 = 362880


// F 7 Tracing
// F(n) = F(n-1) + F(n-2)
// F(7) = F(6) + F(5)
//      = 8 + 5 = 13

