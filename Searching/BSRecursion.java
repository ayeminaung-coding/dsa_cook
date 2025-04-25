package Searching;

public class BSRecursion {
    public static void main(String[] args) {
        int[] data = {3, 8, 12, 18, 25, 31, 40, 47, 59, 63, 72}; // must be sorted
        int value = 8;
        // show position of array index and value
        System.out.println(search(data, value,0, data.length -1));
    }

    public static int search(int[] data, int value, int low, int high){
        if(low > high){
            return 1;
        }

        int mid = (low+high)/2;
        if(value == data[mid]){
            return mid;
        }else if(value < data[mid]){
            return search(data, value,0, mid - 1);
        }else{
            return search(data, value, mid+ 1, high);
        }

    }
}
