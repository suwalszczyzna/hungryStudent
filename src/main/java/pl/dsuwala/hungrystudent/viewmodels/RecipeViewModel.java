package pl.dsuwala.hungrystudent.viewmodels;

import java.util.List;

public class RecipeViewModel {
    public Long id;
    public String name;
    public String description;
    public List<RecipeIngredientViewModel> ingredients;
    public int timeConsuming;

    public RecipeViewModel() {
    }

    public RecipeViewModel(Long id, String name, String description, List<RecipeIngredientViewModel> ingredients, int timeConsuming) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.timeConsuming = timeConsuming;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<RecipeIngredientViewModel> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeIngredientViewModel> ingredients) {
        this.ingredients = ingredients;
    }

    public int getTimeConsuming() {
        return timeConsuming;
    }

    public void setTimeConsuming(int timeConsuming) {
        this.timeConsuming = timeConsuming;
    }
}
