package model;
import javax.persistence.*;

@Entity
@Table(name="CurrentAccount")
@DiscriminatorValue(value="Current")
@SuppressWarnings("SerializableClass")
public class CurrentAccount extends BankAccount {
    
    public CurrentAccount() {
        
    }
    
    public CurrentAccount(int lastWithdrawal, int lastDeposit, double balance, double interestRate) {
        super(lastWithdrawal, lastDeposit, balance, interestRate);
        addAccount(this);
    }
    
    @Override
    public void withdraw(double amount) {
         balance -= amount;
    }
    
    @Override
    public void deposit(double amount) {
    
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}
