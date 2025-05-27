package com.demo;


import com.entity.Car;
import com.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/")
    public String getWelcomePage(){
        return "welcome";
    }

    @RequestMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("car", new Car());
        return "carRegister";
    }

    @RequestMapping("/register-car")
    public String registerCar(@ModelAttribute("car") Car car, Model model) {
        String carId = carService.registerCar(car);
        model.addAttribute("carId", carId);
//        return "success";
        return "redirect:/car/"+car.getRegistrationNumber();
    }

    @RequestMapping("/details/{regNo}")
    public ModelAndView showCarDetails(@PathVariable String regNo, @RequestParam(required = false) String owner) {
        ModelAndView modelAndView = new ModelAndView("carDetails");
        Car car = new Car();
        car.setRegistrationNumber(regNo);
        car.setManufacturer("Hyundai");
        car.setModel("i20");
        modelAndView.addObject("car",car);
        modelAndView.addObject("owner", owner!=null?owner:"Unknown");
        return modelAndView;
    }
}
