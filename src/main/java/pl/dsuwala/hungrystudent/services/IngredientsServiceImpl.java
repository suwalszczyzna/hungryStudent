package pl.dsuwala.hungrystudent.services;

import org.springframework.stereotype.Service;
import pl.dsuwala.hungrystudent.domain.Ingredient;
import pl.dsuwala.hungrystudent.repo.IngredientRepository;

import java.util.List;

@Service
public class IngredientsServiceImpl implements IngredientsService{

    private IngredientRepository ingredientRepository;

    public IngredientsServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> getAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public void saveIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient getById(Long id) {
        return ingredientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Brak produktu o id: " + id));
    }

    @Override
    public void reduceAmount(Ingredient ingredient, Double amountToReduce) {
        var actualAmount = ingredient.getAmount();
        ingredient.setAmount(actualAmount - amountToReduce);
        ingredientRepository.save(ingredient);
    }
}
