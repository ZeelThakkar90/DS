
import java.util.Scanner;

class Student_Detail {
    int enrollment_No;
    String name;
    int sem;
    double cpi;

    public Student_Detail(int enrollment_No, String name, int sem, double cpi) {
        this.enrollment_No = enrollment_No;
        this.name = name;
        this.sem = sem;
        this.cpi = cpi;
    }
    
}

public class Student {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Number of Student You want to create: ");
        int n = sc.nextInt();
        Student_Detail[] stu = new Student_Detail[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Stdent "+(i+1)+"th Detail : ");
            System.out.println("Enter Enrollment No: ");
            int enrollment_No = sc.nextInt();
            System.out.println("Enter Name: ");
            String name = sc.next();
            System.out.println("Enter Semester: ");
            int sem = sc.nextInt();
            System.out.println("Enter CPI: ");
            double cpi = sc.nextDouble();
            stu[i] = new Student_Detail(enrollment_No, name, sem, cpi);
        }
        System.out.println("Enrollment_No\tName\tSemester\tCPI");
        for (int i = 0; i < n; i++) {
            System.out.println(stu[i].enrollment_No+"\t"+stu[i].name+"\t"+stu[i].sem+"\t"+stu[i].cpi);
        }
        sc.close();
    }
}