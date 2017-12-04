package model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "Client")
@SuppressWarnings("SerializableClass")
public class Client {

    @Id  @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "cid", nullable = false)
    int cid;
    @Column(name = "fname", nullable = false)
    public String fname;
    @Column(name = "lname", nullable = false)
    public String lname;
    @Column(name = "email")
    public String email;
    @Column(name = "phone")
    public String phone;
    @Column(name = "address", nullable = false)
    public String address;
    @Column(name = "age", nullable = false)
    public String age;
    @ManyToMany
    @JoinTable(
        name="ClientAcc"
        , joinColumns={
            @JoinColumn(name="cid")
            }
        , inverseJoinColumns={
            @JoinColumn(name="bid")
            }
        )
    static ArrayList<Client> cList = new ArrayList();
    @Transient
    static int idCount = 0;
    
    public Client() {
        
    }
    
    public Client(String fname, String lname, String email, String phone, String address, String age) {
        this.cid = getLastID() + 1;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.age = age;
        addClient(this);
    }

    public void addClient(Client c) {
        if (!isDuplicate(c.getCid())) {
            cList.add(c);
        }
    }

    public int getLastID() {
        return cList.size();
    }

    public static boolean isDuplicate(int id) {
        for(Client c : cList) {
            if (c.getCid() == id) {
                return true;
            }
        }
        return false;
    }

    public int getCid() {
        return cid;
    }

    public String getfname() {
        return fname;
    }

    public String getlname() {
        return lname;
    }

    public String getemail() {
        return email;
    }

    public String getphone() {
        return phone;
    }

    public String getaddress() {
        return address;
    }

    public String getage() {
        return age;
    }

    public void setcid(int cid) {
        this.cid = cid;
    }

    public void setfname(String fname) {
        this.fname = fname;
    }

    public void setlname(String lname) {
        this.lname = lname;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public void setage(String age) {
        this.age = age;
    }

    public static void printCList() {
        for(Client c : cList) {
            System.out.printf("------------------------------%n"
                    + "Client %d, %s %s%n"
                    + "------------------------------", c.getCid(), c.getfname(), c.getlname());
            System.out.println(c.toString());
        }
    }
    
    public static void updateCList() {
        for(int i = 1; dbOperations.em.find(Client.class, i) != null; i++) {
            cList.add(dbOperations.em.find(Client.class, i));
        }
    }
    
    public String toString() {
        return "\nClient ID: " + cid + "\nName: " + fname + " " + lname + "\nEmail: " + email + "\nPhone: " + phone + "\nAddress: " + address + "\nAge: " + age;
    }
    
    static public ArrayList<Client> getClist(){
        return cList;
    }    
}
