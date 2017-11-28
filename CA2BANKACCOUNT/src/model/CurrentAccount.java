package model;
import javax.persistence.*;

@Entity
@Table(name="CurrentAccount")
@DiscriminatorValue(value="Current")
@SuppressWarnings("SerializableClass")
public class CurrentAccount extends BankAccount {
    
    double interestRate;
    
    public CurrentAccount() {
        
    }
    
    @Override
    public void withdraw(double amount) {
         balance -= amount;
    }
    
    @Override
    public void deposit(double amount) {
        balance += amount;
    }
}
