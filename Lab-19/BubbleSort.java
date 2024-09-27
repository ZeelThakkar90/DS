public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,6,2,4,1,6};

        bubbleSort(arr);

        System.out.println("After Bubble Sort Sort : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int swapCount = 0;
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    swapCount++;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                
            }
            if (swapCount == 0) {
                System.out.println("Array is Already Sorted!!");
                return;
            }
        }
    }
}
