package model;

import javax.persistence.*;
import java.util.List;
import java.util.Random;

public class dbOperations {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2BANKACCOUNTPU");
    static EntityManager em = emf.createEntityManager();
    static Random rand = new Random(1000000000); //Random id generator for security purposes.
    int randID;

    public int randomID() {
        final int MAXID = 100;

        for (int i = 0; i < 100; i++) {

            randID = rand.nextInt();

        }
        return randID;
    }

    public void viewAccounts() {

        em.getTransaction().begin();
        TypedQuery<BankAccount> q = em.createQuery("select a from BankAccount a", BankAccount.class);
        List<BankAccount> results = q.getResultList();
        if (results.isEmpty()) {
            System.out.println("No Accounts found");
        } else {
            System.out.println("Account List");
            for (int i = 0; i < results.size(); i++) {
                System.out.println(results.get(i).getAccountID()); //curent id of the bank account
                int size = results.get(i).getClist().size(); //client list
                for (int j = 0; j < size; j++) {
                    System.out.println("\t" + results.get(i).getClist().get(j).getFname());
                }
            }
        }
        em.getTransaction().commit();
    }
    public void viewClients(){
        em.getTransaction().begin();
        TypedQuery<Client> q = em.createQuery("select c from Client c", Client.class);
        List<Client> results = q.getResultList();
        if (results.isEmpty()) {
            System.out.println("No Accounts found");
        } else {
            System.out.println("Account List");
            for (int i = 0; i < results.size(); i++) {
                System.out.println(results.get(i).getCid()); //curent id of the bank account
                int size = results.get(i).getClist().size(); //client list
                for (int j = 0; j < size; j++) {
                    System.out.println("\t" + results.get(i).getClist().get(j).getFname());
                }
            }
        }
        em.getTransaction().commit();
    }
    public void viewClientInformation(int cid){
        em.getTransaction().begin();
        TypedQuery<Client> q = em.createQuery("select c from client c where c.cid = ?", Client.class);
        List<Client> results = q.getResultList();
        if(results.isEmpty()){
            System.out.println("No ID exists");
        }
        else{
            System.out.println("Client information");
            for(int)
            
        }
    }

}
