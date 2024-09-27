import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter base Number :");
        int base = sc.nextInt();
        System.out.println("Enter power Number :");
        int power = sc.nextInt();
        sc.close();
        int ans = 1;
        for (int i = 1; i <= power; i++) {
            ans *= base; 
        }
        System.out.println("Power of Given Number is "+ans);
    }
}
