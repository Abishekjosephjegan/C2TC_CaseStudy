package com.tns.banking.service;

import com.tns.banking.model.*;
import java.util.*;

public interface BankingService {

    void addCustomer(Customer customer);
    void addAccount(Account account);
    void addBeneficiary(Beneficiary beneficiary);
    void addTransaction(Transaction transaction);

    Customer findCustomerById(int id);
    Account findAccountById(int id);
    Beneficiary findBeneficiaryById(int id);
    Transaction findTransactionById(int id);

    List<Account> getAccountsByCustomerId(int customerId);
    List<Transaction> getTransactionsByAccountId(int accountId);
    List<Beneficiary> getBeneficiariesByCustomerId(int customerId);

    Collection<Customer> getAllCustomers();
    Collection<Account> getAllAccounts();
    Collection<Transaction> getAllTransactions();
    Collection<Beneficiary> getAllBeneficiaries();
}