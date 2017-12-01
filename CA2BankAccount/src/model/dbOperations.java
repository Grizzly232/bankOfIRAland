package model;

import javax.persistence.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.persistence.descriptors.ClassExtractor;

public class dbOperations {

    public static EntityManagerFactory emf;
    public static EntityManager em;

    public void init() {
        emf = Persistence.createEntityManagerFactory("CA2BANKACCOUNTPU");
        em = emf.createEntityManager();
    }

    public void viewTable(String table) {
        //Select everything from Clients
        List<Client> results = em.createQuery("SELECT a FROM " + table + " a").getResultList();
        if (results.isEmpty()) {
            System.out.println("No Clients Found");
        } else {
            for (int i = 0; i < results.size(); i++) {
                System.out.println(results.get(i).toString());
            }
        }
    }
    /**
     * Delete a record from the table. The table name is passed in as a string and then converted to a classname with the {@link model.dbOperations#resolveClassname(java.lang.String)} method.
     * Then we create an object of the resolved class and delete that.
     * @param table The table
     * @param obj  The reference to the object we want to delete. Can be passed as either string or int to reference either name or id
     */
    public void deleteFrom(String table, Object obj) {
        Class toQuery = resolveClassname(table); //Find out which table we're deleting from
        em.getTransaction().begin();
        Object toDelete = new Object(); //Create an object to hold whatever we want to delete
        if (obj instanceof Integer) { //query by ID
            toDelete = em.find(toQuery, obj);
        } else if (obj instanceof String) { //query by name
            toDelete = getReferenceTo(table, obj, "Spurdo");
            toDelete.toString();
        }
        else {
            System.out.println("Invalid ting");
        }
        
        if(toDelete != null) {
            em.remove(toDelete);
        }
        em.getTransaction().commit();
    }
    
    public void update(String table, Object object) {
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
        BankAccount client = new CurrentAccount();
    }
    
    public void add(Object obj) {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }

    public Class resolveClassname(String table) { //Use this method to pass in the name of a table and get a valid class from it
        try {
            Class classType = Class.forName("model." + table); //Class.forName returns a class with the same name as the string passed to it
            return classType;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dbOperations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Object getReferenceTo(String table, Object column, Object value) {
        Object obj = em.createQuery("SELECT a FROM " + table + " a WHERE a." + column + " = '" + value + "'").getSingleResult();
        if(obj != null) {
            return obj;
        } else {
            System.out.println("Invalid query in dbOperations.getReferenceTo()");
            return null;
        }
    }
}
