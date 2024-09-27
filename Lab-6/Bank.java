
import java.util.Scanner;

class BankAccount {

    int accountNo;
    String name;
    String accountHolder;

    private double accountBalance = 0;

    public BankAccount(int accountNo, String name, String accountHolder, double accountBalance) {
        this.accountNo = accountNo;
        this.name = name;
        this.accountHolder = accountHolder;
        this.accountBalance = accountBalance;
    }

    public void showBalance() {
        System.out.println(accountBalance);
    }

    public void depositBalance(double amount) {
        if (amount < 0) {
            System.out.println("Please enter a Valid amount");
        } else {
            accountBalance = accountBalance + amount;
            System.out.println("Account Balance of " + accountNo + " is " + accountBalance);
        }
    }

    public void withdrawBalance(double amount) {
        if (amount < 0) {
            System.out.println("Please enter a Valid amount");
        } else if (amount > accountBalance) {
            System.out.println("Insufficient Balance");
        } else {
            accountBalance = accountBalance - amount;
            System.out.println("Remining Account Balance of " + accountNo + " is " + accountBalance);
        }
    }

    public void showAccountDetails() {
        System.out.println("Account No.\tAccount Holder's Name\tAccount Owner's Name\tAccount Balance");
        System.out.println(this.accountNo + "\t" + this.accountHolder + "\t" + this.name + "\t" + this.accountBalance);

    }
}

public class Bank {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of Account You want to create: ");
        int n = sc.nextInt();

        BankAccount[] ba = new BankAccount[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Account No. ");
            int actno = sc.nextInt();
            System.out.println("Enter Account Holder's Name: ");
            String hname = sc.next();
            System.out.println("Enter Account Owner's Name: ");
            String oname = sc.next();
            System.out.println("Enter Account Balance :");
            double bal = sc.nextDouble();
            ba[i] = new BankAccount(actno, oname, hname, bal);
        }

        int f = 0;

        while (f != 5) {
            System.out.println("Enter Function You want to Select : ");
            System.out.println("1. Show Account Details : ");
            System.out.println("2. Show Account Balance : ");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Exit");
            f = sc.nextInt();
            if (f == 1) {
                System.out.println("Enter Account No.");
                int no = sc.nextInt();

                boolean isFound = false;

                for (int i = 0; i < ba.length; i++) {
                    if (ba[i].accountNo == no) {
                        isFound = true;
                        ba[i].showAccountDetails();
                    }
                }
                if (!isFound) {
                    System.out.println("Given Account is Not Found in Records...");
                }
            } else if (f == 2) {
                System.out.println("Enter Account No.");
                int no = sc.nextInt();
                boolean isFound = false;
                for (int i = 0; i < ba.length; i++) {
                    if (ba[i].accountNo == no) {
                        isFound = true;
                        ba[i].showBalance();
                    }
                }
                if (!isFound) {
                    System.out.println("Given Account is Not Found in Records...");
                }
            } else if (f == 3) {
                System.out.println("Enter Account No.");
                int no = sc.nextInt();

                System.out.println("Enter Amount You want to Deposit : ");
                double amount = sc.nextDouble();
                boolean isFound = false;

                for (int i = 0; i < ba.length; i++) {
                    if (ba[i].accountNo == no) {
                        isFound = true;
                        ba[i].depositBalance(amount);
                    }
                }

                if (!isFound) {
                    System.out.println("Given Account is Not Found in Records...");
                }
                
            } else if (f == 4) {
                System.out.println("Enter Account No.");
                int no = sc.nextInt();

                System.out.println("Enter Amount You want to Withdraw : ");
                double amount = sc.nextDouble();
                boolean isFound = false;
                for (int i = 0; i < ba.length; i++) {
                    if (ba[i].accountNo == no) {
                        isFound = true;
                        ba[i].withdrawBalance(amount);
                    }
                }
                if (!isFound) {
                    System.out.println("Given Account is Not Found in Records...");
                }
            } else if (f == 5) {
                System.out.println("Exiting From Function....");
            } else {
                System.out.println("Invalid Function Call ....");
            }
        }
        sc.close();
    }
}