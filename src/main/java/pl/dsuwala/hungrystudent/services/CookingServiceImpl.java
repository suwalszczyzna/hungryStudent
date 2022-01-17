package pl.dsuwala.hungrystudent.services;

import org.springframework.stereotype.Service;
import pl.dsuwala.hungrystudent.domain.Recipe;
import pl.dsuwala.hungrystudent.domain.RecipeIngredient;
import pl.dsuwala.hungrystudent.utils.ViewModelConverter;
import pl.dsuwala.hungrystudent.viewmodels.RecipeViewModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class CookingServiceImpl implements CookingService {
    private RecipeServiceImpl recipeService;
    private IngredientsServiceImpl ingredientsService;

    CookingServiceImpl(RecipeServiceImpl recipeService, IngredientsServiceImpl ingredientsService) {
        this.recipeService = recipeService;
        this.ingredientsService = ingredientsService;
    }

    @Override
    public boolean haveEnoughProductsToCook(Recipe recipe) {
        List<RecipeIngredient> recipeIngredients = recipeService.getRecipeIngredients(recipe.getId());
        for (var recipeIngredient :
                recipeIngredients) {
            var fridgeIngredient = ingredientsService.getById(recipeIngredient.getIngredient().getId());
            if (fridgeIngredient.getAmount() < recipeIngredient.getRecipeAmount()){
                return false;
            }
        }
        return true;
    }

    @Override
    public void cook(Recipe recipe) {
        assert this.haveEnoughProductsToCook(recipe);

        List<RecipeIngredient> recipeIngredients = recipeService.getRecipeIngredients(recipe.getId());

        for (var recipeIngredient :
                recipeIngredients) {
            ingredientsService.reduceAmount(recipeIngredient.getIngredient(), recipeIngredient.getRecipeAmount());
        }
    }


}
