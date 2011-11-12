package bank;

import java.util.ArrayList;

public class NormalAccountState implements AccountState {

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

        return newBalance;
    }

    @Override
    public int withdraw(final Account source,
                        final int howMuch) throws AccountException {
        int newBalance = source.getBalance() - howMuch;

        if (newBalance < Account.MIN_BALANCE) {
            throw new NotEnoughMoneyOnAccountException(source.getNumber());
        }

        Withdrawal withdrawal = new Withdrawal(source, howMuch);
        source.addTransaction(withdrawal);

        ArrayList<AccountListener> listeners = source.getAccountListenersList();
        for (AccountListener listener : listeners) {
            listener.withdrawal(withdrawal);
        }

        return newBalance;
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

        return newBalance;
    }

    @Override
    public int transfer(final Account source, final int howMuch, final Account target) throws AccountException {
        int newBalance = source.getBalance() - howMuch;

        if (target.getState().equals(AccountState.CLOSED_STATE)) {
            throw new ClosedAccountException(target.getNumber());
        }

        if (newBalance < Account.MIN_BALANCE) {
            throw new NotEnoughMoneyOnAccountException(source.getNumber());
        }

        Transfer transfer = new Transfer(source, target, howMuch);
        transfer.setTransactionType(TransactionType.OUTBOUNDTRANSFERS);
        source.addTransaction(transfer);

        ArrayList<AccountListener> listeners = source.getAccountListenersList();
        for (AccountListener listener : listeners) {
            listener.outboundTransfer(transfer);
        }

        target.incomeTransfer(source, howMuch);

        return newBalance;
    }

    @Override
    public void close(final Account source) throws AccountException {
        source.setState(AccountState.CLOSED_STATE);
    }
}
