package com.chat4chat.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "chat")
public class Chat implements Serializable {

    @Id
    private int id;

    @Column(name = "chat_name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "message")
    private String message;

    @Column(name = "date")
    private Date date;

    public Chat() {
    }

    public Chat(int id, String name, String email, String userName, String message, Date date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.message = message;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chat)) return false;

        Chat chat = (Chat) o;

        if (getId() != chat.getId()) return false;
        if (!getName().equals(chat.getName())) return false;
        if (!getEmail().equals(chat.getEmail())) return false;
        if (!getUserName().equals(chat.getUserName())) return false;
        if (!getMessage().equals(chat.getMessage())) return false;
        return getDate().equals(chat.getDate());

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getUserName().hashCode();
        result = 31 * result + getMessage().hashCode();
        result = 31 * result + getDate().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
