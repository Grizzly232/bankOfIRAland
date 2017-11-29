package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

@Entity
@Table(name = "BankAccount")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@SuppressWarnings("SerializableInterface")
public class BankAccount {

    @Id
    protected int bid;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="ClientAcc",
            joinColumns = @JoinColumn(name="bid"),
            inverseJoinColumns = @JoinColumn(name="cid"))
    private List<Client> cList = new ArrayList<>();
    
         @Transient   
    Scanner in = new Scanner(System.in);
    
    protected ArrayList<String> holders;
    protected int pin, lastWithdrawal, lastDeposit;
    protected double balance;

    public BankAccount(int bid, int lastWithdrawal, int lastDeposit, double balance) {
        this.bid = bid;
        this.lastWithdrawal = lastWithdrawal;
        this.lastDeposit = lastDeposit;
        this.balance = balance;
    }
    
    
    
    public int getAccountID(){
        return bid; 
    }
    public List<Client> getClist(){
        return cList;
    }
    public void setcList(List<Client> cList){
        this.cList=cList;
    }
    
    public double getBalance(){
        return balance;
    }
    
    
  

}