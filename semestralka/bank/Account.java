package bank;

import java.util.ArrayList;
import java.util.Iterator;

public class Account {
    private final String number;
    private int balance;
    private AccountState state;

    private final ArrayList<Transaction> transactions;
    private final ArrayList<AccountListener> listeners;

    protected static final int MIN_BALANCE = 1000;

    protected Account(final int accountId) {
        this.number = "A" + String.format("%012d", accountId);
        this.balance = 0;
        this.state = AccountState.EMPTY_STATE;

        this.transactions = new ArrayList<Transaction>();
        this.listeners = new ArrayList<AccountListener>();
    }

    public String getNumber() {
        return this.number;
    }

    public int getBalance() {
        return this.balance;
    }

    public AccountState getState() {
        return this.state;
    }

    public void setState(final AccountState state) {
        this.state = state;
    }

    public void deposit(final int howMuch) throws AccountException {
        this.balance = this.state.deposit(this, howMuch);
    }

    public void withdraw(final int howMuch) throws AccountException {
        if (howMuch > 0) {
            this.balance = this.state.withdraw(this, howMuch);
        }
        else {
            throw new BadOperationAccountException(this.number);
        }
    }

    public void incomeTransfer(final Account source,
                               final int howMuch) throws AccountException {
        this.balance = this.state.incomeTransfer(source, howMuch, this);
    }

    public void transfer(final int howMuch,
                         final Account target) throws AccountException {
        this.balance = this.state.transfer(this, howMuch, target);
    }

    public void closeAccount() throws AccountException {
        this.state.close(this);
    }

    public boolean addTransaction(final Transaction transaction) {
        return this.transactions.add(transaction);
    }

    public ArrayList<Transaction> getTransactionsList() {
        return this.transactions;
    }

    public Transaction[] getTransactionsArray() {
        Transaction[] transactions = new Transaction[this.transactions.size()];

        return this.transactions.toArray(transactions);
    }

    public boolean removeTransaction(final Transaction transaction) {
        return this.transactions.remove(transaction);
    }

    public boolean addAccountListener(final AccountListener ac) {
        return this.listeners.add(ac);
    }

    public ArrayList<AccountListener> getAccountListenersList() {
        return this.listeners;
    }

    public AccountListener[] getAccountListenersArray() {
        AccountListener[] transactions = new AccountListener[this.listeners.size()];

        return this.listeners.toArray(transactions);
    }

    public boolean removeAccountListnener(final AccountListener ac) {
        return this.listeners.remove(ac);
    }

    public Iterator<Transaction> iterator(final TransactionType type, final int minAmount) {
        return new TransactionIterator(this, type, minAmount);
    }

    public void visitTransactions(final TransactionVisitor v) {
        for (Transaction transaction : this.transactions) {
            if (transaction.getTransactionType().equals(TransactionType.DEPOSITS)) {
                v.visitDeposit((Deposit) transaction);
            }
            else if (transaction.getTransactionType().equals(TransactionType.WITHDRAWALS)) {
                v.visitWithdrawal((Withdrawal) transaction);
            }
            else if (transaction.getTransactionType().equals(TransactionType.INBOUNDTRANSFERS)) {
                v.visitInboundTransfer((Transfer) transaction);
            }
            else {
                v.visitOutboundTransfer((Transfer) transaction);
            }
        }
    }
}
