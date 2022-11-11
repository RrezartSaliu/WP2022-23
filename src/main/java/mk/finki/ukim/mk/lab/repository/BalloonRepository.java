package mk.finki.ukim.mk.lab.repository;

import lombok.Data;
import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Data
public class BalloonRepository {
    List<Balloon> balloonList;

    public BalloonRepository(){
        balloonList = new ArrayList<>(10);
//        balloonList.add(new Balloon("Balloon1", "b1description"));
//        balloonList.add(new Balloon("Balloon2", "b2description"));
//        balloonList.add(new Balloon("Balloon3", "b3description"));
//        balloonList.add(new Balloon("Balloon4", "b4description"));
    }
    public void addBalloon(Balloon b){
        balloonList.add(b);
    }

    public void editBalloon(Long id, String name, String description, Manufacturer manufacturer){
        Balloon b = balloonList.stream().filter(balloon -> balloon.getId().equals(id)).findFirst().orElse((Balloon) null);
        if(b != null) {
            b.setName(name);
            b.setDescription(description);
            b.setManufacturer(manufacturer);
        }
    }

    public void deleteBalloon(Long id){
        balloonList.removeIf(balloon -> balloon.getId().equals(id));
    }

    public List<Balloon> findAllBalloons(){
        return balloonList;
    }

    public Balloon findById(Long id){
        return balloonList.stream().filter(balloon -> balloon.getId().equals(id)).findFirst().orElse((Balloon) null);
    }

    public List<Balloon> findAllByNameOrDescription(String text){
        return balloonList.stream().filter(balloon -> balloon.getName().contains(text)).filter(balloon -> balloon.getDescription().contains(text)).collect(Collectors.toList());
    }
}
