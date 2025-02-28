package tpp.city.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tpp.city.repo.CityRepository;

@Controller
@RequestMapping("/city")
public class CityController {
    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    // Отримання всіх міст
    @GetMapping
    public String getCities(Model model) {
        model.addAttribute("cities", cityRepository.getAllCities());
        return "city";
    }

    @PostMapping("/add")
    public String addCity(@RequestParam String name) {
        cityRepository.addCity(name);
        return "redirect:/city";
    }

    @PostMapping("/update")
    public String updateCity(@RequestParam int id, @RequestParam String name) {
        cityRepository.updateCity(id, name);
        return "redirect:/city";
    }

    @PostMapping("/delete")
    public String deleteCity(@RequestParam int id) {
        cityRepository.deleteCity(id);
        return "redirect:/city";
    }
}
