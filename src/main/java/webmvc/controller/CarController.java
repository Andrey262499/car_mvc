package webmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webmvc.model.Car;
import webmvc.service.CarService;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping({"/cars", "/"})
    public String getCars(Model model, @RequestParam(value = "count", required = false) Integer count) {
        List<Car> cars = (count != null) ? carService.getCars(count) : carService.getCars();
        model.addAttribute("cars", cars);
        return "cars";
    }
}
