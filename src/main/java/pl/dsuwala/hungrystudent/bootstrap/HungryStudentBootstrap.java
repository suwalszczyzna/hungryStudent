package pl.dsuwala.hungrystudent.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.dsuwala.hungrystudent.domain.Ingredient;
import pl.dsuwala.hungrystudent.domain.Unit;
import pl.dsuwala.hungrystudent.repo.IngredientRepository;

@Component
public class HungryStudentBootstrap implements CommandLineRunner {

    private IngredientRepository ingredientRepository;

    public HungryStudentBootstrap(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.loadData();
    }

    private void loadData() {
        Ingredient potatoes = new Ingredient(
                "ziemniaki",
                3.5,
                new Unit("kilogramy", "kg")
        );

        Ingredient milk = new Ingredient(
                "mleko",
                4.0,
                new Unit("litry", "l")
        );

        ingredientRepository.save(potatoes);
        ingredientRepository.save(milk);
    }
}
