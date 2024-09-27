import java.util.Scanner;

public class SumOfMtoN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter m :");
        int m = sc.nextInt();
        System.out.println("Enter n :");
        int n = sc.nextInt();
        int sum = 0;
        for (int i = m; i <= n; i++) {
            sum += i;
        }
        sc.close();
        System.out.println(sum);

    }
}
