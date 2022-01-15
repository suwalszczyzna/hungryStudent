package pl.dsuwala.hungrystudent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.dsuwala.hungrystudent.domain.Ingredient;
import pl.dsuwala.hungrystudent.services.IngredientsServiceImpl;

@Controller
public class IngredientsController {

    private IngredientsServiceImpl ingredientsService;

    public IngredientsController(IngredientsServiceImpl ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @PostMapping("/ingredients/save")
    public String save(@ModelAttribute Ingredient ingredient){
        ingredientsService.saveIngredient(ingredient);
        return "redirect:/fridge";
    }
}
