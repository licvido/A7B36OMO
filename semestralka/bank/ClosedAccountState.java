package bank;

public class ClosedAccountState implements AccountState {

    @Override
    public int deposit(final Account source,
                       final int howMuch) throws AccountException {
        throw new ClosedAccountException(source.getNumber());
    }

    @Override
    public int withdraw(final Account source,
                        final int howMuch) throws AccountException {
        throw new ClosedAccountException(source.getNumber());
    }

    @Override
    public int incomeTransfer(final Account source,
                              final int howMuch,
                              final Account target) throws AccountException {
        throw new ClosedAccountException(target.getNumber());
    }

    @Override
    public int transfer(final Account source,
                        final int howMuch,
                        final Account target) throws AccountException {
        throw new ClosedAccountException(source.getNumber());
    }

    @Override
    public void close(final Account source) throws AccountException {
        throw new ClosedAccountException(source.getNumber());
    }
}
