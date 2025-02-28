package tpp.city.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tpp.city.model.Street;
import tpp.city.repo.StreetRepository;

@Controller
@RequestMapping("/street")
public class StreetController {

    private final StreetRepository streetRepository;

    public StreetController(StreetRepository streetRepository) {
        this.streetRepository = streetRepository;
    }

    @GetMapping
    public String getAllStreets(Model model) {
        List<Street> streets = streetRepository.getAllStreets();
        model.addAttribute("streets", streets);
        return "street";
    }

    @PostMapping("/add")
    public String addStreet(@RequestParam String streetName, @RequestParam int cityId) {
        streetRepository.addStreet(streetName, cityId);
        return "redirect:/street";
    }

    @PostMapping("/delete")
    public String deleteStreet(@RequestParam int id) {
        streetRepository.deleteStreet(id);
        return "redirect:/street";
    }

    @PostMapping("/update")
    public String updateStreet(@RequestParam int id, @RequestParam String streetName) {
        streetRepository.updateStreet(id, streetName);
        return "redirect:/street";
    }
}