package model;
import javax.persistence.*;

@Entity
@Table(name="CurrentAccount")
@DiscriminatorValue(value="Current")
@SuppressWarnings("SerializableClass")
public class CurrentAccount extends BankAccount {
    
    double interestRate;
    
    public CurrentAccount(int bid, int lastWithdrawal, int lastDeposit, double balance,int monthlyTransactions,double interestRate) {
        super(bid,lastWithdrawal,lastDeposit,balance);
        this.interestRate=interestRate;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }
    @Override
    public String toString(){
        return super.toString()+"\nType: Current\nBalance: "+balance;
    }
    
   
    
    
}
