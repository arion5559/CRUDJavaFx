package com.example.crudjavafx;

public class User {
    private int ID;
    private String name;
    private String surname;
    private String direction;
    private String username;
    private String password;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
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

    public User(int ID, String name, String surname, String direction,
                String username, String password) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.direction = direction;
        this.username = username;
        this.password = password;
    }
}
