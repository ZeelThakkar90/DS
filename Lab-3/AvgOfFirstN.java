import java.util.Scanner;

public class AvgOfFirstN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number :");
        int n = sc.nextInt();
        int sum = (int)n * (n+1) / 2;
        System.out.println("Sum = "+sum);
        double avg;
        // for (int i = 1; i <= n; i++) {
        //     sum += i;
        // }
        sc.close();
        avg = sum/n;
        System.out.println("Avg is : "+avg);
    }
}
