package bank;

public abstract class AccountException extends Exception {

    public AccountException(final String message, final String accountNo) {
        super(String.format(message, accountNo));
    }
}
