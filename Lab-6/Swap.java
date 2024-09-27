
import java.util.Scanner;

public class Swap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First Number: ");
        int a = sc.nextInt();
        System.out.println("Enter Second Number: ");
        int b = sc.nextInt();
        sc.close();
        swap(a, b);
        System.out.println("IN MAIN a : "+a);
        System.out.println("IN MAIN b : "+b);
    }
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("IN Method a : "+a);
        System.out.println("IN Method b : "+b);
    }
}

