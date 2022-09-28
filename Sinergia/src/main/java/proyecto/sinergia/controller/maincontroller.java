package proyecto.sinergia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class maincontroller {
    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping("/main")
    public String main(){
        return "main";
    }
}
