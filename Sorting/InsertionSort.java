package Sorting;

public class InsertionSort {

    public static void main(String[] args) {
        int[] data = { 77, 44, 99, 66, 33, 55, 88, 22 };
        print(data);
        insertionSort(data);
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

    public static void swap(int[] a, int i, int j) {
        int num = a[i];
        a[i] = a[j];
        a[j] = num;

    }

    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int insertData = a[i];
            int j = i - 1;
            while (j >= 0 && insertData < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = insertData;
        }
    }
}