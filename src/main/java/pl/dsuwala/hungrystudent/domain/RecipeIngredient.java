package pl.dsuwala.hungrystudent.domain;

import javax.persistence.*;

@Entity
public class RecipeIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    private Double recipeAmount;

    @ManyToOne
    private Recipe recipe;


    public RecipeIngredient() {
    }

    public RecipeIngredient(Ingredient ingredient, Double recipeAmount) {
        this.ingredient = ingredient;
        this.recipeAmount = recipeAmount;
    }

    public RecipeIngredient(Ingredient ingredient, Double recipeAmount, Recipe recipe) {
        this.ingredient = ingredient;
        this.recipeAmount = recipeAmount;
        this.recipe = recipe;
    }

    public RecipeIngredient(Long id, Ingredient ingredient, Double recipeAmount, Recipe recipe) {
        this.id = id;
        this.ingredient = ingredient;
        this.recipeAmount = recipeAmount;
        this.recipe = recipe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Double getRecipeAmount() {
        return recipeAmount;
    }

    public void setRecipeAmount(Double recipeAmount) {
        this.recipeAmount = recipeAmount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
