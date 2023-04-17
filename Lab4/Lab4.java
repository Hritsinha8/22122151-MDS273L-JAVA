import java.util.*;

public class Lab4 {

    static int accountnumber;
    static String accountholdername;
    static double accountbalance;
    static ArrayList<String> transactions = new ArrayList<String>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        
       
        int options;
        
        do {
            
            System.out.println("-------------------------------");
            System.out.println("Welcome to SBI Bank");
            System.out.println("1. Create new customer account");
            System.out.println("2. To deposit Money");
            System.out.println("3. To withdraw money");
            System.out.println("4. To print the transactions");
            System.out.println("5. To print account summary");
            System.out.println("-------------------------------");
            System.out.println("Enter the option you want: ");
            System.out.println("-------------------------------");
            options = sc.nextInt();
            
            switch (options) {
                case 1:
                    createaccount();
                    break;
                case 2:
                    depositmoney();
                    break;
                case 3:
                    withdrawmoney();
                    break;
                case 4:
                    transactions();
                    break;
                case 5:
                    accountsummary();
                    break;
                case 6:
                    System.out.println("Thank you so much");
                    break;
                default:
                    System.out.println("Invalid....Please retry");
    
            }
        } while (options!=6);
        
        sc.close();

    }

    public static void createaccount(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your full name: ");
        accountholdername = sc.nextLine();
        System.out.println("Enter your account number: ");
        accountnumber = sc.nextInt();
        System.out.println("Enter your account balance: ");
        accountbalance = sc.nextDouble();
        System.out.println("Your account is created");
        transactions.add("Account created with initial balance of " + accountbalance);
    }

    public static void depositmoney(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount that you want to deposit");
        double depositedamount = sc.nextDouble();
        accountbalance += depositedamount;
        System.out.println("The deposited amount is " + depositedamount);
        transactions.add("Deposited " + depositedamount + ". New balance is " + accountbalance);
    }

    public static void withdrawmoney(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount you want to withdraw");
        double withdrawamount = sc.nextDouble();
        if (withdrawamount > accountbalance) {
            System.out.println("Insufficient balance");
            return;
        }
        accountbalance -= withdrawamount;
        System.out.println("The withdraw amount is " + withdrawamount);
        transactions.add("Withdrawn " + withdrawamount + ". New balance is " + accountbalance);
    }

    public static void transactions(){
        System.out.println("Transaction history:");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public static void accountsummary(){
        System.out.println("The account holder name is " + accountholdername);
        System.out.println("The account number " + accountnumber);
        System.out.println("The account balance is " + accountbalance);
    }


}

 