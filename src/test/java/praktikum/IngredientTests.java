package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTests {

    private Ingredient ingredient;

    @Before
    public void createBun() {
        ingredient = new Ingredient(IngredientType.SAUCE,"Соус с шипами Антарианского плоскоходца", 88);
    }

    @Test
    public void getPriceOfIngredient() {
        float actualIngredientPrice = ingredient.getPrice();
        float expectedIngredientPrice = 88;

        assertEquals("Стоимость ингредиента не совпадает с ожидаемой", expectedIngredientPrice, actualIngredientPrice, 0);
    }

    @Test
    public void getNameOfIngredient() {
        String actualIngredientName = ingredient.getName();
        String expectedIngredientName = "Соус с шипами Антарианского плоскоходца";

        assertEquals("Имя ингредиента не совпадает с ожидаемым", expectedIngredientName, actualIngredientName);
    }

    @Test
    public void getTypeOfIngredient() {
        IngredientType actualIngredientType = ingredient.getType();
        IngredientType expectedIngredientType = IngredientType.SAUCE;

        assertEquals("Тип ингредиента не совпадает с ожидаемым", expectedIngredientType, actualIngredientType);
    }

}