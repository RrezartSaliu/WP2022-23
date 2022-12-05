package mk.finki.ukim.mk.lab.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Balloon {
    String name;
    String description;
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    Manufacturer manufacturer;
    @Id
    private Long id;

    public Balloon(String name, String description, Manufacturer manufacturer) {
        this.id = (long)(Math.random() * 100);
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
    }

    public Manufacturer getManufacturer(){
        return manufacturer;
    }

    public Balloon() {

    }

    public Long getId() {
        return id;
    }
}
