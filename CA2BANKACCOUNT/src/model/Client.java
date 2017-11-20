package model;
import javax.persistence.*;

@Entity
@Table(name="Clients")
@SuppressWarnings("SerializableInterface")
public class Client {
    @Id
    private String cid;
    private String fname, lname, email, phone, address;
    private int age;
}
