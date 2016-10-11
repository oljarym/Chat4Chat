package com.chat4chat.model;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "friends")
public class Friend implements Serializable {

    @Id
    private int id;

    @Column(name = "id_friend_1")
    private int idFriend1;

    @Column(name = "id_friend_2")
    private int idFriend2;

    @Column(name = "approved")
    private boolean approved;

    public Friend() {
    }

    public Friend(int id, int idFriend1, int idFriend2, boolean approved) {
        this.id = id;
        this.idFriend1 = idFriend1;
        this.idFriend2 = idFriend2;
        this.approved = approved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFriend1() {
        return idFriend1;
    }

    public void setIdFriend1(int idFriend1) {
        this.idFriend1 = idFriend1;
    }

    public int getIdFriend2() {
        return idFriend2;
    }

    public void setIdFriend2(int idFriend2) {
        this.idFriend2 = idFriend2;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Friend)) return false;

        Friend friend = (Friend) o;

        if (getId() != friend.getId()) return false;
        if (getIdFriend1() != friend.getIdFriend1()) return false;
        if (getIdFriend2() != friend.getIdFriend2()) return false;
        return isApproved() == friend.isApproved();

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getIdFriend1();
        result = 31 * result + getIdFriend2();
        result = 31 * result + (isApproved() ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", idFriend1=" + idFriend1 +
                ", idFriend2=" + idFriend2 +
                ", approved=" + approved +
                '}';
    }
}
