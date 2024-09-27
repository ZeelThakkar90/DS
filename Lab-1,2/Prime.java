import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number : ");
        int n = sc.nextInt();
        sc.close();
        if (n == 0 || n == 1) {
            System.out.println("Non - Prime");
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                System.out.println("Non - Prime");
                return;
            }
        }
        System.out.println("Prime");
    }
}
