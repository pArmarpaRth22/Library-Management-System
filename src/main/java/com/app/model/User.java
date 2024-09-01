package main.java.com.app.model;

import java.util.UUID;

public class User {
    private String userId;
    private String name;
    private long contactNumber;

    public  User(String userId, String name, long contactNumber) {
        this.userId = UUID.randomUUID().toString();;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }
}
