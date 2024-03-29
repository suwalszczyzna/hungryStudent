package pl.dsuwala.hungrystudent.services;

import pl.dsuwala.hungrystudent.domain.Ingredient;

import java.util.List;

public interface IngredientsService {
    List<Ingredient> getAll();
    void saveIngredient(Ingredient ingredient);
    Ingredient getById(Long id);
    void reduceAmount(Ingredient ingredient, Double amount);
}
