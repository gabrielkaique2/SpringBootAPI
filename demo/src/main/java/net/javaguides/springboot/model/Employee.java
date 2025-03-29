package net.javaguides.springboot.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = true)
    private String password;

    @ManyToOne
    @JoinColumn(name = "sector_id", nullable = true)
    private Sector sector;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tab_user_sectors", joinColumns = @JoinColumn(name = "username"))
    @Column(name = "sector_id")
    private List<String> user_sectors = new ArrayList<>();

    public Employee() {
    }

    public Employee(String firstName, String lastName, String emailId, String username,
                    Sector sector, String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.sector = sector;
        this.password = password;
    }


    public Employee(String firstName, String lastName, String emailId, String username, String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }


    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }


    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
