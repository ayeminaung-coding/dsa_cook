public class MergeSort {
    public static void main(String[] args){
        int[ ] data = {77,44,99,66,33,55,88,22};
        print(data);
        mergeSort(data, 0, data.length-1);
        print(data);

    }

    public static void mergeSort(int[] data, int low , int high){
        if(low< high){
            int mid = (low + high)/2;
        
            mergeSort(data, low, mid);
            mergeSort(data, mid +1, high);

            merge(data,low,mid,high);
        }
    }

    public static void merge(int[] a, int low,int mid,int high){
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] firstArr = new int[n1];
        int[] secArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            firstArr[i] = a[low + i];
        }

        for (int i = 0; i < n2; i++) {
            secArr[i] = a[mid + i+ 1];
        }

        int i = 0, j = 0;
        int k = low;
        while (i < n1 && j < n2) {
            if (firstArr[i] <= secArr[j]) {
                a[k++] = firstArr[i++];
            } else {
                a[k++] = secArr[j++];
            }
        }
    
        while (i < n1) {
            a[k++] = firstArr[i++];
        }
    
        while (j < n2) {
            a[k++] = secArr[j++];
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
