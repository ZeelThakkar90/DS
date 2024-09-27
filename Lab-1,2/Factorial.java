import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number : ");
        int n = sc.nextInt();
        sc.close();
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i; 
        }
        System.out.println("Factorial of "+n+" is = "+ans);
        System.out.println("Factorial of "+n+" is = "+fact(n));
    }
    public static int fact(int n){
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fact(n-1);
    }
}
