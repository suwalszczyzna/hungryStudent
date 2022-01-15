package pl.dsuwala.hungrystudent.utils;

import pl.dsuwala.hungrystudent.domain.Ingredient;
import pl.dsuwala.hungrystudent.domain.Recipe;
import pl.dsuwala.hungrystudent.domain.RecipeIngredient;
import pl.dsuwala.hungrystudent.domain.Unit;
import pl.dsuwala.hungrystudent.viewmodels.FridgeItemViewModel;
import pl.dsuwala.hungrystudent.viewmodels.RecipeIngredientViewModel;
import pl.dsuwala.hungrystudent.viewmodels.RecipeViewModel;

import java.util.ArrayList;
import java.util.List;

public class ViewModelConverter {

    public static FridgeItemViewModel ingredientToFridgeVM(Ingredient ingredient) {
        Unit unit = ingredient.getUnit();

        return new FridgeItemViewModel(
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getAmount(),
                unit.getShortcutName()
        );
    }

    public static List<FridgeItemViewModel> ingredientsToFridgeVM(List<Ingredient> ingredients) {
        List<FridgeItemViewModel> items = new ArrayList<>();
        for (var ingredient :
                ingredients) {
            items.add(ViewModelConverter.ingredientToFridgeVM(ingredient));
        }
        return items;
    }

    public static RecipeIngredientViewModel recipeIngredientToVM(RecipeIngredient recipeIngredient) {
        Ingredient ingredient = recipeIngredient.getIngredient();
        Unit unit = ingredient.getUnit();

        return new RecipeIngredientViewModel(
                recipeIngredient.getId(),
                ingredient.getName(),
                recipeIngredient.getRecipeAmount(),
                unit.getShortcutName()
        );
    }

    public static List<RecipeIngredientViewModel> recipeIngredientsToVM(List<RecipeIngredient> recipeIngredients){
        List<RecipeIngredientViewModel> items = new ArrayList<>();

        for (var i :
                recipeIngredients) {
            items.add(ViewModelConverter.recipeIngredientToVM(i));
        }

        return items;
    }

    public static RecipeViewModel recipeToVM(Recipe recipe, List<RecipeIngredient> ingredients){
        var recIngredientsVM = ViewModelConverter.recipeIngredientsToVM(ingredients);
        return new RecipeViewModel(
                recipe.getId(),
                recipe.getName(),
                recipe.getDescription(),
                recIngredientsVM,
                recipe.getTimeConsuming()
        );
    }
}
