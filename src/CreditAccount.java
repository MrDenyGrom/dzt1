public class CreditAccount extends Account {
    private double interestRate;
    private double creditLimit;
    private double accruedInterest;
    private double accruedServiceFees;

    public CreditAccount(int accountNumber, double balance, double serviceFee) {
        super(accountNumber, balance, serviceFee);
        this.interestRate = 0;
        this.creditLimit = 0;
        this.accruedInterest = 0;
        this.accruedServiceFees = 0;
    }

    public CreditAccount(int accountNumber, double balance, double serviceFee, Currency currency, double interestRate, double creditLimit) {
        super(accountNumber, balance, serviceFee, currency);
        this.interestRate = interestRate;
        this.creditLimit = creditLimit;
        this.accruedInterest = 0;
        this.accruedServiceFees = 0;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getAccruedInterest() {
        return accruedInterest;
    }

    public double getAccruedServiceFees() {
        return accruedServiceFees;
    }

    public void accrueInterest(int daysInYear) {
        if (getBalance() < creditLimit) {
            accruedInterest += (creditLimit - getBalance()) * (interestRate / daysInYear) / 100;
        }
    }

    @Override
    public void deductServiceFee() {
        accruedServiceFees += getServiceFee();
    }

    @Override
    public void deposit(double amount) {
        double remainingAmount = amount;

        if (accruedServiceFees > 0) {
            if (remainingAmount >= accruedServiceFees) {
                remainingAmount -= accruedServiceFees;
                accruedServiceFees = 0;
            } else {
                accruedServiceFees -= remainingAmount;
                remainingAmount = 0;
            }
        }

        if (accruedInterest > 0 && remainingAmount > 0) {
            if (remainingAmount >= accruedInterest) {
                remainingAmount -= accruedInterest;
                accruedInterest = 0;
            } else {
                accruedInterest -= remainingAmount;
                remainingAmount = 0;
            }
        }

        if (remainingAmount > 0) {
            super.deposit(remainingAmount);
        }
    }
}
