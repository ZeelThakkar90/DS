
import java.util.Scanner;

class Employee_Detail{
    int id;
    String name;
    String designation;
    double salary;

    public Employee_Detail(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }
}

public class Employee{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of Employee You want to create: ");
        int n = sc.nextInt();
        Employee_Detail[] emp = new Employee_Detail[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter ID: ");
            int id = sc.nextInt();
            System.out.println("Enter Name: ");
            String name = sc.next();
            System.out.println("Enter Designation: ");
            String designation = sc.next();
            System.out.println("Enter Salary: ");
            double salary = sc.nextDouble();
            emp[i] = new Employee_Detail(id,name,designation,salary);
        }
        System.out.println("ID\tName\tDesignation\tSalary");
        for (int i = 0; i < n; i++) {
            System.out.println(emp[i].id+"\t"+emp[i].name+"\t"+emp[i].designation+"\t"+emp[i].salary);
        }
        sc.close();
    }
}