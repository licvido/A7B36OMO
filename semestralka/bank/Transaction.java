package bank;

public interface Transaction {
    public Account getSourceAccount();

    public int getAmount();

    public TransactionType getTransactionType();
}
