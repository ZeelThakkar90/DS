import java.util.Scanner;

public class IndexOfMinandMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of an Array :");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter Element : ");
            arr[i] = sc.nextInt();
        }
        sc.close();
        int min = arr[0];
        int max = arr[0];
        int index_min = 0;
        int index_max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                index_min = i;
                min = arr[i];
            }
            if (arr[i] > max) {
                index_max = i;
                max = arr[i];
            }
        }
        System.out.println("Index of Minimum Number : "+index_min);
        System.out.println("Index of Maximum Number : "+index_max);
    }
}
