package bank;

public interface AccountState {

    public static final EmptyAccountState EMPTY_STATE = new EmptyAccountState();
    public static final NormalAccountState NORMAL_STATE = new NormalAccountState();
    public static final ClosedAccountState CLOSED_STATE = new ClosedAccountState();

    public int deposit(Account source, int howMuch) throws AccountException;

    public int withdraw(Account source, int howMuch) throws AccountException;

    public int incomeTransfer(Account source, int howMuch, Account target) throws AccountException;

    public int transfer(Account source, int howMuch, Account target) throws AccountException;

    public void close(Account source) throws AccountException;
}
