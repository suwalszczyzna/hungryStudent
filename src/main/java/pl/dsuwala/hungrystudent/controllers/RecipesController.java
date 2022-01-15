package pl.dsuwala.hungrystudent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.dsuwala.hungrystudent.domain.Recipe;
import pl.dsuwala.hungrystudent.domain.Unit;
import pl.dsuwala.hungrystudent.repo.RecipeIngredientRepository;
import pl.dsuwala.hungrystudent.repo.RecipeRepository;
import pl.dsuwala.hungrystudent.services.RecipeServiceImpl;
import pl.dsuwala.hungrystudent.utils.ViewModelConverter;
import pl.dsuwala.hungrystudent.viewmodels.RecipeViewModel;

import java.util.ArrayList;

@Controller
public class RecipesController {
    private RecipeServiceImpl recipeService;

    public RecipesController(RecipeServiceImpl recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipes")
    public String showAllRecipes(Model model){
        var recipesVM = new ArrayList<RecipeViewModel>();
        var recipes = recipeService.getAll();
        for (var i: recipes){
            var ingredients = recipeService.getRecipeIngredients(i.getId());
            var recipeVM = ViewModelConverter.recipeToVM(i, ingredients);

            recipesVM.add(recipeVM);
            recipesVM.add(recipeVM);
            recipesVM.add(recipeVM);
            recipesVM.add(recipeVM);
            recipesVM.add(recipeVM);
            recipesVM.add(recipeVM);
        }

        model.addAttribute("recipes", recipesVM);
        return "pages/recipes/recipes";
    }

    @GetMapping("/recipes/{id}")
    public String recipeDetail(@PathVariable(value = "id") long id, Model model){
        var recipe = recipeService.getRecipeById(id);
        var recipeIngredients = recipeService.getRecipeIngredients(recipe.getId());
        RecipeViewModel recipeViewModel = ViewModelConverter.recipeToVM(recipe, recipeIngredients);

        model.addAttribute("recipe", recipeViewModel);
        return "pages/recipes/recipe-detail";
    }


}
