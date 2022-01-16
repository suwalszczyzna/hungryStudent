package pl.dsuwala.hungrystudent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.dsuwala.hungrystudent.domain.Ingredient;
import pl.dsuwala.hungrystudent.domain.Recipe;
import pl.dsuwala.hungrystudent.domain.RecipeIngredient;
import pl.dsuwala.hungrystudent.domain.Unit;
import pl.dsuwala.hungrystudent.repo.RecipeIngredientRepository;
import pl.dsuwala.hungrystudent.repo.RecipeRepository;
import pl.dsuwala.hungrystudent.services.IngredientsServiceImpl;
import pl.dsuwala.hungrystudent.services.RecipeServiceImpl;
import pl.dsuwala.hungrystudent.utils.ViewModelConverter;
import pl.dsuwala.hungrystudent.viewmodels.RecipeViewModel;

import java.util.ArrayList;

@Controller
public class RecipesController {
    private RecipeServiceImpl recipeService;
    private IngredientsServiceImpl ingredientsService;

    public RecipesController(RecipeServiceImpl recipeService, IngredientsServiceImpl ingredientsService) {
        this.recipeService = recipeService;
        this.ingredientsService = ingredientsService;
    }

    @RequestMapping(value="/recipes", method=RequestMethod.GET)
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

    @RequestMapping(value="/recipes/{id}", method=RequestMethod.GET)
    public String recipeDetail(@PathVariable(value = "id") long id, Model model){
        var recipe = recipeService.getRecipeById(id);
        var recipeIngredients = recipeService.getRecipeIngredients(recipe.getId());
        RecipeViewModel recipeViewModel = ViewModelConverter.recipeToVM(recipe, recipeIngredients);

        model.addAttribute("recipe", recipeViewModel);
        return "pages/recipes/recipe-detail";
    }

//    @GetMapping("/recipes/add")
    @RequestMapping(value="/recipes/add", method=RequestMethod.GET)
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("newRecipe", true);
        return "pages/recipes/recipe-form";
    }

    @RequestMapping(value="/recipes/edit/{id}", method=RequestMethod.GET)
    public String editRecipe(@PathVariable(value = "id") long id, Model model) {
        var recipe = recipeService.getRecipeById(id);
        model.addAttribute("recipe", recipe);
        model.addAttribute("newRecipe", false);
        return "pages/recipes/recipe-form";
    }

    @PostMapping("/recipes/save")
    public String saveRecipe(@ModelAttribute Recipe recipe){
        recipeService.save(recipe);
        return "redirect:/recipes";
    }

    @GetMapping("/recipes/delete/{id}")
    public String recipeDelete(@PathVariable(value = "id") long id){
        try{
            recipeService.removeById(id);
            return "redirect:/recipes";
        }catch (IllegalArgumentException e){
            return "redirect:/recipes";
        }
    }

    @RequestMapping(value="/recipes/edit/{id}/ingredients", method=RequestMethod.GET)
    public String recipeIngredientEdit(@PathVariable(value = "id") long recipeId, Model model){
        var recipe = recipeService.getRecipeById(recipeId);
        var recipeIngredients = recipeService.getRecipeIngredients(recipe.getId());
        var allIngredients = ingredientsService.getAll();
        RecipeIngredient newRecipeIngredient = new RecipeIngredient();
        newRecipeIngredient.setRecipe(recipe);

        model.addAttribute("recipeIngredients", recipeIngredients);
        model.addAttribute("newRecipeIngredient", newRecipeIngredient);
        model.addAttribute("allIngredients", allIngredients);

        return "pages/recipes/recipe-ingredients-form";
    }

    @PostMapping("/recipes/edit/{id}/ingredients/save")
    public String saveRecipeIngredients(@PathVariable(value = "id") long recipeId, @ModelAttribute RecipeIngredient recipeIngredient){
        recipeService.addIngredient(recipeId, recipeIngredient);
        return "redirect:/recipes";
    }

    @GetMapping("/recipes/ingredients/delete/{id}")
    public String recipeIngredientDelete(@PathVariable(value = "id") long id){
        var ingredient = recipeService.getRecipeIngredient(id);
        var recipeId = ingredient.getRecipe().getId();
        recipeService.removeIngredient(ingredient);
        return "redirect:/recipes/edit/" + recipeId +"/ingredients";
    }

}
