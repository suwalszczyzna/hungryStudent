package pl.dsuwala.hungrystudent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import pl.dsuwala.hungrystudent.domain.Ingredient;
import pl.dsuwala.hungrystudent.services.FridgeServiceImpl;
import pl.dsuwala.hungrystudent.services.IngredientsServiceImpl;
import pl.dsuwala.hungrystudent.services.UnitServiceImpl;

@Controller
public class FridgeController {

    private IngredientsServiceImpl ingredientsService;
    private FridgeServiceImpl fridgeService;
    private UnitServiceImpl unitService;

    public FridgeController(IngredientsServiceImpl ingredientsService, FridgeServiceImpl fridgeService, UnitServiceImpl unitService) {
        this.ingredientsService = ingredientsService;
        this.fridgeService = fridgeService;
        this.unitService = unitService;
    }

    @GetMapping("/fridge")
    public String showAllItems(Model model){
        var ingredients = fridgeService.convertIngredientsToViewModel(
                ingredientsService.getAll()
        );
        var units = unitService.getAllUnits();
        model.addAttribute("ingredient", new Ingredient());
        model.addAttribute("units", units);
        model.addAttribute("ingredients", ingredients);
        return "pages/fridge";
    }

    @GetMapping("/fridge/newIngredient")
    public String newIngredient(Model model){
        var units = unitService.getAllUnits();
        model.addAttribute("ingredient", new Ingredient());
        model.addAttribute("units", units);
        return "pages/ingredient/ingredientForm";
    }
}
