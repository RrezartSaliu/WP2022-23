package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;

import java.util.List;


public interface BalloonService {
    Balloon addBalloon(Balloon b);
    void deleteBalloon(Long id);
    void editBalloon(Long id, String name, String Description, Manufacturer manufacturer);
    List<Balloon> listAll();
    Balloon findById(Long id);
    List<Balloon> searchByNameOrDescription(String text);
}
