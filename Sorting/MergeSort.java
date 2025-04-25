package Sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] data = { 77, 44, 99, 66, 33, 55, 88, 22 };
        print(data);
        mergeSort(data, 0, data.length-1);
        print(data);
    }

    public static void print(int[] a) {
        System.out.print("[");
        for (int i = 0; i <= a.length - 1; i++) {
            if (i == a.length - 1) {
                System.out.print(a[i]);
            } else {
                System.out.print(a[i] + ",");
            }
        }
        System.out.println("]");
    }

    public static void mergeSort(int[] a, int low, int high) {
        // Base case: If the array segment has more than one element
        if (low < high) {
            int mid = (low + high) / 2;
            
            // Sort first and second halves
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            
            // Merge the sorted halves
            merge(a, low, mid, high);
        }
    }

    public static void merge(int[] a, int low, int mid, int high) {
        // Size of the two subarrays to be merged
        int n1 = mid - low + 1;
        int n2 = high - mid;
        
        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        
        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = a[low + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = a[mid + 1 + j];
        }
        
        // Merge the temporary arrays back into a[low..high]
        
        // Initial indices of the subarrays
        int i = 0, j = 0;
        
        // Initial index of merged subarray
        int k = low;
        
        // Compare elements from both arrays and place the smaller one in the merged array
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                a[k] = leftArray[i];
                i++;
            } else {
                a[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements of leftArray[] if any
        while (i < n1) {
            a[k] = leftArray[i];
            i++;
            k++;
        }
        
        // Copy remaining elements of rightArray[] if any
        while (j < n2) {
            a[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void swap(int[] a, int i, int j) {
        int num = a[i];
        a[i] = a[j];
        a[j] = num;

    }
}
