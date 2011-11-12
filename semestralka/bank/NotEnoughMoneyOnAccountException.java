package bank;

public class NotEnoughMoneyOnAccountException extends AccountException {

    public static final String DEFAULT_MESSAGE = "Not enough money on account!";

    public NotEnoughMoneyOnAccountException(final String accountNo) {
        super(NotEnoughMoneyOnAccountException.DEFAULT_MESSAGE, accountNo);
    }
}
