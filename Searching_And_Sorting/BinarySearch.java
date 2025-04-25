package Searching_And_Sorting;

public class BinarySearch {

    // binary search
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int value = 19;
        // show position of array index and value
        System.out.println(search(data, value));
        
    }

    public static int search(int[] data, int value){
        int low = 0;
        int high = data.length -1 ;
        do{
            int mid = (low + high) / 2;
            if(mid > value){
                low = mid + 1;
            }else if(mid < value){
                low = mid - 1;
            }else{
                return mid;
            }
        }while(low <= high);
        return -1; // not found
    }

}
