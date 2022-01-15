package pl.dsuwala.hungrystudent.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dsuwala.hungrystudent.domain.RecipeIngredient;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {
}
