//Implement BankAccount class with deposit, withdraw and balance inquiry

import java.util.Scanner;

class BankAccount {
    private final String name;
    private final int accNo;
    private double balance;
    private static int nextAccNo = 1;

    public BankAccount(String name) {
        this.name = name;
        this.accNo = nextAccNo++;
        this.balance = 0;
    }

    public int getAccNo() {
        return accNo;
    }

    public void deposit(double amt) {
        if (amt <= 0) {
            System.out.println("Invalid amount! Deposit must be positive.");
        } else {
            balance += amt;
            System.out.println(amt + " deposited successfully.");
        }
    }

    public void withdraw(double amt) {
        if (amt <= 0) {
            System.out.println("Invalid amount! Withdraw must be positive.");
        } else if (amt > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amt;
            System.out.println(amt + " withdrawn successfully.");
        }
    }

    public void showDetails() {
        System.out.println("Account No: " + accNo + " | Name: " + name + " | Balance: " + balance);
    }
}

public class Program4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount[] accounts = new BankAccount[10];
        int count = 0;

        while (true) {

            System.out.println("\n=================================");
            System.out.println("1.Create  2.Deposit  3.Withdraw");
            System.out.println("4.Show    5.Exit");
            System.out.println("=================================");
            System.out.print("Choose option: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid choice! Enter number only.");
                sc.next();
                continue;
            }

            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    if (count >= 10) {
                        System.out.println("Bank full!");
                        break;
                    }

                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    accounts[count] = new BankAccount(name);
                    System.out.println("Account created successfully!");
                    accounts[count].showDetails();
                    count++;
                    break;

                case 2:
                    System.out.print("Enter account number: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid account number!");
                        sc.next();
                        break;
                    }

                    int accNo = sc.nextInt();
                    BankAccount acc = find(accounts, count, accNo);

                    if (acc == null) {
                        System.out.println("Account not found!");
                        break;
                    }

                    System.out.print("Deposit amount: ");

                    if (!sc.hasNextDouble()) {
                        System.out.println("Invalid amount!");
                        sc.next();
                        break;
                    }

                    double dep = sc.nextDouble();
                    acc.deposit(dep);
                    break;

                case 3:
                    System.out.print("Enter account number: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid account number!");
                        sc.next();
                        break;
                    }

                    accNo = sc.nextInt();
                    acc = find(accounts, count, accNo);

                    if (acc == null) {
                        System.out.println("Account not found!");
                        break;
                    }

                    System.out.print("Withdraw amount: ");

                    if (!sc.hasNextDouble()) {
                        System.out.println("Invalid amount!");
                        sc.next();
                        break;
                    }

                    double w = sc.nextDouble();
                    acc.withdraw(w);
                    break;

                case 4:
                    System.out.print("Enter account number: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid account number!");
                        sc.next();
                        break;
                    }

                    accNo = sc.nextInt();
                    acc = find(accounts, count, accNo);

                    if (acc == null) {
                        System.out.println("Account not found!");
                    } else {
                        acc.showDetails();
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using Bank System.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static BankAccount find(BankAccount[] accounts, int count, int accNo) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccNo() == accNo) {
                return accounts[i];
            }
        }
        return null;
    }
}