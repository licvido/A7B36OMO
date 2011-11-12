package bank;

import java.util.ArrayList;
import java.util.Iterator;

public class TransactionIterator implements Iterator<Transaction> {
    private final Iterator<Transaction> iterator;

    public TransactionIterator(final Account account,
                               final TransactionType type,
                               final int minAmount) {
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        ArrayList<Transaction> allTransactions = account.getTransactionsList();

        for (Transaction transaction : allTransactions) {
            TransactionType transactionType = transaction.getTransactionType();
            if (transactionType.equals(type) || type.equals(TransactionType.ALL)) {
                if (transaction.getAmount() >= minAmount) {
                    transactions.add(transaction);
                }
            }
        }

        this.iterator = transactions.iterator();
    }

    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override
    public Transaction next() {
        return this.iterator.next();
    }

    @Override
    public void remove() {
        this.iterator.remove();
    }
}
