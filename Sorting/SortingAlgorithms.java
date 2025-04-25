package Sorting;

/**
 * Collection of sorting algorithms implemented in Java
 */
public class SortingAlgorithms {
    
    /**
     * Bubble Sort
     * Time Complexity: O(n²) average and worst case
     * Space Complexity: O(1)
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean swapped = false;
            
            // Last i elements are already sorted
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // If no swapping occurred in this pass, array is sorted
            if (!swapped) {
                break;
            }
        }
    }
    
    /**
     * Selection Sort
     * Time Complexity: O(n²) average and worst case
     * Space Complexity: O(1)
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted part
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            
            // Swap the found minimum element with the first element
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
    
    /**
     * Insertion Sort
     * Time Complexity: O(n²) average and worst case, O(n) best case
     * Space Complexity: O(1)
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            // Move elements greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            arr[j + 1] = key;
        }
    }
    
    /**
     * Merge Sort
     * Time Complexity: O(n log n) for all cases
     * Space Complexity: O(n)
     */
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        
        // Create temporary array for merging
        int[] temp = new int[arr.length];
        mergeSortHelper(arr, 0, arr.length - 1, temp);
    }
    
    private static void mergeSortHelper(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            // Sort first and second halves
            mergeSortHelper(arr, left, mid, temp);
            mergeSortHelper(arr, mid + 1, right, temp);
            
            // Merge the sorted halves
            merge(arr, left, mid, right, temp);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // Copy data to temp arrays
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        
        int i = left;      // Initial index of first subarray
        int j = mid + 1;   // Initial index of second subarray
        int k = left;      // Initial index of merged subarray
        
        // Merge the temp arrays back
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }
        
        // Copy the remaining elements of left subarray
        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }
        
        // Note: We don't need to copy remaining elements of right subarray
        // as they are already in correct positions
    }
    
    /**
     * Quick Sort
     * Time Complexity: O(n log n) average, O(n²) worst case
     * Space Complexity: O(log n) due to recursion stack
     */
    public static void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }
    
    private static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get pivot position
            int pi = partition(arr, low, high);
            
            // Sort elements before and after partition
            quickSortHelper(arr, low, pi - 1);
            quickSortHelper(arr, pi + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        // Choose the rightmost element as pivot
        int pivot = arr[high];
        
        // Index of smaller element
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
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
    
    /**
     * Heap Sort
     * Time Complexity: O(n log n) for all cases
     * Space Complexity: O(1)
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;
        
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        
        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
    
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;   // Initialize largest as root
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        
        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
    
    /**
     * Counting Sort
     * Time Complexity: O(n + k) where k is the range of input
     * Space Complexity: O(n + k)
     */
    public static void countingSort(int[] arr) {
        if (arr.length == 0) return;
        
        // Find the maximum and minimum values
        int max = arr[0], min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }
        
        int range = max - min + 1;
        
        // Create count array and output array
        int[] count = new int[range];
        int[] output = new int[arr.length];
        
        // Count occurrences
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        
        // Update count to contain position of each element in output
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        
        // Build the output array
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        
        // Copy output array to arr
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
    
    /**
     * Radix Sort
     * Time Complexity: O(d * (n + k)) where d is the number of digits and k is the base (10)
     * Space Complexity: O(n + k)
     */
    public static void radixSort(int[] arr) {
        // Find the maximum number to know number of digits
        int max = getMax(arr);
        
        // Do counting sort for every digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }
    
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; // 0-9 digits
        
        // Count occurrences of each digit
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        
        // Change count[i] so that it contains actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        
        // Copy the output array to arr[]
        System.arraycopy(output, 0, arr, 0, n);
    }
    
    /**
     * Shell Sort
     * Time Complexity: Depends on gap sequence, generally O(n^(4/3)) to O(n^(3/2))
     * Space Complexity: O(1)
     */
    public static void shellSort(int[] arr) {
        int n = arr.length;
        
        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort
            for (int i = gap; i < n; i++) {
                // Save arr[i] in temp and make a hole at position i
                int temp = arr[i];
                
                // Shift earlier gap-sorted elements up until the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                
                // Put temp (the original a[i]) in its correct location
                arr[j] = temp;
            }
        }
    }
    
    /**
     * Bucket Sort
     * Time Complexity: O(n + k) average case, O(n²) worst case
     * Space Complexity: O(n + k)
     * Note: This implementation works for arrays with values between 0 and 1
     */
    public static void bucketSort(double[] arr) {
        if (arr.length == 0) return;
        
        int n = arr.length;
        
        // Create n empty buckets
        @SuppressWarnings("unchecked")
        java.util.ArrayList<Double>[] buckets = new java.util.ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new java.util.ArrayList<>();
        }
        
        // Put array elements in different buckets
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (n * arr[i]);
            buckets[bucketIndex].add(arr[i]);
        }
        
        // Sort individual buckets using insertion sort
        for (int i = 0; i < n; i++) {
            java.util.Collections.sort(buckets[i]);
        }
        
        // Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }
    
    /**
     * Tim Sort (Java's Arrays.sort() for objects since Java 7)
     * Uses a combination of insertion sort and merge sort
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void timSort(int[] arr) {
        // In Java, you'd typically use Arrays.sort() which uses TimSort for objects
        // This is a simplified implementation
        int n = arr.length;
        final int RUN = 32;  // Size of segments sorted using insertion sort
        
        // Sort individual subarrays of size RUN
        for (int i = 0; i < n; i += RUN) {
            insertionSortRange(arr, i, Math.min(i + RUN - 1, n - 1));
        }
        
        // Start merging from size RUN
        for (int size = RUN; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);
                
                if (mid < right) {
                    merge(arr, left, mid, right, new int[n]);
                }
            }
        }
    }
    
    private static void insertionSortRange(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            arr[j + 1] = key;
        }
    }
    
    /**
     * Utility method to print an array
     */
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array:");
        printArray(arr);
        
        // Test a sorting algorithm (uncomment to test)
        // bubbleSort(arr);
        // selectionSort(arr);
        // insertionSort(arr);
        // mergeSort(arr);
        quickSort(arr);
        // heapSort(arr);
        // countingSort(arr);
        // radixSort(arr);
        // shellSort(arr);
        // timSort(arr);
        
        System.out.println("Sorted array:");
        printArray(arr);
    }
}
