package pl.dsuwala.hungrystudent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.dsuwala.hungrystudent.domain.Recipe;
import pl.dsuwala.hungrystudent.services.CookingServiceImpl;
import pl.dsuwala.hungrystudent.services.RecipeServiceImpl;
import pl.dsuwala.hungrystudent.utils.ViewModelConverter;
import pl.dsuwala.hungrystudent.viewmodels.RecipeViewModel;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CookingController {
    private CookingServiceImpl cookingService;
    private RecipeServiceImpl recipeService;

    CookingController(CookingServiceImpl cookingService, RecipeServiceImpl recipeService) {
        this.cookingService = cookingService;
        this.recipeService = recipeService;
    }

    @GetMapping("/cooking")
    public String recipesCanBeCooked(Model model){
        var recipes = recipeService.getAll();
        List<Recipe> recipeCanBeCooked = new ArrayList<>();
        for (var recipe :
                recipes) {
            if (cookingService.haveEnoughProductsToCook(recipe)) {
                recipeCanBeCooked.add(recipe);
            }
        }

        var recipesVM = this.recipesToVM(recipeCanBeCooked);
        model.addAttribute("recipes", recipesVM);
        return "/pages/cooking/cooking";
    }

    @GetMapping("/cooking/{id}")
    public String cookConfirm(@PathVariable(value = "id") Long id, Model model) {
        var recipe = recipeService.getRecipeById(id);
        var recipeIngredients = recipeService.getRecipeIngredients(recipe.getId());
        RecipeViewModel recipeViewModel = ViewModelConverter.recipeToVM(recipe, recipeIngredients);

        model.addAttribute("recipe", recipeViewModel);
        return "/pages/cooking/cooking-confirm";
    }

    @GetMapping("/cooking/{id}/cook")
    public String cook(@PathVariable(value = "id") Long id){
        var recipe = recipeService.getRecipeById(id);
        cookingService.cook(recipe);

        return "redirect:/cooking/";
    }

    private ArrayList<RecipeViewModel> recipesToVM(List<Recipe> recipes) {
        var recipesVM = new ArrayList<RecipeViewModel>();
        for (var i: recipes){
            var ingredients = recipeService.getRecipeIngredients(i.getId());
            var recipeVM = ViewModelConverter.recipeToVM(i, ingredients);

            recipesVM.add(recipeVM);
        }
        return recipesVM;
    }

}
