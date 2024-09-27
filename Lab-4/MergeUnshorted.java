import java.util.Scanner;

public class MergeUnshorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of First Array : ");
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        System.out.println("Enter Element in First Array : ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.println("Enter Element in " + (i + 1) + "th Element : ");
            arr1[i] = sc.nextInt();
        }
        System.out.println("Enter Size of Secound Array : ");
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        System.out.println("Enter Element in Secound Array : ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("Enter Element in " + (i + 1) + "th Element : ");
            arr2[i] = sc.nextInt();
        }
        System.out.println("-----------------------------------");
        int[] result = new int[n + m];
        int i = 0;
        // for (int j = 0; j < arr1.length; j++) {
        //     result[i] = arr1[j];
        //     i++;
        // }
        // for (int j = 0; j < arr2.length; j++) {
        //     result[i] = arr2[j];
        //     i++;
        // }
        for (int j = 0; j < result.length; j++) {
            if (j < arr1.length) {
                result[i] = arr1[j];
            }
            else{
                result[i] = arr2[j-arr1.length];
            }
            i++;
        }
        System.out.println("Array After Merging Given Array : ");
        System.out.println("-----------------------------------");
        for (int j = 0; j < result.length; j++) {
            System.out.println(result[j]);
        }
        sc.close();
    }
}
