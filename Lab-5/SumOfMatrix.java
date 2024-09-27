import java.util.Scanner;

public class SumOfMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Rows of Matrix : ");
        int n = sc.nextInt();
        System.out.println("Enter Columns of Matrix : ");
        int m = sc.nextInt();

        int[][] a = new int[n][m];
        System.out.println("Enter Value of First Matrix :");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.println("Enter Element in a["+(i+1)+"]["+(j+1)+"] : ");
                a[i][j] = sc.nextInt();
            }
        }
        
        int[][] b = new int[n][m];
        System.out.println("Enter Value of Secound Matrix :");
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.println("Enter Element in b["+(i+1)+"]["+(j+1)+"] : ");
                b[i][j] = sc.nextInt();
            }
        }
        int[][] c = new int[n][m];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        System.out.println("Sum of Given two Matrix is :");
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}

