package coffeemaker.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {
    private Recipe recipe;

    @BeforeEach
    void setUp() {
        recipe = new Recipe();
    }

    @Test
    void getName() {
        assertEquals(recipe.getName(), "");
    }

    @Test
    void setName() {
       recipe.setName("Lavazza");
       assertNotEquals(recipe.getName(), "");
       assertEquals(recipe.getName(), "Lavazza");
    }

    @Test
    void getPrice() {
        assertEquals(recipe.getPrice(), 0);
    }

    @Test
    void setPrice() {
        String price = "8";
        recipe.setPrice(price);
        assertNotEquals(recipe.getPrice(), 0);
        assertEquals(recipe.getPrice(), Integer.parseInt(price));
    }

    @Test
    void getAmtCoffee() {
        assertEquals(recipe.getAmtCoffee(), 0);
    }

    @Test
    void setAmtCoffee() {
        String coffee = "5";
        recipe.setAmtCoffee(coffee);
        assertNotEquals(recipe.getAmtCoffee(), 0);
        assertEquals(recipe.getAmtCoffee(), Integer.parseInt(coffee));
    }

    @Test
    void getAmtMilk() {
        assertEquals(recipe.getAmtMilk(), 0);
    }

    @Test
    void setAmtMilk() {
        String milk = "6";
        recipe.setAmtMilk(milk);
        assertNotEquals(recipe.getAmtMilk(), 0);
        assertEquals(recipe.getAmtMilk(), Integer.parseInt(milk));
    }

    @Test
    void getAmtSugar() {
        assertEquals(recipe.getAmtSugar(), 0);
    }

    @Test
    void setAmtSugar() {
        String sugar = "6";
        recipe.setAmtSugar(sugar);
        assertNotEquals(recipe.getAmtSugar(), 0);
        assertEquals(recipe.getAmtSugar(), Integer.parseInt(sugar));
    }

    @Test
    void getAmtChocolate() {
        assertEquals(recipe.getAmtChocolate(), 0);
    }

    @Test
    void setAmtChocolate() {
        String chocolate = "6";
        recipe.setAmtChocolate(chocolate);
        assertNotEquals(recipe.getAmtChocolate(), 0);
        assertEquals(recipe.getAmtChocolate(), Integer.parseInt(chocolate));
    }

    @Test
    void testToString() {
        recipe.setName("Lavazza");
        String expected = "Recipe{Lavazza}";
        String actual = recipe.toString();
        assertNotEquals("", actual);
        assertNotEquals("Recipe ", actual);
        assertEquals(expected, actual);
    }

    @Test
    void testHashCode() {
        Recipe recipe1 = new Recipe();
        Recipe recipe2 = new Recipe();

        recipe.setName("Latte");
        recipe1.setName("Latte");
        recipe2.setName("Espresso");

        assertEquals(recipe.hashCode(), recipe1.hashCode());
        assertNotEquals(recipe.hashCode(), recipe2.hashCode());
    }

    @Test
    void testEquals() {
        recipe.setName("Lavazza");
        recipe.setAmtSugar("3");
        recipe.setPrice("4");
        recipe.setAmtMilk("2");
        recipe.setAmtChocolate("4");
        recipe.setAmtCoffee("2");

        Recipe sameRecipe = new Recipe();

        sameRecipe.setName("Lavazza");
        sameRecipe.setAmtSugar("3");
        sameRecipe.setPrice("4");
        sameRecipe.setAmtMilk("2");
        sameRecipe.setAmtChocolate("4");
        sameRecipe.setAmtCoffee("2");

        Recipe differentRecipe = new Recipe();

        differentRecipe.setName("Starbucks");
        differentRecipe.setAmtSugar("2");
        differentRecipe.setPrice("1");
        differentRecipe.setAmtMilk("2");
        differentRecipe.setAmtChocolate("4");
        differentRecipe.setAmtCoffee("3");

        assertTrue(recipe.equals(sameRecipe));
        assertFalse(recipe.equals(differentRecipe));

    }

    @Test
    void testRecipeSameName()
    {
        recipe.setName("Lavazza");
        recipe.setAmtSugar("3");
        recipe.setPrice("4");
        recipe.setAmtMilk("2");
        recipe.setAmtChocolate("4");
        recipe.setAmtCoffee("2");

        Recipe sameRecipe = new Recipe();

        sameRecipe.setName("Lavazza");
        sameRecipe.setAmtSugar("3");
        sameRecipe.setPrice("4");
        sameRecipe.setAmtMilk("2");
        sameRecipe.setAmtChocolate("4");
        sameRecipe.setAmtCoffee("3");

        assertFalse(recipe.equals(sameRecipe));
    }
}