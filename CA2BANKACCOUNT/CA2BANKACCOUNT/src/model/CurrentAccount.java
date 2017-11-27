package model;
import javax.persistence.*;

@Entity
@Table(name="Accounts")
@DiscriminatorValue(value="current")
@SuppressWarnings("SerializableClass")
public class CurrentAccount extends BankAccount {
    
    double interestRate;
    
    @Override
    public void withdraw(double amount) {
         balance -= amount;
    }
    
    @Override
    public void deposit() {
    
    }
}
