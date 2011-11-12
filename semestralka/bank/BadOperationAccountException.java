package bank;

public class BadOperationAccountException extends AccountException {

    public static final String DEFAULT_MESSAGE = "Bad operation!";

    public BadOperationAccountException(final String accountNo) {
        super(BadOperationAccountException.DEFAULT_MESSAGE, accountNo);
    }
}
