package pl.dsuwala.hungrystudent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import pl.dsuwala.hungrystudent.services.FridgeServiceImpl;
import pl.dsuwala.hungrystudent.services.IngredientsServiceImpl;

@Controller
public class FridgeController {

    private IngredientsServiceImpl ingredientsService;
    private FridgeServiceImpl fridgeService;

    public FridgeController(IngredientsServiceImpl ingredientsService, FridgeServiceImpl fridgeService) {
        this.ingredientsService = ingredientsService;
        this.fridgeService = fridgeService;
    }

    @GetMapping("/fridge")
    public String showAllItems(Model model){
        var ingredients = fridgeService.convertIngredientsToViewModel(
                ingredientsService.getAll()
        );

        model.addAttribute("ingredients", ingredients);
        return "pages/fridge";
    }
}
