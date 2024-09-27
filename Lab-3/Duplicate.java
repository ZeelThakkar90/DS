import java.util.Scanner;

public class Duplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of an Array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        boolean isDuplicate = false;
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter Element : ");
            arr[i] = sc.nextInt();
        }
        sc.close();
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }
        }
        System.out.println(isDuplicate);
    }
}
