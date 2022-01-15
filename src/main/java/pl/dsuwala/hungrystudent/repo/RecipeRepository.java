package pl.dsuwala.hungrystudent.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dsuwala.hungrystudent.domain.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
