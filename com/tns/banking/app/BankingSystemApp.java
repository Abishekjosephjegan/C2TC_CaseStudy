package com.tns.banking.app;

import com.tns.banking.model.*;
import com.tns.banking.service.*;
import java.util.*;

public class BankingSystemApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankingService service = new BankingServiceImpl();

        int txnId = 1;

        while (true) {

            System.out.println("\n--- BANKING SYSTEM ---");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Account");
            System.out.println("3. Add Beneficiary");
            System.out.println("4. Add Transaction");
            System.out.println("5. Find Customer by ID");
            System.out.println("6. List all Accounts of Customer");
            System.out.println("7. List all Transactions of Account");
            System.out.println("8. List all Beneficiaries of Customer");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    System.out.println("Enter Customer Details");
                    System.out.print("Customer ID: ");
                    int cid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Address: ");
                    String addr = sc.nextLine();
                    System.out.print("Contact No: ");
                    String mob = sc.nextLine();
                    service.addCustomer(new Customer(cid, name, addr, mob));
                    break;

                case 2:
                    System.out.println("Enter Account Details");
                    System.out.print("Account ID: ");
                    int aid = sc.nextInt();
                    System.out.print("Customer ID: ");
                    int cid2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Account Type(Saving/Current): ");
                    String type = sc.nextLine();
                    System.out.print("Balance: ");
                    double bal = sc.nextDouble();
                    service.addAccount(new Account(aid, cid2, type, bal));
                    break;

                case 3:
                    System.out.println("Enter Beneficiary Details");
                    System.out.print("Customer ID: ");
                    int cusid = sc.nextInt();
                    System.out.print("Beneficiary ID: ");
                    int bid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Beneficiary Name: ");
                    String bname = sc.nextLine();
                    System.out.print("Beneficiary Account Number: ");
                    String accno = sc.nextLine();
                    System.out.print("Beneficiary Bank: ");
                    String bank = sc.nextLine();
                    service.addBeneficiary(new Beneficiary(bid, cusid, bname, accno, bank));
                    break;

                case 4:
                    System.out.println("Enter Transaction Details");
                    System.out.print("Account ID: ");
                    int taid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Type (Deposit/Withdraw): ");
                    String ttype = sc.nextLine();
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();
                    Transaction t = new Transaction(txnId++, taid, ttype, amt);
                    service.addTransaction(t);
                    break;

                case 5:
                    System.out.print("Enter Customer ID: ");
                    int id = sc.nextInt();
                    System.out.println(service.findCustomerById(id));
                    break;

                case 6:
                	for (Account acc : service.getAllAccounts()) {
                		System.out.println(acc);
                	}
                    System.out.print("Customer ID: ");
                    int cid3 = sc.nextInt();
                    System.out.println("Accounts:");
                    for (Account a : service.getAccountsByCustomerId(cid3)) {
                        System.out.println(a);
                    }
                    break;

                case 7:
                	for (Transaction T : service.getAllTransactions()) {
                		System.out.println(T);
                	}
                    System.out.print("Account ID: ");
                    int accid = sc.nextInt();
                    System.out.println("Transactions:");
                    for (Transaction tr : service.getTransactionsByAccountId(accid)) {
                        System.out.println(tr);
                    }
                    break;

                case 8:
                	for (Beneficiary Be : service.getAllBeneficiaries()) {
            		System.out.println(Be);
                	}
                    System.out.print("Customer ID: ");
                    int bcusid = sc.nextInt();
                    System.out.println("Beneficiaries:");
                    for (Beneficiary b : service.getBeneficiariesByCustomerId(bcusid)) {
                        System.out.println(b);
                    }
                    break;

                case 9:
                    System.out.println("Thank you!");
                    System.exit(0);
            }
        }
    }
}