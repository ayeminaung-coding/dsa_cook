package first_sem_dsa;
import java.util.Scanner;

public class CH5_AS3 {
    public static void main(String[] args) {
            System.out.print("Enter BASE number: ");
            Scanner key = new Scanner(System.in);
            int x = key.nextInt();
            System.out.print("Enter power number: ");
            int n = key.nextInt();
            int pow = 0;
            if(n > 0){
                for(int i = 0; i < n ; i++){
                    if(i == 0){
                        pow = x;
                    }else{
                        pow = pow * x;
                    }
                }
            }
            System.out.println("Power of " +x+" by "+n+" is " + pow);
      }
}

// public class CH5_AS3{
// public static void main(String[] args) {
// System.out.print("Enter BASE number: ");
// Scanner key = new Scanner(System.in);
// int x = key.nextInt();
// System.out.print("Enter power number: ");
// int n = key.nextInt();
// System.out.println("Power of " +x+" by "+n+" is " + powerOf(x, n));
// }

// public static int powerOf(int x, int n) {
// if (n == 0)
// return 1;
// else
// return x * powerOf(x, n-1);
// }
// }
