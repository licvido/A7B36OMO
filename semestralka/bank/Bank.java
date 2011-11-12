package bank;

import java.util.HashMap;

public class Bank {
    private static Bank bank;
    private int newAccountId;
    private HashMap<String, Account> accounts;

    private Bank() {
        this.newAccountId = 1;
        this.accounts = new HashMap<String, Account>();
    }

    public static Bank getBank() {
        if (Bank.bank == null) {
            Bank.bank = new Bank();
        }

        return Bank.bank;
    }

    public Account createAccount() {
        Account account = new Account(this.newAccountId++);
        this.accounts.put(account.getNumber(), account);

        return account;
    }

    public Account lookupAccount(final String number) {
        return this.accounts.get(number);
    }

    private Account getAccount(final String accountNo) throws AccountException {
        Account account = this.accounts.get(accountNo);
        if (account == null) {
            throw new NonExistingAccountException(accountNo);
        }

        return account;
    }

    public int getBalance(final String accountNo) throws AccountException {
        return this.getAccount(accountNo).getBalance();
    }

    public void deposit(final String accountNo, final int howMuch) throws AccountException {
        this.getAccount(accountNo).deposit(howMuch);
    }

    public void withdraw(final String accountNo, final int howMuch) throws AccountException {
        this.getAccount(accountNo).withdraw(howMuch);
    }

    public void transfer(final String sourceAccount, final int howMuch, final String targetAccount) throws AccountException {
        Account source = this.getAccount(sourceAccount);
        Account target = this.getAccount(targetAccount);

        source.transfer(howMuch, target);
    }

    public void closeAccount(final String accountNo) throws AccountException {
        this.getAccount(accountNo).closeAccount();
    }
}
