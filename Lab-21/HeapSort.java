import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {5,2,1,-1,4,2,0};
        heapSort(arr); 
        System.out.println("Array after Sorting : ");
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr){
        int n = arr.length;
        buildMaxHeap(arr);
        for (int i = n - 1; i >= 0; i--) {

            //swap 
            int t = arr[0];
            arr[0] = arr[i];
            arr[i] = t;

            heapify(arr, i, 0);
        }
    }

    public static void buildMaxHeap(int[] arr){
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    public static void heapify(int[] arr, int n , int i){
        int maxIndex = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && arr[leftChild] > arr[maxIndex]) {
            maxIndex = leftChild;
        }

        if (rightChild < n && arr[rightChild] > arr[maxIndex]) {
            maxIndex = rightChild;
        }

        if (i != maxIndex) {
            //swap
            int t = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = t;

            heapify(arr, n, maxIndex);
        }
    }

}
