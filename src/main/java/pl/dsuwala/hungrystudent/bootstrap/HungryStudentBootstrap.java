package pl.dsuwala.hungrystudent.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.dsuwala.hungrystudent.domain.Ingredient;
import pl.dsuwala.hungrystudent.domain.Recipe;
import pl.dsuwala.hungrystudent.domain.RecipeIngredient;
import pl.dsuwala.hungrystudent.domain.Unit;
import pl.dsuwala.hungrystudent.repo.IngredientRepository;
import pl.dsuwala.hungrystudent.repo.RecipeIngredientRepository;
import pl.dsuwala.hungrystudent.repo.RecipeRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class HungryStudentBootstrap implements CommandLineRunner {

    private IngredientRepository ingredientRepository;
    private RecipeRepository recipeRepository;
    private RecipeIngredientRepository recipeIngredientRepository;

    public HungryStudentBootstrap(IngredientRepository ingredientRepository, RecipeRepository recipeRepository, RecipeIngredientRepository recipeIngredientRepository) {
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.loadData();
    }

    private void loadData() {
        Unit kg = new Unit("kilogramy", "kg");
        Ingredient potatoes = new Ingredient(
                "ziemniaki",
                3.5,
                kg
        );

        Unit litres = new Unit("litry", "l");
        Ingredient milk = new Ingredient(
                "mleko",
                4.0,
                litres
        );

        ingredientRepository.save(potatoes);
        ingredientRepository.save(milk);


        Unit ml = new Unit("mililitry", "ml");
        Unit szklanka = new Unit("szklanki", "szklanka");

        RecipeIngredient woda = new RecipeIngredient(
                new Ingredient("Woda", 500.0, ml),
                150.0
        );
        RecipeIngredient maka = new RecipeIngredient(
                new Ingredient("Mąka", 4.0, szklanka),
                1.0
        );

        List<RecipeIngredient> pizzaIngredients = new ArrayList<>();
        pizzaIngredients.add(woda);
        pizzaIngredients.add(maka);
        Recipe pizza = new Recipe(
                "Super pizza domowa",
                "Mąkę przesiać do miski, wymieszać z solą, zrobić wgłębienie w środku i wlać w nie rozczyn. Sukcesywnie zagarniać łyżką mąkę do środka i przez 2 - 3 minuty mieszać składniki, pod koniec dodając jeszcze oliwę.",
                pizzaIngredients,
                107
        );

        recipeRepository.save(pizza);
        woda.setRecipe(pizza);
        maka.setRecipe(pizza);
        recipeIngredientRepository.save(woda);
        recipeIngredientRepository.save(maka);

    }
}
