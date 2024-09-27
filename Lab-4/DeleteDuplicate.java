import java.util.Scanner;

public class DeleteDuplicate {
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
        int count = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    break;
                }
            }  
        }
        int[] result = new int[arr.length-count];
        result[0] = arr[0]; //First Value OF Array Always Will be Unique
        int j = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i-1]) {
                result[j] = arr[i];
                j++;
            }
        }
        System.out.println("New Array : ");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        sc.close();
    }
}
