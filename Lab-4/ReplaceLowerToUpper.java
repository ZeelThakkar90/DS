import java.util.Scanner;

public class ReplaceLowerToUpper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String : ");
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                str = str.replace(str.charAt(i), (char)(str.charAt(i)-32));
            }
        }
        sc.close();
        System.out.println(str);
    }
}
