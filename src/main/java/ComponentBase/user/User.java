package ComponentBase.user;


import ComponentBase.message.Message;
import ComponentBase.role.Role;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by waiti on 5/1/2016.
 */
@Entity
@Document
public class User {
    @Id
    private String id;
    private String name;
    private String surname;
    @Indexed(unique = true)
    private String username;
    private String password;
    @Indexed(unique = true)
    private String email;
    private boolean accountConfirm = false;
    private Date dob;
    @Indexed(unique = true)
    private String phoneNumber;
    private Set<Address> addresses = new HashSet<>();
    private Set<Role> roles = new HashSet<>();
    private Set<Message> messages = new HashSet<>();

    public User() {
    }

    public User(String username,String name, String surname, String email, String password, Set<Role> roles,Set<Address> addresses,String phoneNumber) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.addresses = addresses;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dob=" + dob +
                ", addresses=" + addresses +
                ", roles=" + roles +
                '}';
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public boolean isAccountConfirm() {
        return accountConfirm;
    }

    public void setAccountConfirm(boolean accountConfirm) {
        this.accountConfirm = accountConfirm;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public Role getRole() {
        Role current = new Role("customer");
        for (Role role : this.roles) {
            if (role.getRoleName().equals("admin")){return role;}
            else if(role.getRoleName().equals("wholesaler")){return role;}
            else if(role.getRoleName().equals("retailer")){return role;}
            else {current = role;}
        }
        return current;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
