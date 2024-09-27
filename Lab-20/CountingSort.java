import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {4,1,0,2,4,1,6};

        countSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void countSort(int[] arr){
        int max = max(arr);
        int[] freq = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;
        }

        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i-1];
        }

        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            ans[freq[arr[i]]-1] = arr[i];
            freq[arr[i]]--;
        }

        for (int i = 0; i < ans.length; i++) {
            arr[i] = ans[i];
        }
    }

    public static int max(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
