package model;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class dbOperations {

    public static EntityManagerFactory emf;
    public static EntityManager em;
    public static Scanner input = new Scanner(System.in);

    public void init() {
        emf = Persistence.createEntityManagerFactory("CA2BANKACCOUNTPU");
        em = emf.createEntityManager();
        model.Client.updateCList();
        Client c = new Client("bucko", "mcfucko", "mickmail", "0691896", "56", "5");
        em.getTransaction().begin();
        
        em.persist(c);
        em.getTransaction().commit();
    }

    public void view(String table) {
        //Select everything from Clients
        //Class toView = resolveClassname(table);
        List results = em.createQuery("SELECT a FROM " + table + " a").getResultList();
        if (results.isEmpty()) {
            System.out.println("No " + table + "s Found");
        } else {
            for (int i = 0; i < results.size(); i++) {
                System.out.println(results.get(i).toString());
            }
        }
    }

    /**
     * Delete a record from the table. The table name is passed in as a string
     * and then converted to a classname with the
     * {@link model.dbOperations#resolveClassname(java.lang.String)} method.
     * Then we create an object of the resolved class and delete that.
     *
     * @param table The table
     * @param column
     * @param obj The reference to the object we want to delete. Can be passed
     * as either string or int to reference either name or id
     */
    public void deleteFrom(String table, String column, Object obj) {
        Class toQuery = resolveClassname(table); //Find out which table we're deleting from
        em.getTransaction().begin();
        Object toDelete = new Object(); //Create an object to hold whatever we want to delete
        if (obj instanceof Integer) { //query by ID
            toDelete = em.find(toQuery, obj);
        } else if (obj instanceof String) { //query by name
            toDelete = getReferenceTo(table, column, obj);
        } else {
            System.out.println("Invalid ting");
        }

        if (toDelete != null) {
            em.remove(toDelete);
        }
        em.getTransaction().commit();
    }

    public void update(String table, String column, Object obj, Object change) {
        em.getTransaction().begin();
        Class toQuery = resolveClassname(table);
        Object toUpdate = new Object();
        try {
            Field colType = toQuery.getDeclaredField(column);
            toQuery.getDeclaredMethod("set" + column, colType.getType()).invoke(toUpdate, change);
            em.merge(toUpdate);
        } catch (NoSuchFieldException | InvocationTargetException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(dbOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        em.merge(toUpdate);
        em.getTransaction().commit();
    }

    public void add(String table) {
        em.getTransaction().begin();
        Class toQuery = resolveClassname(table);    //get the tablename entered as a class
        Object toAdd = em.find(toQuery, 1);     //get an object of the class
        Field[] f = toQuery.getFields();    //get the variables of that class
        System.out.printf("Enter the following information for this %s: ", toQuery.getName());
        for (int i = 0; i < f.length; i++) {    //go through all of the variable names
            try {
                if (toQuery.getDeclaredMethod("set" + f[i].getName(), f[i].getType()) != null) {    //search the class and look for the setter associated with the current variable
                    System.out.println(f[i].getName() + ": ");
                    toQuery.getDeclaredMethod("set" + f[i].getName(), f[i].getType()).invoke(toAdd, input.nextLine());  //call the setter and let the user input the info
                }
            } catch (IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(dbOperations.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        em.persist(toAdd);
        em.getTransaction().commit();
    }

    public Class resolveClassname(String table) { //Use this method to pass in the name of a table and get a valid class from it
        try {
            Class classType = Class.forName("model." + table); //Class.forName returns a class with the same name as the string passed to it
            return classType;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dbOperations.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Object getReferenceTo(String table, Object column, Object value) {
        Object obj = em.createQuery("SELECT a FROM " + table + " a WHERE a." + column + " = '" + value + "'").getSingleResult();
        if (obj != null) {
            return obj;
        } else {
            System.out.println("Invalid query in dbOperations.getReferenceTo()");
            return null;
        }
    }
}
