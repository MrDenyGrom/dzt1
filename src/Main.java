

public class Main {
    public static void main(String[] args) {
        System.out.println("Следующий номер счёта: " + AccountNumberGenerator.getNext());
        System.out.println("Следующий номер счёта: " + AccountNumberGenerator.getNext());
        System.out.println("Текущий номер счёта: " + AccountNumberGenerator.getCurrentNumber());
        AccountNumberGenerator.reset();
        System.out.println("Следующий номер счёта после сброса: " + AccountNumberGenerator.getNext());

        int accountNumber = AccountNumberGenerator.getNext();
        DebitAccount debitAccount = new DebitAccount(accountNumber, 1000.0, 10.0, Currency.USD);
        System.out.println("Баланс дебетового счёта: " + debitAccount.getBalance());
        debitAccount.deposit(500.0);
        System.out.println("Баланс дебетового счёта после пополения: " + debitAccount.getBalance());
        debitAccount.withdraw(200.0);
        System.out.println("Баланс дебетового счёта после снятия: " + debitAccount.getBalance());
        debitAccount.deductServiceFee();
        System.out.println("Баланс дебетового счёта после вычета комиссии: " + debitAccount.getBalance());

        accountNumber = AccountNumberGenerator.getNext();
        CreditAccount creditAccount = new CreditAccount(accountNumber, 500.0, 15.0, Currency.EUR, 5.0, 1000.0);
        System.out.println("Баланс кредитного счёта: " + creditAccount.getBalance());
        creditAccount.deposit(100.0);
        System.out.println("Баланс кредитного счёта после пополения: " + creditAccount.getBalance());
        creditAccount.withdraw(200.0);
        System.out.println("Баланс кредитного счёта после снятия: " + creditAccount.getBalance());
        creditAccount.deductServiceFee();
        System.out.println("Начисленные комиссионные за обслуживание кредитного счета: " + creditAccount.getAccruedServiceFees());
        creditAccount.accrueInterest(365);
        System.out.println("Начисленные проценты на кредитный счет: " + creditAccount.getAccruedInterest());
    }
}
