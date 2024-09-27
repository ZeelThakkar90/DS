import java.util.Scanner;

public class DeleteSorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of an Array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter Element in Array : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter Element : ");
            arr[i] = sc.nextInt();
        }
        System.out.println("Given Array is :");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("Enter the value you want to Deleted :");
        int value = sc.nextInt();

        int[] result = new int[arr.length-1];
        int k = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == value)
                continue;
            else{
                result[k] = arr[i];
                k++;
            }
        }
        System.out.println("Array after Deleting value :");
        for (int j = 0; j < result.length; j++) {
            System.out.println(result[j]);
        }
        sc.close();
    }
}
