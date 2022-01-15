package pl.dsuwala.hungrystudent.viewmodels;

public class RecipeIngredientViewModel {
    public Long id;
    public String name;
    public Double recipeAmount;
    public String unitName;

    public RecipeIngredientViewModel() {
    }

    public RecipeIngredientViewModel(Long id, String name, Double recipeAmount, String unitName) {
        this.id = id;
        this.name = name;
        this.recipeAmount = recipeAmount;
        this.unitName = unitName;
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

    public Double getRecipeAmount() {
        return recipeAmount;
    }

    public void setRecipeAmount(Double recipeAmount) {
        this.recipeAmount = recipeAmount;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
