package api.Registration.model;

import api.Inventory.Item;
import api.SpringSecurity.models.User;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Restaurantinfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;
    private String latitude;
    private String longitude;


    @OneToOne(mappedBy = "restaurantinfo")
    private User user;

    @OneToMany(mappedBy="restaurantinfo")
    private Set<Item> items;

    //needed for retrieving users
    public Restaurantinfo(){

    }

    public Restaurantinfo(String address, String latitude, String longitude) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

  /*  public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/
}