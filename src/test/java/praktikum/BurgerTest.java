package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;
    @Mock
    Bun bun;

    Burger burger = new Burger();

    @Test
    public void checkingAddIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        int actual = burger.ingredients.size();
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void checkingRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        int actual = burger.ingredients.size();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void checkingGetPriceBurger() {
        Mockito.when(bun.getPrice()).thenReturn(200F);

        Mockito.when(ingredient1.getPrice()).thenReturn(300F);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        float actual = burger.getPrice();
        float expected = 700;
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void checkingGetReceiptBurger() {
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(200F);

        Mockito.when(ingredient1.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn("chili sauce");
        Mockito.when(ingredient1.getPrice()).thenReturn(300F);


        Mockito.when(ingredient2.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient2.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient2.getPrice()).thenReturn(100F);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        String actual = burger.getReceipt();
        String exception = "(==== black bun ====)" + System.lineSeparator() +
                "= sauce chili sauce =" + System.lineSeparator() +
                "= sauce hot sauce =" + System.lineSeparator() +
                "(==== black bun ====)" + System.lineSeparator() +
                System.lineSeparator() +
                "Price: 800,000000" +
                System.lineSeparator();
        assertEquals(exception, actual);
    }

}
