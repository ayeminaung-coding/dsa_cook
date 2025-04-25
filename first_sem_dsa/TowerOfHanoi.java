package first_sem_dsa;
public class TowerOfHanoi {
    // Counter for number of moves
    private static int moveCount = 0;

    public static void solveTowerOfHanoi(int n, char source, char auxiliary, char destination) {
        moveCount++;
        
        // Base case: If only one disk, move it directly
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        
        // Step 1: Move n-1 disks from source to auxiliary using destination as temporary
        solveTowerOfHanoi(n - 1, source, destination, auxiliary);
        
        // Step 2: Move the largest disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        
        // Step 3: Move n-1 disks from auxiliary to destination using source as temporary
        solveTowerOfHanoi(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        int numberOfDisks = 3;
        System.out.println("Tower of Hanoi solution for " + numberOfDisks + " disks:");
        solveTowerOfHanoi(numberOfDisks, 'A', 'B', 'C');
    }
}