package bank;

public class Withdrawal implements Transaction {
    private Account source;
    private int amount;

    public static final TransactionType TRANSACTION_TYPE = TransactionType.WITHDRAWALS;

    public Withdrawal(final Account sourceAccount,
                      final int withdrawaledAmount) {
        this.source = sourceAccount;
        this.amount = withdrawaledAmount;
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
        return Withdrawal.TRANSACTION_TYPE;
    }
}
