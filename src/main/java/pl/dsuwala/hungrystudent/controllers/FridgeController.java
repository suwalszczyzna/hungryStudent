package pl.dsuwala.hungrystudent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FridgeController {

    @GetMapping("/fridge")
    public String fridgePage(){
        return "pages/fridge";
    }
}
