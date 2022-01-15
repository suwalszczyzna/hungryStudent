package pl.dsuwala.hungrystudent.services;

import org.springframework.stereotype.Service;
import pl.dsuwala.hungrystudent.domain.Ingredient;
import pl.dsuwala.hungrystudent.domain.Recipe;
import pl.dsuwala.hungrystudent.domain.RecipeIngredient;
import pl.dsuwala.hungrystudent.repo.RecipeIngredientRepository;
import pl.dsuwala.hungrystudent.repo.RecipeRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService{

    private RecipeRepository recipeRepository;
    private RecipeIngredientRepository recipeIngredientRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeIngredientRepository recipeIngredientRepository) {
        this.recipeRepository = recipeRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
    }

    @Override
    public List<Recipe> getAll() {
        return recipeRepository.findAll();
    }

    @Override
    public void save(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    @Override
    public Recipe getRecipeById(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isPresent()){
            return recipe.get();
        }
        else{
            throw new RuntimeException("Nie ma przepisu o podanym id");
        }
    }

    @Override
    public void addIngredient(Long recipeId, RecipeIngredient recipeIngredient) {
        Recipe recipe = getRecipeById(recipeId);
        recipeIngredient.setRecipe(recipe);
        recipeIngredientRepository.save(recipeIngredient);
    }

    @Override
    public List<RecipeIngredient> getRecipeIngredients(Long recipeId) {
        return recipeIngredientRepository.findAll(recipeId);
    }

    @Override
    public List<Ingredient> getIngredients(Long recipeId) {
        return recipeIngredientRepository.findAllIngredients(recipeId);
    }
}
