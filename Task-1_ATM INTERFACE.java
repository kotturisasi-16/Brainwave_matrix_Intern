package ATM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {
    private int balance;
    private int pin;
    private final List<String> transactionHistory;
    private final Scanner sc;

    public ATM(int initialBalance, int initialPin) {
        this.balance = initialBalance;
        this.pin = initialPin;
        this.transactionHistory = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        ATM atm = new ATM(20000, 1601);
        if (atm.authenticate()) {
            atm.startATM();
        } else {
            System.out.println("Authentication failed. Exiting...");
        }
    }

    private boolean authenticate() {
        int attempts = 3;
        while (attempts > 0) {
            System.out.print("Enter your 4-digit PIN: ");
            if (sc.hasNextInt()) {
                int enteredPin = sc.nextInt();
                if (enteredPin == pin) {
                    return true;
                } else {
                    attempts--;
                    System.out.println("Incorrect PIN. Attempts remaining: " + attempts);
                }
            } else {
                System.out.println("Invalid input. Please enter a 4-digit number.");
                sc.nextLine();
                attempts--;
            }
        }
        return false;
    }

    private void startATM() {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = getChoice();

            switch (choice) {
                case 1 -> checkBalance();
                case 2 -> depositMoney();
                case 3 -> withdrawMoney();
                case 4 -> changePin();
                case 5 -> viewTransactionHistory();
                case 6 -> {
                    System.out.println("Exiting ATM...");
                    exit = true;
                }
                default -> System.out.println("Invalid choice. Please select a valid operation.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nAutomated Teller Machine");
        System.out.println("Choose the operation you want to perform:");
        System.out.println("1. Balance Inquiry");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Change PIN");
        System.out.println("5. View Transaction History");
        System.out.println("6. Exit");
    }

    private int getChoice() {
        int choice = -1;
        while (choice < 1 || choice > 6) {
            System.out.print("Enter your choice (1-6): ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                if (choice < 1 || choice > 6) {
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
            }
        }
        return choice;
    }

    private void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
        transactionHistory.add("Checked Balance: $" + balance);
    }

    private void depositMoney() {
        System.out.print("Enter amount to deposit: ");
        if (sc.hasNextInt()) {
            int amount = sc.nextInt();
            if (amount <= 0) {
                System.out.println("Deposit amount must be positive.");
            } else {
                balance += amount;
                transactionHistory.add("Deposited: $" + amount);
                System.out.println("Deposit successful.");
                System.out.println("Current Balance: $" + balance);
            }
        } else {
            System.out.println("Invalid input. Please enter a valid number.");
            sc.nextLine();
        }
    }

    private void withdrawMoney() {
        System.out.print("Enter amount to withdraw: ");
        if (sc.hasNextInt()) {
            int amount = sc.nextInt();
            if (amount <= 0) {
                System.out.println("Withdrawal amount must be positive.");
            } else if (amount > balance) {
                System.out.println("Insufficient balance.");
            } else {
                balance -= amount;
                transactionHistory.add("Withdrawn: $" + amount);
                System.out.println("Withdrawal successful.");
                System.out.println("Remaining Balance: $" + balance);
            }
        } else {
            System.out.println("Invalid input. Please enter a valid number.");
            sc.nextLine();
        }
    }

    private void changePin() {
        System.out.print("Enter your current PIN: ");
        if (sc.hasNextInt()) {
            int currentPin = sc.nextInt();
            if (currentPin == pin) {
                System.out.print("Enter your new 4-digit PIN: ");
                if (sc.hasNextInt()) {
                    int newPin = sc.nextInt();
                    if (newPin >= 1000 && newPin <= 9999) {
                        pin = newPin;
                        System.out.println("PIN changed successfully.");
                        transactionHistory.add("PIN changed successfully.");
                    } else {
                        System.out.println("Invalid PIN. It must be a 4-digit number.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a 4-digit number.");
                    sc.nextLine();
                }
            } else {
                System.out.println("Incorrect PIN. Unable to change.");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid number.");
            sc.nextLine();
        }
    }

    private void viewTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            System.out.println("Transaction History:");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }
}






























//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//public class ATM {
//  private static int balance = 40000;
//  private static int pin = 1304;
//  private static List<String> transactionHistory = new ArrayList<>();
//  private static Scanner sc = new Scanner(System.in);
//
//  public static void main(String[] args) {
//      if (authenticate()) {
//          startATM();
//      } else {
//          System.out.println("Authentication failed. Exiting...");
//      }
//  }
//  private static boolean authenticate() {
//      int attempts = 3;
//      while (attempts > 0) {
//          System.out.print("Enter your 4-digit PIN: ");
//          if (sc.hasNextInt()) {
//              int enteredPin = sc.nextInt();
//              if (enteredPin == pin) {
//                  return true;
//              } else {
//                  attempts--;
//                  System.out.println("Incorrect PIN. Attempts remaining: " + attempts);
//              }
//          } else {
//              System.out.println("Invalid input. Please enter a 4-digit number.");
//              sc.nextLine();
//              attempts--;
//          }
//      }
//      return false;
//  }
//  private static void startATM() {
//      while (true) {
//          System.out.println("\nAutomated Teller Machine");
//          System.out.println("Choose the operation you want to perform:");
//          System.out.println("1. Withdraw");
//          System.out.println("2. Deposit");
//          System.out.println("3. Check Balance");
//          System.out.println("4. Change PIN");
//          System.out.println("5. View Transaction History");
//          System.out.println("6. Exit");
//
//          int choice = getChoice();
//
//          switch (choice) {
//              case 1 -> withdrawMoney();
//              case 2 -> depositMoney();
//              case 3 -> checkBalance();
//              case 4 -> changePin();
//              case 5 -> viewTransactionHistory();
//              case 6 -> {
//                  System.out.println("Exiting ATM...");
//                  System.exit(0);
//              }
//              default -> System.out.println("Invalid choice. Please select a valid operation.");
//          }
//      }
//  }
//
//  private static int getChoice() {
//      int choice = -1;
//      while (choice < 1 || choice > 6) {
//          System.out.print("Enter your choice (1-6): ");
//          if (sc.hasNextInt()) {
//              choice = sc.nextInt();
//              if (choice < 1 || choice > 6) {
//                  System.out.println("Invalid choice. Please enter a number between 1 and 6.");
//              }
//          } else {
//              System.out.println("Invalid input. Please enter a number.");
//              sc.nextLine(); 
//          }
//      }
//      return choice;
//  }
//
//  private static void withdrawMoney() {
//      System.out.print("Enter amount to withdraw: ");
//      if (sc.hasNextInt()) {
//          int withdraw = sc.nextInt();
//          if (withdraw <= 0) {
//              System.out.println("Withdrawal amount must be positive.");
//          } else if (withdraw > balance) {
//              System.out.println("Insufficient balance.");
//          } else {
//              balance -= withdraw;
//              System.out.println("Withdrawal successful.");
//              transactionHistory.add("Withdrawn: $" + withdraw);
//              System.out.println("Remaining Balance: $" + balance);
//          }
//      } else {
//          System.out.println("Invalid input. Please enter a valid number.");
//          sc.nextLine(); 
//      }
//  }
//  private static void depositMoney() {
//      System.out.print("Enter amount to deposit: ");
//      if (sc.hasNextInt()) {
//          int deposit = sc.nextInt();
//          if (deposit <= 0) {
//              System.out.println("Deposit amount must be positive.");
//          } else {
//              balance += deposit;
//              System.out.println("Deposit successful.");
//              transactionHistory.add("Deposited: $" + deposit);
//              System.out.println("Current Balance: $" + balance);
//          }
//      } else {
//          System.out.println("Invalid input. Please enter a valid number.");
//          sc.nextLine();
//      }
//  }
//  private static void checkBalance() {
//      System.out.println("Your current balance is: $" + balance);
//      transactionHistory.add("Checked Balance: $" + balance);
//  }
//  private static void changePin() {
//      System.out.print("Enter your current PIN: ");
//      if (sc.hasNextInt()) {
//          int currentPin = sc.nextInt();
//          if (currentPin == pin) {
//              System.out.print("Enter your new 4-digit PIN: ");
//              if (sc.hasNextInt()) {
//                  int newPin = sc.nextInt();
//                  if (newPin >= 1000 && newPin <= 9999) {
//                      pin = newPin;
//                      System.out.println("PIN changed successfully.");
//                      transactionHistory.add("PIN changed successfully.");
//                  } else {
//                      System.out.println("Invalid PIN. It must be a 4-digit number.");
//                  }
//              } else {
//                  System.out.println("Invalid input. Please enter a 4-digit number.");
//                  sc.nextLine();
//              }
//          } else {
//              System.out.println("Incorrect PIN. Unable to change.");
//          }
//      } else {
//          System.out.println("Invalid input. Please enter a valid number.");
//          sc.nextLine();
//      }
//  }
//  private static void viewTransactionHistory() {
//      if (transactionHistory.isEmpty()) {
//          System.out.println("No transactions available.");
//      } else {
//          System.out.println("Transaction History:");
//          for (String transaction : transactionHistory) {
//              System.out.println(transaction);
//          }
//      }
//  }
//}
