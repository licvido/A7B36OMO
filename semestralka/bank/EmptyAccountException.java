package bank;

public class EmptyAccountException extends AccountException {

    public static final String DEFAULT_MESSAGE = "Account is below limit!";

    public EmptyAccountException(final String accountNo) {
        super(EmptyAccountException.DEFAULT_MESSAGE, accountNo);
    }
}
