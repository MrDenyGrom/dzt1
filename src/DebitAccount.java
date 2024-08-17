public class DebitAccount extends Account {
    public DebitAccount(int accountNumber, double balance, double serviceFee) {
        super(accountNumber, balance, serviceFee);
    }

    public DebitAccount(int accountNumber, double balance, double serviceFee, Currency currency) {
        super(accountNumber, balance, serviceFee, currency);
    }
}
