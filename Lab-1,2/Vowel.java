import java.util.Scanner;

public class Vowel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Char : ");
        String str = sc.next().toLowerCase();
        sc.close();
        System.out.println("aeiou".contains(str)?"Vowel":"Non Vowel");
    }
}
