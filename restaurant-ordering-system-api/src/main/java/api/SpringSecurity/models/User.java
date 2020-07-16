package api.SpringSecurity.models;

import api.Registration.model.Restaurantinfo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/*
This class represents the web application users which is mapped to the user table in the DB
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    @NotBlank
    @Size(min = 10, max = 10, message = "Phone number should be 10 characters length")
    private String phone; //Refers to the user's phone number
    private boolean activated;
    private String roles;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    private Restaurantinfo restaurantinfo;

    public Restaurantinfo getRestaurantInfo() {
        return restaurantinfo;
    }

    public void setRestaurantInfo(Restaurantinfo restaurantInfo) {
        this.restaurantinfo = restaurantInfo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone_number) {
        this.phone = phone_number;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
