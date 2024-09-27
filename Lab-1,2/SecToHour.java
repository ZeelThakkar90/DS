import java.util.Scanner;

public class SecToHour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Seconds : ");
        sc.close();
        int sec = sc.nextInt();
        int hour = sec / 3600;
        sec = sec % 3600;
        int min = sec / 60;
        sec = sec % 60;
        System.out.println("Hour : "+hour);
        System.out.println("Min : "+min);
        System.out.println("Seconds : "+sec);
    }
}
