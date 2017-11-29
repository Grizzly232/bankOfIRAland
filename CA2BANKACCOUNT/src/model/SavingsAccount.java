package model;
import javax.persistence.*;

@Entity
@Table(name="SavingsAccount")
@DiscriminatorValue(value="Savings")
@SuppressWarnings("SerializableClass")
public class SavingsAccount extends BankAccount {
    
    int monthlyTransactions;

    public SavingsAccount(int bid, int lastWithdrawal, int lastDeposit, double balance,int monthlyTransactions) {
        super(bid,lastWithdrawal,lastDeposit,balance);
        this.monthlyTransactions = monthlyTransactions;
    }
    public int getMontlyTransactions(){
        return monthlyTransactions;
    }
    

}
