package tpp.city.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tpp.city.model.House;
import tpp.city.repo.HouseRepository;

@Controller
@RequestMapping("/house")
public class HouseController {

    private final HouseRepository houseRepository;

    public HouseController(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @GetMapping
    public String getAllHouses(Model model) {
        List<House> houses = houseRepository.getAllHouses();
        model.addAttribute("houses", houses);
        return "house";
    }

    @PostMapping("/add")
    public String addHouse(@RequestParam String houseNumber, @RequestParam int streetId) {
        houseRepository.addHouse(houseNumber, streetId);
        return "redirect:/house";
    }

    @PostMapping("/delete")
    public String deleteHouse(@RequestParam int id) {
        houseRepository.deleteHouse(id);
        return "redirect:/house";
    }

    @PostMapping("/update")
    public String updateHouse(@RequestParam int id, @RequestParam String houseNumber) {
        houseRepository.updateHouse(id, houseNumber);
        return "redirect:/house";
    }
}
