package model;
import javax.persistence.*;

@Entity
@Table(name="SavingsAccount")
@DiscriminatorValue(value="Savings")
@SuppressWarnings("SerializableClass")
public class SavingsAccount extends BankAccount {
    
    int monthlyTransactions;
    
    @Override
    public void withdraw(double amount) {
        
        if(monthlyTransactions >= 6) {
            System.out.printf("Account %s has withdrawn %d times this month. No withdrawals remaining.", bid, monthlyTransactions);
        } else {
            balance -= amount;
            System.out.printf("Withdrawal successful. %d withdrawals remaining.", monthlyTransactions);
        }
        monthlyTransactions++;
    }
    
    @Override
    public void deposit() {
    
    }
}
