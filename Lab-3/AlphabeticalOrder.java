import java.util.Scanner;

public class AlphabeticalOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of an Array :");
        int n = sc.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < str.length; i++) {
            System.out.println("Enter Name :");
            str[i] = sc.next();
        }
        sc.close();
        for (int i = 0; i < str.length-1; i++) {
            for (int j = i+1; j < str.length; j++) {
                if (str[i].compareTo(str[j])>0) {
                    String temp = str[i];  
                        str[i] = str[j];  
                        str[j] = temp;  
                }
            }
        }
        System.out.println("Sorted Array is :");
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}
