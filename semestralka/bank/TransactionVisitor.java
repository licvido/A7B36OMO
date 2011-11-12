package bank;

public interface TransactionVisitor {
    public void visitDeposit(Deposit d);

    public void visitWithdrawal(Withdrawal w);

    public void visitInboundTransfer(Transfer t);

    public void visitOutboundTransfer(Transfer t);
}
