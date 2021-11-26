package pl.dsuwala.hungrystudent.services;

import org.springframework.stereotype.Service;
import pl.dsuwala.hungrystudent.domain.Ingredient;
import pl.dsuwala.hungrystudent.viewmodels.FridgeItemViewModel;

import java.util.List;

@Service
public interface FridgeService {
    FridgeItemViewModel ingredientToViewModel(Ingredient ingredient);
    List<FridgeItemViewModel> convertIngredientsToViewModel(List<Ingredient> ingredients);
}
