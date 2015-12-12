package models;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Виктор on 12.12.2015.
 */
@Entity
@Table(name="ADMINS")
public class Admin {
    public Admin(){}

    @Id
    @Column(name="ADMIN_ID")
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int adminId;

    @Column(name="NAME")
    private String name;

    @Column(name="PASSWORD")
    private String password;

    public int getAdminId() {
        return adminId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
