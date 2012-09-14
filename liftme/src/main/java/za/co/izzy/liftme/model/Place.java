/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.izzy.liftme.model;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author vusa
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Place.findAll", query = "SELECT p FROM Place p"),
    @NamedQuery(name = "Place.findById", query = "SELECT p FROM Place p WHERE p.id = :id"),
    @NamedQuery(name = "Place.findByOwner", query = "SELECT p FROM Place p WHERE p.owner = :owner"),
    @NamedQuery(name = "Place.findByName", query = "SELECT p FROM Place p WHERE p.name = :name")})
public class Place extends BaseEntity {
    @ManyToOne
    private Person owner;
    private String name;
    private String address;
    private double lat;
    private double lng;

    public Place() {
    }

    public Place(Long id) {
        setId(id);
    }

    @Override
    public String getDisplayText() {
        return name;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "com.test.model.Place[ id=" + getId() + " ]";
    }
    
}
