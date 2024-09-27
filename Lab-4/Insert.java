import java.util.Scanner;

public class Insert {
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
        System.out.println("Enter the index at you want to insert element :");
        int index = sc.nextInt();
        System.out.println("Enter Value of Element :");
        int value = sc.nextInt();
        sc.close();
        int[] result = new int[n+1];
        for (int i = 0; i < result.length; i++) {
            if (i < index) {
                result[i] = arr[i];
            }
            else if (i == index) {
                result[index] =  value;
            }
            else {
                result[i] = arr[i-1];
            }
        }
        System.out.println("Array after inserting value :");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
