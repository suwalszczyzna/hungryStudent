package pl.dsuwala.hungrystudent.services;

import pl.dsuwala.hungrystudent.domain.Recipe;

public interface CookingService {
    boolean haveEnoughProductsToCook(Recipe recipe);

    void cook(Recipe recipe);
}
