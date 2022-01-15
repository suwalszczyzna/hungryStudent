package pl.dsuwala.hungrystudent.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.dsuwala.hungrystudent.domain.Ingredient;
import pl.dsuwala.hungrystudent.domain.RecipeIngredient;

import java.util.List;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {

    @Query("SELECT t FROM RecipeIngredient t WHERE t.recipe.id = ?1")
    List<RecipeIngredient> findAll(Long recipeId);

    @Query("SELECT t.ingredient FROM RecipeIngredient t WHERE t.recipe.id = ?1")
    List<Ingredient> findAllIngredients(Long recipeId);
}
