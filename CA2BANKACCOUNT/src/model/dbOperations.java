package model;

import javax.persistence.*;
import java.util.List;

public class dbOperations {

    static EntityManagerFactory emf;
    static EntityManager em;

    public void init() {
        emf = Persistence.createEntityManagerFactory("CA2BANKACCOUNTPU");
        em = emf.createEntityManager();
    }

    public void viewClients() {
        em.getTransaction().begin();

        //Select everything from Clients
        //TypedQuery<Client> query = em.createQuery("SELECT a FROM Client a", Client.class);
        Query query = em.createNativeQuery("SELECT CID, ADDRESS, AGE, EMAIL, FNAME, LNAME, PHONE FROM Client", Client.class);
        List<Client> results = query.getResultList();
        if (results.isEmpty()) {
            System.out.println("No Clients Found");
        } else {
            for (int i = 0; i < results.size(); i++) {
                System.out.println(results.get(i).toString());
            }
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
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
                //int size = results.get(i).getClist().size(); //client list
                //for (int j = 0; j < size; j++) {
                // System.out.println("\t" + results.get(i).getClist().get(j).getFname());
                //}
            }
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    //public void

}
