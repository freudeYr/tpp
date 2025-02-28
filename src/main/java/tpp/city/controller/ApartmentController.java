package tpp.city.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tpp.city.model.Apartment;
import tpp.city.repo.ApartmentRepository;

@Controller
@RequestMapping("/apartment")
public class ApartmentController {

    private final ApartmentRepository apartmentRepository;

    public ApartmentController(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    @GetMapping
    public String getAllApartments(Model model) {
        List<Apartment> apartments = apartmentRepository.getAllApartments();
        model.addAttribute("apartments", apartments);
        return "apartment";
    }

    @PostMapping("/add")
    public String addApartment(@RequestParam int apartmentNumber, @RequestParam int houseId) {
        apartmentRepository.addApartment(apartmentNumber, houseId);
        return "redirect:/apartment";
    }

    @PostMapping("/delete")
    public String deleteApartment(@RequestParam int id) {
        apartmentRepository.deleteApartment(id);
        return "redirect:/apartment";
    }

    @PostMapping("/update")
    public String updateApartment(@RequestParam int id, @RequestParam int apartmentNumber) {
        apartmentRepository.updateApartment(id, apartmentNumber);
        return "redirect:/apartment";
    }
}
