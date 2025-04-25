package first_sem_dsa;
// 1. Simple Countdown Example (Linear Recursion)
public class RecursionExamples {
    public static void countdown(int n) {
        // Base case
        if (n <= 0) {
            System.out.println("Done!");
            return;
        }
        // Recursive case
        System.out.println(n);
        countdown(n - 1);
    }

    // 2. Array Sum Example (Linear Recursion)
    public static int arraySum(int[] arr, int n) {
        // Base case: if we've reached the end of array
        if (n <= 0) {
            return 0;
        }
        // Recursive case: sum of current element and sum of rest
        return arr[n-1] + arraySum(arr, n-1);
    }

    // 3. Factorial Example (Linear Recursion)
    public static int factorial(int n) {
        // Base case
        if (n == 0 || n == 1) {
            return 1;
        }
        // Recursive case
        return n * factorial(n - 1);
    }

    // 4. Fibonacci Example (Binary Recursion)
    // public static int fibonacci(int n) {
    //     // Base cases
    //     if (n <= 1) {
    //         return n;
    //     }
    //     // Recursive case (makes two recursive calls)
    //     return fibonacci(n - 1) + fibonacci(n - 2);
    // }
    public static int fibonacci(int n) {
        System.out.println("Calculating fibonacci(" + n + ")");
    
        // Base cases
        if (n <= 1) {
            System.out.println("Base case: fibonacci(" + n + ") = " + n);
            return n;
        }
    
        // Recursive case
        System.out.println("Breaking fibonacci(" + n + ") into fibonacci(" + 
                          (n-1) + ") + fibonacci(" + (n-2) + ")");
        int result = fibonacci(n - 1) + fibonacci(n - 2);
        System.out.println("fibonacci(" + n + ") = " + result);
        return result;
    }

    // 5. Binary Search Example (Binary Recursion)
    public static int binarySearch(int[] arr, int target, int left, int right) {
        // Base case: element not found
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        
        // Base case: element found
        if (arr[mid] == target) {
            return mid;
        }
        
        // Recursive cases
        if (arr[mid] > target) {
            return binarySearch(arr, target, left, mid - 1);
        } else {
            return binarySearch(arr, target, mid + 1, right);
        }
    }

    // 6. Print Array Elements (Linear Recursion)
    public static void printArray(int[] arr, int index) {
        // Base case
        if (index >= arr.length) {
            return;
        }
        // Process current element
        System.out.println(arr[index]);
        // Recursive call
        printArray(arr, index + 1);
    }

    // 7. Calculate Power (Linear Recursion)
    public static int power(int base, int exponent) {
        // Base cases
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        // Recursive case
        return base * power(base, exponent - 1);
    }

    // Main method to test the recursive functions
    public static void main(String[] args) {
        // Test countdown
        // System.out.println("Countdown from 5:");
        // countdown(5);

        // Test array sum
        int[] arr = {1, 2, 3, 4, 5};
        // System.out.println("\nSum of array: " + arraySum(arr, arr.length));

        // Test factorial
        // System.out.println("\nFactorial of 5: " + factorial(5));

        // Test fibonacci
        System.out.println("\nFibonacci of 6: " + fibonacci(6));

        // Test binary search
        int[] sortedArr = {1, 3, 5, 7, 9, 11, 13};
        System.out.println("\nIndex of 7: " + binarySearch(sortedArr, 7, 0, sortedArr.length - 1));

        // Test array printing
        System.out.println("\nPrinting array elements:");
        printArray(arr, 0);

        // Test power calculation
        System.out.println("\n2^4 = " + power(2, 4));
    }
}