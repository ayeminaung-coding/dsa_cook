package Sorting;

public class BubbleSort {
    public static void main(String[] args){
        int[ ] data = {77,44,99,66,33,55,88,22};
        print(data);
        bubbleSort(data);
        print(data);

    }

    public static void bubbleSort(int[] data){
        for(int i = 0; i < data.length -1 ; i++ ){
            for(int j = 0 ; j < data.length -1 ; j++){
                if(data[j] > data[j+1]){
                    swap(data, j, j+1);
                }
            }
        }
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
