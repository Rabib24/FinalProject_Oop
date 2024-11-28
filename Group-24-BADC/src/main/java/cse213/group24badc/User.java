package cse213.group24badc;

import java.time.LocalDate;
import java.util.ArrayList;


public class User {
    private String username, role, fullName, email, phoneNumber,nid, gender;
    private LocalDate birthDate;
    private boolean isLoggedIn = false;
    private Address address;


    public User(String username, String role, String fullName, String email, String phoneNumber, String nid, String gender, LocalDate birthDate, Address address) {
        this.username = username;
        this.role = role;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.nid = nid;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    protected void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public String getAddress() {
        return address.getAddress();
    }

    public String UserInfo() {
        return "User{" +
                "username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", nid='" + nid + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                ", isLoggedIn=" + isLoggedIn +
                ", address=" + address.getAddress() +
                '}';
    }
}
