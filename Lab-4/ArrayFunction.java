import java.util.Scanner;

public class ArrayFunction {
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
        System.out.println("Max Element in Array is : "+max(arr));
        System.out.println("Minimum Element in Array is : "+min(arr));
        System.out.println("Sum of Element in Array is : "+sum(arr));
        System.out.println("Avg of Element in Array is : "+avg(arr));
        sc.close();
    }
    public static int sum(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    public static double avg(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        } 
        return (sum/arr.length);       
    }
    public static int min(int[] arr){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)  {
                min = arr[i];
            }
        }
        return min;
    }
    public static int max(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)  {
                max = arr[i];
            }
        }
        return max;
    }
}
