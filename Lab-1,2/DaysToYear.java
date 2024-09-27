import java.util.Scanner;

public class DaysToYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Seconds : ");
        sc.close();
        int days = sc.nextInt();
        int years = days / 365;
        days = days % 365;
        int week = days / 7;
        days = days % 7;
        System.out.println("Years : "+years);
        System.out.println("Week : "+week);
        System.out.println("Days : "+days);
    }
}

