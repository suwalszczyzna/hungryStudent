package pl.dsuwala.hungrystudent.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dsuwala.hungrystudent.domain.Ingredient;

import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Optional<Ingredient> findByName(String name);
}
