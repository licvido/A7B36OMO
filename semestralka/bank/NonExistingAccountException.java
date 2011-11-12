package bank;

public class NonExistingAccountException extends AccountException {

    public static final String DEFAULT_MESSAGE = "Account does not exist!";

    public NonExistingAccountException(final String accountNo) {
        super(NonExistingAccountException.DEFAULT_MESSAGE, accountNo);
    }
}
