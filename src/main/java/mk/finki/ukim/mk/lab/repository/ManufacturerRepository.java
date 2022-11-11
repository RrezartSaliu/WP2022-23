package mk.finki.ukim.mk.lab.repository;


import lombok.Data;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Data
public class ManufacturerRepository {
    private List<Manufacturer> manufacturers;

    public ManufacturerRepository(){
        manufacturers = new ArrayList<>(5);
        manufacturers.add(new Manufacturer("John Smith", "USA", "NY, Manhattan 1435"));
        manufacturers.add(new Manufacturer("James Charles", "England", "London, Malet Street"));
        manufacturers.add(new Manufacturer("Frank Becker", "Germany", "Kleine Hamburger Str. 56"));
        manufacturers.add(new Manufacturer("Louise Allard", "France", "74 Rue de Verdun"));
        manufacturers.add(new Manufacturer("Rezart Saliu", "North Macedonia", "Mladen Stojanovikj 43"));
    }

    public List<Manufacturer> findAll(){
        return manufacturers;
    }

    public Manufacturer findById(Long id){
        return manufacturers.stream().filter(manufacturer -> manufacturer.getId().equals(id)).findFirst().orElse((Manufacturer) null);
    }
}
