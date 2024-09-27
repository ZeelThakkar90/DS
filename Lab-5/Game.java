
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Size of Array : " );
        int n = scanner.nextInt();
        
        int rand = (int)(Math.random()*(n));
        System.out.println(rand);
            
        String[] str = new String[n ];
        for (int i = 0; i < str.length; i++) {
            System.out.println("Enter Word : ");
            str[i] = scanner.next();
        }

        System.out.println("Enter Anagram Word: ");
        String anagram = scanner.next().toLowerCase();

        scanner.close();

        str[rand] = str[rand].toLowerCase();

        int[] count1 = new int[26];
        for (int i = 0; i < str[rand].length(); i++) {
            count1[str[rand].charAt(i)-97]++; 
        }

        int[] count2 = new int[26];
        for (int i = 0; i < anagram.length(); i++) {
            count2[anagram.charAt(i)-97]++;
        }

        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                System.out.println("Oops! Try Again!");
                return;
            }
        }
        System.out.println("Congretulation! Hurrah! You won the Game");

    }
}