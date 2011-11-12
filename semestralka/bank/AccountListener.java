package bank;

public interface AccountListener {
    public void deposit(Deposit d);

    public void withdrawal(Withdrawal w);

    public void outboundTransfer(Transfer t);

    public void inboundTransfer(Transfer t);
}
