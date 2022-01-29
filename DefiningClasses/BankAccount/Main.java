package BankAccount;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Integer, BankAccount> listOfBanks = new HashMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];

            if (name.equals("Create")) {
                BankAccount newBankAcc = new BankAccount();
                System.out.printf("Account ID%d created%n" , newBankAcc.id);
                listOfBanks.put(newBankAcc.id, newBankAcc);
            } else if (name.equals("Deposit")) {
                if (listOfBanks.containsKey(Integer.parseInt(tokens[1]))) {
                    BankAccount bankAccount = listOfBanks.get(Integer.parseInt(tokens[1]));
                    bankAccount.deposit(Double.parseDouble(tokens[2]));
                    System.out.printf("Deposited %d to ID%s%n" ,Integer.parseInt(tokens[2]) , bankAccount.id);
                }else {
                    System.out.println("Account does not exist");
                }

            } else if (name.equals("SetInterest")) {
                BankAccount.setInterestRate(Double.parseDouble(tokens[1]));
            } else if (name.equals("GetInterest")) {
                if (listOfBanks.containsKey(Integer.parseInt(tokens[1]))) {
                    double interestRate = listOfBanks.get(Integer.parseInt(tokens[1])).getInterestRate(Integer.parseInt(tokens[2]));
                    System.out.printf("%.2f%n" ,interestRate);
                }else {
                    System.out.println("Account does not exist");
                }
            }

            input = scanner.nextLine();
        }
    }
}
