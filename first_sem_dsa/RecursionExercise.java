package first_sem_dsa;
public class RecursionExercise {
    public static void main(String[] args){
        countDown(5);
        int result =  powerFun(4,3);
        System.out.println(result + " power ");
    }

    public static  void countDown(int n){
        if(n == 0){
            System.out.println("Happy new year !");
            return;
        }
        System.out.println(n );
        countDown(n-1);
    }

    public static int powerFun(int n , int power){
        // 2 * 2 * 2 
        if(power <= 0){
            return 1;
        }else if(power == 1){
            return n;
        }
        
        int result = n * powerFun(n,power -1);
        
        return result;
    }


    
}
