package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "index";
    }

    @GetMapping(value = "/cars")
    public String cars(@RequestParam(required = false) Integer count, Model model) {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("BMW", "M3", 350));
        carList.add(new Car("KIA", "Rio X", 108));
        carList.add(new Car("Porsche", "911", 380));
        carList.add(new Car("Lada", "2107", 85));
        carList.add(new Car("MINI", "Cooper", 160));

        if (count != null) {
            carList = carList.stream().limit(count).toList();
        }
        model.addAttribute("carList", carList);
        return "cars";
    }
}