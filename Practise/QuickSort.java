
public class QuickSort {
    public static void main(String[] args){
        int[ ] data = {77,44,99,66,33,55,88,22};
        print(data);
        quickSort(data, 0, data.length-1);
        print(data);
    }

    public static void quickSort(int[] data, int low, int high){
        int j = partition(data, low, high);
        
        if(low < j){
            quickSort(data, low, j);
        }
        if(high > j +1){
            quickSort(data, j+1, high);
        }
    }

    public static int partition(int[] data, int low, int high){
        int pivot = low;
        int i = low, j = high;
        while (i< j) {
            while (data[i] > pivot) {
                i++;
            }
    
            while (data[j] < pivot) {
                j--;
            }
        }
        swap(data, data[i], data[j]);

        return pivot;
    }

    public static void swap(int[] a,int i , int j){
        if(i == j){
            return;
        }
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    public static void print(int[] a){
        System.out.print("[");
        for (int i = 0; i <= a.length - 1; i++) {
            if(i == a.length -1){
                System.out.print(a[i]);
            }else{
                System.out.print(a[i]+",");
            }
        }
        System.out.println("]");
    }
}
