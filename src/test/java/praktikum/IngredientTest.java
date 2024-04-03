package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    Ingredient ingredient = new Ingredient(IngredientType.FILLING, "sour cream", 555F);

    @Test
    public void checkingGetIngredientName() {
        String actual = ingredient.getName();
        String expected = "sour cream";
        assertEquals(expected, actual);
    }

    @Test
    public void checkingGetIngredientPrice() {
        float actual = ingredient.getPrice();
        float expected = 555F;
        assertEquals(expected, actual, 0.0001);
    }
}
