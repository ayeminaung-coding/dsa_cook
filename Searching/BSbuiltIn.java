package Searching;

import java.util.Arrays;

public class BSbuiltIn {
    public static void main(String[] args) {
        int[] data = { 11, 22, 33, 44, 55 };
        int key = 44;
        int index = Arrays.binarySearch(data, key);
        if (index >= 0) {
            System.out.println("Found " + key + " at position " + index);
        } else {
            System.out.println(key + " is not found");
        }
    }
}
