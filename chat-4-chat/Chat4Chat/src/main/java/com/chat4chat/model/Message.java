package com.chat4chat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "message")
public class Message implements Serializable {

    @Id
    private int id;

    @Column(name = "user_1")
    private int idUser1;

    @Column(name = "user_2")
    private int idUser2;

    @Column(name = "message")
    private String massage;

    @Column(name = "date")
    private Date date;

    public Message() {
    }

    public Message(int id, int idUser1, int idUser2, String massage, Date date) {
        this.id = id;
        this.idUser1 = idUser1;
        this.idUser2 = idUser2;
        this.massage = massage;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser1() {
        return idUser1;
    }

    public void setIdUser1(int idUser1) {
        this.idUser1 = idUser1;
    }

    public int getIdUser2() {
        return idUser2;
    }

    public void setIdUser2(int idUser2) {
        this.idUser2 = idUser2;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
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
        if (!(o instanceof Message)) return false;

        Message message = (Message) o;

        if (getId() != message.getId()) return false;
        if (getIdUser1() != message.getIdUser1()) return false;
        if (getIdUser2() != message.getIdUser2()) return false;
        if (!getMassage().equals(message.getMassage())) return false;
        return getDate().equals(message.getDate());

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getIdUser1();
        result = 31 * result + getIdUser2();
        result = 31 * result + getMassage().hashCode();
        result = 31 * result + getDate().hashCode();
        return result;
    }


    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", idUser1=" + idUser1 +
                ", idUser2=" + idUser2 +
                ", massage='" + massage + '\'' +
                ", date=" + date +
                '}';
    }
}
