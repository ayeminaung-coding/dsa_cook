package Sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] data = { 77, 44, 99, 66, 33, 55, 88, 22 };
        System.out.print("Original array: ");
        print(data);
        
        quickSort(data);
        
        System.out.print("Sorted array: ");
        print(data);
    }
    
    public static void print(int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1) {
                System.out.print(a[i]);
            } else {
                System.out.print(a[i] + ", ");
            }
        }
        System.out.println("]");
    }
    
    // Main quickSort method that initiates the sorting process
    public static void quickSort(int[] data) {
        if (data == null || data.length == 0) {
            return;
        }
        qSort(data, 0, data.length - 1);
    }
    
    // Recursive quickSort method that sorts subarrays
    private static void qSort(int[] data, int low, int high) {
        int split = partition(data, low, high);
        
        if (low < split) {
            qSort(data, low, split); // Sort left subarray
        }
        
        if (high > split + 1) {
            qSort(data, split + 1, high); // Sort right subarray
        }
    }
    
    // Partition method that selects a pivot and places it in the correct position
    private static int partition(int[] data, int low, int high) {
        // Choose pivot (using middle element to avoid worst-case performance)
        int pivotIndex = low + (high - low) / 2;
        int pivotValue = data[pivotIndex];
        
        // Move pivot to the end temporarily
        swap(data, pivotIndex, high);
        
        int storeIndex = low;
        
        // Move elements smaller than pivot to the left side
        for (int i = low; i < high; i++) {
            if (data[i] < pivotValue) {
                swap(data, i, storeIndex);
                storeIndex++;
            }
        }
        
        // Move pivot to its final position
        swap(data, storeIndex, high);
        
        return storeIndex;
    }
    
    // Helper method to swap two elements in an array
    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
