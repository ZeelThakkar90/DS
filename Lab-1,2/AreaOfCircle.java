import java.util.Scanner;

public class AreaOfCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Radius of Circle :");
        double rad = sc.nextDouble();
        sc.close();
        System.out.println("Area of Circle is : "+(Math.PI*rad*rad));
    }
}
