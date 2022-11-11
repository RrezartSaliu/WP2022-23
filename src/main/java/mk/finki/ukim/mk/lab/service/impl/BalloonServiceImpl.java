package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.repository.BalloonRepository;
import mk.finki.ukim.mk.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalloonServiceImpl implements BalloonService {
    private final BalloonRepository balloonRepository;

    public BalloonServiceImpl(BalloonRepository balloonRepository) {
        this.balloonRepository = balloonRepository;
    }

    @Override
    public Balloon addBalloon(Balloon b) {
        balloonRepository.addBalloon(b);
        return b;
    }

    @Override
    public void deleteBalloon(Long id) {
        balloonRepository.deleteBalloon(id);
    }

    @Override
    public void editBalloon(Long id, String name, String Description, Manufacturer manufacturer) {
        balloonRepository.editBalloon(id,name,Description,manufacturer);
    }
    @Override
    public Balloon findById(Long id){
        return balloonRepository.findById(id);
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return balloonRepository.findAllByNameOrDescription(text);
    }
}
