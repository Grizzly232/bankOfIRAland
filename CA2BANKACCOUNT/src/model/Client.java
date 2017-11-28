package model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "Client")
@SuppressWarnings("SerializableInterface")
public class Client {

    @Id
    private int cid;
    private String fname;
    private String lname; 
    private String email;
    private String phone;
    private String address;
    private int age;
    static public ArrayList<Client> cList = new ArrayList();
    
    public Client() {
    
    }

    public Client(String fname, String lname, String email, String phone, String address, int age) {
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

    public boolean isDuplicate(int id) {
        for (Client c : cList) {
            if (c.getCid() == id) {
                return true;
            }
        }
        return false;
    }

    public int getCid() {
        return cid;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void printCList() {
        for(Client c : cList) {
            System.out.printf("------------------------------%n"
                    + "Client %d, %s %s%n"
                    + "------------------------------", c.getCid(), c.getFname(), c.getLname());
            System.out.println(c.toString());
        }
    }
    
    public String toString() {
        return "\nClient ID: " + cid + "\nName: " + fname + " " + lname + "\nEmail: " + email + "\nPhone: " + phone + "\nAddress: " + address + "\nAge: " + age;
    }
}
