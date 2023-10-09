package ways.kinobackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String passWord;
    private int email;
    private int phone;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    @JsonBackReference
    private Set<Seat> seat = new HashSet<>();
   /* @OneToOne
    @JoinColumn(name="seat",referencedColumnName = "id")
    private Seat seat;*/


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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    /*public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }*/

    public Set<Seat> getSeat() {
        return seat;
    }

    public void setSeat(Set<Seat> seat) {
        this.seat = seat;
    }
}
