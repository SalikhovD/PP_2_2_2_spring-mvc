package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.AppService;

@Controller
public class HelloController {

    private final AppService service;

    HelloController(AppService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        model.addAttribute("messages", service.getWelcomeMessagesList());
        return "index";
    }

    @GetMapping(value = "/cars")
    public String cars(@RequestParam(required = false) Integer count, Model model) {
        model.addAttribute("carList", service.getCarList(count));
        return "cars";
    }
}