import java.util.Scanner;

// Class representing the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public String deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return String.format("Deposited: $%.2f. New Balance: $%.2f", amount, balance);
        } else {
            return "Invalid deposit amount. Please enter a positive value.";
        }
    }

    public String withdraw(double amount) {
        if (amount > balance) {
            return "Insufficient balance. Transaction declined.";
        } else if (amount > 0) {
            balance -= amount;
            return String.format("Withdrew: $%.2f. New Balance: $%.2f", amount, balance);
        } else {
            return "Invalid withdrawal amount. Please enter a positive value.";
        }
    }

    public String checkBalance() {
        return String.format("Your current balance is: $%.2f", balance);
    }
}

// Class representing the ATM interface
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Display the ATM menu in a formatted manner
    public void showMenu() {
        System.out.println("╔═══════════════════════════════╗");
        System.out.println("║           ATM MENU            ║");
        System.out.println("╠═══════════════════════════════╣");
        System.out.println("║ 1. Check Balance               ║");
        System.out.println("║ 2. Deposit Money               ║");
        System.out.println("║ 3. Withdraw Money              ║");
        System.out.println("║ 4. Exit                        ║");
        System.out.println("╚═══════════════════════════════╝");
    }

    // Handle the selected option
    public void handleOption(int option) {
        switch (option) {
            case 1 -> System.out.println("\n" + account.checkBalance());
            case 2 -> {
                System.out.print("Enter the amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                System.out.println(account.deposit(depositAmount));
            }
            case 3 -> {
                System.out.print("Enter the amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                System.out.println(account.withdraw(withdrawAmount));
            }
            case 4 -> System.out.println("Thank you for using the ATM. Goodbye!");
            default -> System.out.println("Invalid option. Please try again.");
        }
    }

    // Run the ATM interface
    public void run() {
        int option;
        do {
            showMenu();
            System.out.print("Select an option (1-4): ");
            option = scanner.nextInt();
            handleOption(option);
            if (option != 4) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine(); // Consume the newline character
                scanner.nextLine(); // Wait for user to press Enter
            }
        } while (option != 4);
    }
}

// Main program to run the ATM interface
public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the initial balance for your account: ");
        double initialBalance = scanner.nextDouble();

        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atmMachine = new ATM(userAccount);

        atmMachine.run();
    }
}
