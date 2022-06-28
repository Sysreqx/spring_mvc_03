package kz.kaisar.springmvc03.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {

    @GetMapping("/test")
    public String testPage() {
        return "first/test";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(required = false) String a,
                                 @RequestParam(required = false) String b,
                                 @RequestParam(required = false) String action,
                                 Model model) {

        int result = 0;

        switch (action) {
            case "addition": result = Integer.parseInt(a) + Integer.parseInt(b);
                break;
            case "multiplication": result = Integer.parseInt(a) * Integer.parseInt(b);
                break;
            case "subtraction": result = Integer.parseInt(a) - Integer.parseInt(b);
                break;
            case "division": result = Integer.parseInt(a) / Integer.parseInt(b);
                break;
            default:
                break;
        }

        model.addAttribute("operandA", a);
        model.addAttribute("operandB", b);
        model.addAttribute("operator", action);
        model.addAttribute("result", String.valueOf(result));

        return "first/calculator";
    }

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

//        System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
}
