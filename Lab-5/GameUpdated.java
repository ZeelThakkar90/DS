
import java.util.Scanner;

public class GameUpdated {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Size of Array : ");
        int n = scanner.nextInt();

        String[] str = new String[n];
        for (int i = 0; i < str.length; i++) {
            System.out.println("Enter Word : ");
            str[i] = scanner.next();
        }

        while (true) {
            boolean isFound = true;
            int rand = (int) (Math.random() * (n));
            System.out.println(rand);

            System.out.println("Enter Anagram Word: ");
            String anagram = scanner.next().toLowerCase();

            scanner.close();

            str[rand] = str[rand].toLowerCase();

            int[] count1 = new int[26];
            for (int i = 0; i < str[rand].length(); i++) {
                count1[str[rand].charAt(i) - 97]++;
            }

            int[] count2 = new int[26];
            for (int i = 0; i < anagram.length(); i++) {
                count2[anagram.charAt(i) - 97]++;
            }

            for (int i = 0; i < 26; i++) {
                if (count1[i] != count2[i]) {
                    isFound = false;
                    break;
                }
            }
            if (isFound) {
                System.out.println("Congretulation! Hurrah! You won the Game");
                return;
            } else {
                System.out.println("Oops! Try Again!");
            }
        }

    }
}