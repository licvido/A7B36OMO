package bank;

public class ClosedAccountException extends AccountException {

    public static final String DEFAULT_MESSAGE = "Account is closed!";

    public ClosedAccountException(final String accountNo) {
        super(ClosedAccountException.DEFAULT_MESSAGE, accountNo);
    }
}
