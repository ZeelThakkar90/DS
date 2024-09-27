import java.util.Scanner;

public class InsertSorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of an Array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter Element in Array : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter Element");
            arr[i] = sc.nextInt();
        }
        System.out.println("Given Array is :");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("Enter Value of Element :");
        int value = sc.nextInt();
        int[] result = new int[n+1];
        int i = 0;

        while (i < arr.length && arr[i] <= value) {
            result[i] = arr[i];
            i++;
        }

        result[i] = value;

        while (i < arr.length) {
            result[i+1] = arr[i];
            i++;
        }

        System.out.println("Array after inserting value :");
        for (int j = 0; j < result.length; j++) {
            System.out.println(result[j]);
        }
        sc.close();
    }
}
