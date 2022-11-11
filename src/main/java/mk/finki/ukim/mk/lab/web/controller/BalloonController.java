package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.service.BalloonService;
import mk.finki.ukim.mk.lab.service.ManufacturerService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BalloonController {
    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping(value = "/balloons")
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model){
        model.addAttribute("BalloonList", balloonService.listAll());
        return "listBalloons.html";
    }
    @PostMapping("/balloons/add")
    public String saveBalloon(@RequestParam(required = false) String name, @RequestParam(required = false) String description, @RequestParam(required = false) Long id, @RequestParam(required = false) Long balloonId){
        System.out.println(balloonId);
        if(balloonId == null)
            balloonService.addBalloon(new Balloon(name,description,manufacturerService.findById(id)));
        else
            balloonService.editBalloon(balloonId,name,description,manufacturerService.findById(id));
        return "redirect:/balloons";
    }

    @PostMapping("/balloons/delete/{id}")
    public String deleteBalloon(@PathVariable Long id){
        balloonService.deleteBalloon(id);
        return "redirect:/balloons";
    }
    @PostMapping("/balloons/edit/{id}")
    public String editBalloon(@PathVariable Long id, Model model){
        model.addAttribute("balloon", balloonService.findById(id));
        model.addAttribute("manufacturers", manufacturerService.findAll());
        return "add-balloon.html";
    }

    @GetMapping("/addBalloonPage")
    public String addBalloonPage(@RequestParam(required = false) String error, Model model){
        model.addAttribute("manufacturers", manufacturerService.findAll());
        return "add-balloon.html";
    }
}
