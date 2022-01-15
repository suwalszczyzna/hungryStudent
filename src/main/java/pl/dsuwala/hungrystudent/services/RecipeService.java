package pl.dsuwala.hungrystudent.services;

import pl.dsuwala.hungrystudent.domain.Ingredient;
import pl.dsuwala.hungrystudent.domain.Recipe;
import pl.dsuwala.hungrystudent.domain.RecipeIngredient;
import pl.dsuwala.hungrystudent.viewmodels.RecipeViewModel;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAll();
    void save(Recipe recipe);
    Recipe getRecipeById(Long id);
    void addIngredient(Long recipeId, RecipeIngredient recipeIngredient);
    List<RecipeIngredient> getRecipeIngredients(Long recipeId);
    List<Ingredient> getIngredients(Long recipeId);
}
