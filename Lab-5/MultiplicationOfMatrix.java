import java.util.Scanner;

public class MultiplicationOfMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Rows of Matrix - 1 : ");
        int n1 = sc.nextInt();
        System.out.println("Enter Column of Matrix - 1 : ");
        int m1 = sc.nextInt();

        int[][] mat1 = new int[n1][m1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                System.out.println("Enter Element of Matrices : ");
                mat1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter Rows of Matrix - 2 : ");
        int n2 = sc.nextInt();
        System.out.println("Enter Column of Matrix - 2 : ");
        int m2 = sc.nextInt();

        int[][] mat2 = new int[n2][m2];
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++) {
                System.out.println("Enter Element of Matrices : ");
                mat2[i][j] = sc.nextInt();
            }
        }
        
        sc.close();

        if (m1 != n2) {
            System.out.println("Multiplication of Matrix does not Possible");
            return;
        }

        int[][] result = new int[n1][m2];

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                for (int k = 0; k < n2; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }

        System.out.println("Multiplication : ");
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}
