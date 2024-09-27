import java.util.Scanner;

public class Replace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of an Array :");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter Element in Array :");
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter Number You Want to Replace :");
        int a = sc.nextInt();
        System.out.println("Enter Number which will be Replaced Following Number :");
        int b = sc.nextInt();
        sc.close();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) {
                arr[i] = b;
                System.out.println("Element Found at "+i+"th index");
            }
        }
        System.out.println("Array after Replacing :");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }   
    }
}
