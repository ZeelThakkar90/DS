public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {1,9,3,4,5,1,21};
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void insertionSort(int[] arr){
        int i = 1;
        int n = arr.length;
        while (i < n) {
            int key = arr[i];
            int j = i-1;
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
            i++;
        }
    }
}
