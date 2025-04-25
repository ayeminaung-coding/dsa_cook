package Sorting;

// Implementation 1: Classical QuickSort with Last Element as Pivot
public class ClassicQuickSort {
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        quickSort(arr, 0, arr.length - 1);
    }
    
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot position
            int pivotIndex = partition(arr, low, high);
            
            // Recursively sort the sub-arrays
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    private int partition(int[] arr, int low, int high) {
        // Use the last element as pivot
        int pivot = arr[high];
        
        // Index of smaller element
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;
                
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // Swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }
}

// Implementation 2: QuickSort with Random Pivot Selection
import java.util.Random;

public class RandomizedQuickSort {
    private Random random = new Random();
    
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        quickSort(arr, 0, arr.length - 1);
    }
    
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = randomPartition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    private int randomPartition(int[] arr, int low, int high) {
        // Choose a random pivot between low and high
        int randomPivotIndex = low + random.nextInt(high - low + 1);
        
        // Swap the random pivot with the high element
        swap(arr, randomPivotIndex, high);
        
        return partition(arr, low, high);
    }
    
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// Implementation 3: 3-Way QuickSort (Dutch National Flag Algorithm)
public class ThreeWayQuickSort {
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        quickSort(arr, 0, arr.length - 1);
    }
    
    private void quickSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
            
        // Values equal to pivot
        int pivot = arr[high];
        
        int lt = low;      // less than pivot
        int gt = high;     // greater than pivot
        int i = low;       // current element
        
        while (i <= gt) {
            if (arr[i] < pivot) {
                swap(arr, lt, i);
                lt++;
                i++;
            } else if (arr[i] > pivot) {
                swap(arr, i, gt);
                gt--;
                // Note: we don't increment i here because we need to check the swapped element
            } else {
                i++;
            }
        }
        
        // Now arr[low...lt-1] < pivot = arr[lt...gt] < arr[gt+1...high]
        quickSort(arr, low, lt - 1);
        quickSort(arr, gt + 1, high);
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// Usage example for all three implementations
public class QuickSortDemo {
    public static void main(String[] args) {
        int[] arr1 = {10, 7, 8, 9, 1, 5};
        int[] arr2 = {10, 7, 8, 9, 1, 5};
        int[] arr3 = {10, 7, 8, 9, 1, 5};
        
        System.out.println("Original array:");
        printArray(arr1);
        
        // Classic QuickSort
        ClassicQuickSort classicSorter = new ClassicQuickSort();
        classicSorter.sort(arr1);
        System.out.println("\nAfter Classic QuickSort:");
        printArray(arr1);
        
        // Randomized QuickSort
        RandomizedQuickSort randomSorter = new RandomizedQuickSort();
        randomSorter.sort(arr2);
        System.out.println("\nAfter Randomized QuickSort:");
        printArray(arr2);
        
        // 3-Way QuickSort
        ThreeWayQuickSort threeWaySorter = new ThreeWayQuickSort();
        threeWaySorter.sort(arr3);
        System.out.println("\nAfter 3-Way QuickSort:");
        printArray(arr3);
    }
    
    static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}