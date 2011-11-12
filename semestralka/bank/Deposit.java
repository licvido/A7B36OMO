package bank;

public class Deposit implements Transaction {
    private Account source;
    private int amount;

    public static final TransactionType TRANSACTION_TYPE = TransactionType.DEPOSITS;

    public Deposit(final Account sourceAccount,
                   final int depositedAmount) {
        this.source = sourceAccount;
        this.amount = depositedAmount;
    }

    @Override
    public Account getSourceAccount() {
        return this.source;
    }

    @Override
    public int getAmount() {
        return this.amount;
    }

    @Override
    public TransactionType getTransactionType() {
        return Deposit.TRANSACTION_TYPE;
    }
}
