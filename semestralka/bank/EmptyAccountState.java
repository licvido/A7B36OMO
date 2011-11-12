package bank;

import java.util.ArrayList;

public class EmptyAccountState implements AccountState {

    @Override
    public int deposit(final Account source,
                       final int howMuch) throws AccountException {
        int newBalance = source.getBalance() + howMuch;

        Deposit deposit = new Deposit(source, howMuch);
        source.addTransaction(deposit);

        ArrayList<AccountListener> listeners = source.getAccountListenersList();
        for (AccountListener listener : listeners) {
            listener.deposit(deposit);
        }

        if (newBalance >= Account.MIN_BALANCE) {
            source.setState(AccountState.NORMAL_STATE);
        }

        return newBalance;
    }

    @Override
    public int withdraw(final Account source,
                        final int howMuch) throws AccountException {
        throw new EmptyAccountException(source.getNumber());
    }

    @Override
    public int transfer(final Account source,
                        final int howMuch,
                        final Account target) throws AccountException {
        throw new EmptyAccountException(source.getNumber());
    }

    @Override
    public void close(final Account source) throws AccountException {
        source.setState(AccountState.CLOSED_STATE);
    }

    @Override
    public int incomeTransfer(final Account source,
                              final int howMuch,
                              final Account target) throws AccountException {
        int newBalance = target.getBalance() + howMuch;

        Transfer transfer = new Transfer(source, target, howMuch);
        transfer.setTransactionType(TransactionType.INBOUNDTRANSFERS);
        target.addTransaction(transfer);

        ArrayList<AccountListener> listeners = target.getAccountListenersList();
        for (AccountListener listener : listeners) {
            listener.inboundTransfer(transfer);
        }

        if (newBalance >= Account.MIN_BALANCE) {
            target.setState(AccountState.NORMAL_STATE);
        }

        return newBalance;
    }
}
