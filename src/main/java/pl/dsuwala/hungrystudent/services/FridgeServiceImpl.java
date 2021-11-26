package pl.dsuwala.hungrystudent.services;

import org.springframework.stereotype.Service;
import pl.dsuwala.hungrystudent.domain.Ingredient;
import pl.dsuwala.hungrystudent.domain.Unit;
import pl.dsuwala.hungrystudent.viewmodels.FridgeItemViewModel;

import java.util.ArrayList;
import java.util.List;


@Service
public class FridgeServiceImpl implements FridgeService{
    @Override
    public FridgeItemViewModel ingredientToViewModel(Ingredient ingredient) {
        Unit unit = ingredient.getUnit();

        return new FridgeItemViewModel(
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getAmount(),
                unit.getShortcutName()
        );
    }

    @Override
    public List<FridgeItemViewModel> convertIngredientsToViewModel(List<Ingredient> ingredients) {
        List<FridgeItemViewModel> items = new ArrayList<>();
        for (var ingredient :
                ingredients) {
            items.add(this.ingredientToViewModel(ingredient));
        }
        return items;
    }
}
