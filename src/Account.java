public abstract class Account {
    private double balance;
    private double serviceFee;
    private Currency currency;

    public Account(int accountNumber, double balance, double serviceFee) {
        this.balance = balance;
        this.serviceFee = serviceFee;
        this.currency = Currency.RUB;
    }

    public Account(int accountNumber, double balance, double serviceFee, Currency currency) {
        this.balance = balance;
        this.serviceFee = serviceFee;
        this.currency = currency;
    }

    public double getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(double serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void deductServiceFee() {
        balance -= serviceFee;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}
