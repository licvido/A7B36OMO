package bank;

public class Transfer implements Transaction {
    private final Account source;
    private final Account target;
    private final int amount;

    private TransactionType type;

    public Transfer(final Account transferSource,
                    final Account transferTarget,
                    final int transferAmount) {
        this.source = transferSource;
        this.target = transferTarget;
        this.amount = transferAmount;
    }

    @Override
    public Account getSourceAccount() {
        return this.source;
    }

    @Override
    public int getAmount() {
        return this.amount;
    }

    public Account getTargetAccount() {
        return this.target;
    }

    public void setTransactionType(final TransactionType transactionType) {
        this.type = transactionType;
    }

    @Override
    public TransactionType getTransactionType() {
        return this.type;
    }
}
