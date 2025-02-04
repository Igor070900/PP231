package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

@Controller
public class CarsController {

    private CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping("/cars")
    public String showAllCars(@RequestParam(value = "count", defaultValue = "0") int count
            , Model model) {
        model.addAttribute("cars", carService.getCars(count));
        return "cars";
    }
}
