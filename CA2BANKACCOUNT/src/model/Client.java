package model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Clients")
@SuppressWarnings("SerializableInterface")
public class Client {
    
    @ManyToMany(mappedBy = "cList",cascade=CascadeType.PERSIST)
    static private ArrayList<Client> cList = new ArrayList<>();
    private String cid;
    @Id
    private String fname, lname, email, phone, address;
    private int age;
   
    

    public Client(String cid, String fname, String lname, String email, String phone, String address, int age) {
        this.cid = cid;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.age = age;
    }

    public String getCid() {
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

    public void setCid(String cid) {
        this.cid = cid;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
      public void addAccount(Client c) {
        if (!isDuplicate(c.getCid())) {
            cList.add(c);
        }
    }
       public boolean isDuplicate(String id) {
        for (Client c : cList) {
            if (c.getCid() == id) {
                return true;
            }
        }
        return false;
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
    static public ArrayList<Client> getClist(){
        return cList;
    }    
}
