package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckGetTypeIngredientsTest {
    final private IngredientType type;
    final private IngredientType expected;

    public CheckGetTypeIngredientsTest(IngredientType type, IngredientType expected) {
        this.type = type;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] compareTheResultingIngredientType() {
        return new Object[][]{{IngredientType.SAUCE, IngredientType.SAUCE}, {IngredientType.FILLING, IngredientType.FILLING},};
    }

    @Test
    public void checkGetTypeIngredients() {
        Ingredient ingredient = new Ingredient(type, "test", 556F);
        IngredientType actual = ingredient.getType();
        assertEquals(expected, actual);
    }
}
