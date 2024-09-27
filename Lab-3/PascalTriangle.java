import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of Rows :");
        int n = sc.nextInt();
        sc.close();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(" "+(fact(i)/(fact(i-j)*fact(j))));
            }
            System.out.println();
        }

    }
    public static int fact(int n){
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fact(n-1);
    }
}
