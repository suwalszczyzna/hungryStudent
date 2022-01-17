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
import pl.dsuwala.hungrystudent.services.RecipeService;
import pl.dsuwala.hungrystudent.services.RecipeServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Component
public class HungryStudentBootstrap implements CommandLineRunner {

    private IngredientRepository ingredientRepository;
    private RecipeRepository recipeRepository;
    private RecipeIngredientRepository recipeIngredientRepository;
    private RecipeServiceImpl recipeService;

    public HungryStudentBootstrap(IngredientRepository ingredientRepository, RecipeRepository recipeRepository, RecipeIngredientRepository recipeIngredientRepository, RecipeServiceImpl recipeService) {
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.recipeService = recipeService;
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
                1.5
        );

        List<RecipeIngredient> pizzaIngredients = new ArrayList<>();
        pizzaIngredients.add(woda);
        pizzaIngredients.add(maka);
        Recipe pizza = new Recipe(
                "Super pizza domowa",
                " <ul><li>Świeże drożdże ocieplić w temperaturze pokojowej. Przygotować <strong>rozczyn</strong>: drożdże rozpuścić w ciepłej wodzie, dodać 2 łyżki mąki oraz cukier, dokładnie wymieszać i odstawić na ok. 10 minut do wyrośnięcia (rozczyn ze świeżych drożdży zwiększa objętość o ok. 3 razy - jeśli tak się nie stanie proces przygotowania rozczynu trzeba powtórzyć od nowa, natomiast rozczyn z drożdży instant może się tylko trochę spienić).</li><li>Mąkę przesiać do miski, wymieszać z solą, zrobić wgłębienie w środku i wlać w nie rozczyn. Sukcesywnie zagarniać łyżką mąkę do środka i przez 2 - 3 minuty mieszać składniki, pod koniec dodając jeszcze oliwę.</li><li>Połączone składniki wyłożyć na stolnicę oprószoną mąką. Wyrabiać przez ok. <strong>15 minut</strong> aż ciasto będzie elastyczne i gładkie (ciasto można też zagnieść mikserem planetarnym).</li><li>Wyrobione ciasto włożyć do dużej miski, przykryć ściereczką i odstawić na ok. <strong>1 godzinę</strong> do wyrośnięcia.</li><li>Wyrośnięte ciasto wyjąć na stolnicę i chwilę pozagniatać. Podzielić na 2 części, uformować z nich kulki i odłożyć na ok. 7 minut pod ściereczką.</li><li>Blaszki (tortownice) posmarować oliwą. Włożyć na środek kulkę ciasta, delikatnie <strong>spłaszczyć i rozciągać, rozprowadzając palcami</strong> po całej powierzchni dna, zaczynając od środka i zostawiając niewielki \"wałeczek\" na brzegu (zob. zdjęcia poniżej). UWAGA: najlepiej robić to kilkoma etapami, ciasto na początku sprężynuje i \"cofa się\" ale jeśli odczekamy chwilę będziemy mogli je dalej rozciągać.</li><li>Wyłożyć cienką warstwę <a href=\"https://www.kwestiasmaku.com/przepis/sos-pomidorowy-na-pizze\">sosu pomidorowego</a>, ser* oraz ulubione dodatki. Odczekać ok. 15 minut aż ciasto podrośnie, następnie piec w maksymalnie nagrzanym piekarniku <strong>(min. 250 st. C) przez ok. 10 minut.</strong></li></ul>",
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
