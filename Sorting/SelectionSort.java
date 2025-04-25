package Sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] data = { 77, 44, 99, 66, 33, 55, 88, 22 };
        print(data);
        selectionSort(data);
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

    public static void selectionSort(int[] a) {
        // find min index
        for (int i = 0; i <= a.length - 1; i++) {
            int jMin = i;

            for (int j = i+1; j < a.length; j++) {
                if (a[j] < a[jMin]) {
                    jMin = j;
                }
            }

            swap(a, jMin, i);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int num = a[i];
        a[i] = a[j];
        a[j] = num;

    }

}
