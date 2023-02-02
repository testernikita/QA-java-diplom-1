package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private final IngredientType expectedIngredientTypeValue;


    public IngredientParameterizedTest(IngredientType type, String name, float price, IngredientType expectedIngredientTypeValue) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.expectedIngredientTypeValue = expectedIngredientTypeValue;
    }

    @Parameterized.Parameters
    public static Object[][] getType() {
        return new Object[][] {
                {IngredientType.SAUCE, "Соус Spicy-X", 90, IngredientType.SAUCE},
                {IngredientType.SAUCE, "Соус фирменный Space Sauce", 80, IngredientType.SAUCE},
                {IngredientType.SAUCE, "Соус традиционный галактический", 15, IngredientType.SAUCE},
                {IngredientType.SAUCE, "Соус с шипами Антарианского плоскоходца", 88, IngredientType.SAUCE},

                {IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337, IngredientType.FILLING},
                {IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000, IngredientType.FILLING},
                {IngredientType.FILLING, "Биокотлета из марсианской Магнолии", 424, IngredientType.FILLING},
                {IngredientType.FILLING, "Филе Люминесцентного тетраодонтимформа", 988, IngredientType.FILLING},
                {IngredientType.FILLING, "ГХрустящие минеральные кольца", 300, IngredientType.FILLING},
                {IngredientType.FILLING, "Плоды Фалленианского дерева", 874, IngredientType.FILLING},
                {IngredientType.FILLING, "Кристаллы марсианских альфа-сахаридов", 762, IngredientType.FILLING},
                {IngredientType.FILLING, "Мини-салат Экзо-Плантаго", 4400, IngredientType.FILLING},
                {IngredientType.FILLING, "Сыр с астероидной плесенью", 4142, IngredientType.FILLING},
        };
    }

    @Test
    public void getTypeIngredientTest() {
        Ingredient ingredient = new Ingredient(type, name, price);

        assertEquals("Возвращается не тот тип ингредиента", expectedIngredientTypeValue, ingredient.getType());
    }

}
