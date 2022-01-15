package pl.dsuwala.hungrystudent.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "recipe")
    private List<RecipeIngredient> ingredients;

    private int timeConsuming;

    public Recipe() {
    }

    public Recipe(String name, String description, List<RecipeIngredient> ingredients) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
    }

    public Recipe(String name, String description, List<RecipeIngredient> ingredients, int timeConsuming) {
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

    public List<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public int getTimeConsuming() {
        return timeConsuming;
    }

    public void setTimeConsuming(int timeConsuming) {
        this.timeConsuming = timeConsuming;
    }
}
