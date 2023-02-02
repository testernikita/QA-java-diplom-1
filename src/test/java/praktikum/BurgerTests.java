package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);

        assertEquals("Булки различаются", bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);

        assertEquals("Количество ингредиентов различается", 1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        assertEquals("Не удалось выполнить удаление ингридиента", 0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90);
        Ingredient filling = new Ingredient(IngredientType.FILLING,"Мясо бессмертных моллюсков Protostomia",1337);

        Burger burger = new Burger();
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(0, 1);

        IngredientType actualIngredientType = burger.ingredients.get(1).type;
        IngredientType expectedIngredientType = sauce.type;

        assertEquals("Ингридиенты не изменились", expectedIngredientType, actualIngredientType);
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(3f);
        Mockito.when(ingredient.getPrice()).thenReturn(2f);

        Burger burger= new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        float actualPrice = burger.getPrice();
        float expectedPrice = 8f;

        assertEquals("Цена различается", expectedPrice, actualPrice, 0);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("Флюоресцентная булка R2-D3");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("Соус традиционный галактический");
        Mockito.when(burger.getPrice()).thenReturn(2000f);

        String actualReceipt = burger.getReceipt();
        String expectedReceipt = "(==== Флюоресцентная булка R2-D3 ====)\n" +
                "= sauce Соус традиционный галактический =\n" +
                "(==== Флюоресцентная булка R2-D3 ====)\n" +
                "\n" +
                "Price: 2000,000000\n";
        assertEquals("Рецепты разные", expectedReceipt, actualReceipt);
    }

}