
import java.util.Scanner;

public class Temperature{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Which Function You Want to Use : ");
        System.out.println("1. Celsius to Fahrenhit");
        System.out.println("2. Fahrenhit to Celsius");
        int n = sc.nextInt();

        if (n == 1) {
            System.out.println("Enter Temperature in Celsius : ");
            double cel = sc.nextDouble();
            double fah = (cel * 9 / 5) + 32;
            System.out.println("Conversion of Celsius to Fahrenheit is : "+fah);
        }
        else if(n == 2) {
            System.out.println("Enter Temperature in Fahrenheit : ");
            double fah = sc.nextDouble();
            double cel = (fah - 32) * 5 / 9;
            System.out.println("Conversion of Fahrenheit to Celsius is : "+cel);
        }
        else{
            System.out.println("Invalid Function Call....");
        }
        sc.close();
    }
}