package coffeemaker.domain;

import coffeemaker.exceptions.RecipeException;
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
    void setNameNull()
    {
        Recipe newRecipe = new Recipe();
        newRecipe.setName("Lavazza");
        newRecipe.setName(null);
        assertEquals(newRecipe.getName(), "Lavazza");
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
    void setPriceException()
    {
        String price = "fail9";
        assertThrows(RecipeException.class, () -> {recipe.setPrice(price);});
    }

    @Test
    void setPriceNegative()
    {
        String price = "-1";
        assertThrows(RecipeException.class, () -> {recipe.setPrice(price);});
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
    void setAmtCoffeeException()
    {
        String coffee = "fail9";
        assertThrows(RecipeException.class, () -> {recipe.setAmtCoffee(coffee);});
    }

    @Test
    void setAmtCoffeeNegative()
    {
        String coffee = "-1";
        assertThrows(RecipeException.class, () -> {recipe.setAmtCoffee(coffee);});
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
    void setAmtMilkException()
    {
        String milk = "fail9";
        assertThrows(RecipeException.class, () -> {recipe.setAmtMilk(milk);});
    }

    @Test
    void setAmtMilkNegative()
    {
        String milk = "-1";
        assertThrows(RecipeException.class, () -> {recipe.setAmtMilk(milk);});
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
    void setAmtSugarException()
    {
        String sugar = "fail9";
        assertThrows(RecipeException.class, () -> {recipe.setAmtSugar(sugar);});
    }

    @Test
    void setAmtSugarNegative()
    {
        String sugar = "-1";
        assertThrows(RecipeException.class, () -> {recipe.setAmtSugar(sugar);});
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
    void setAmtChocolateException()
    {
        String chocolate = "fail9";
        assertThrows(RecipeException.class, () -> {recipe.setAmtChocolate(chocolate);});
    }

    @Test
    void setAmtChocolateNegative()
    {
        String chocolate = "-1";
        assertThrows(RecipeException.class, () -> {recipe.setAmtChocolate(chocolate);});
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
    void testHashCodeEqual() {
        Recipe recipe1 = new Recipe();
        recipe.setName("Latte");
        recipe1.setName("Latte");
        assertEquals(recipe.hashCode(), recipe1.hashCode());
    }

    @Test
    void testHashCodeNotEqual()
    {
        Recipe recipe2 = new Recipe();
        recipe.setName("Latte");
        recipe2.setName("Espresso");
        assertNotEquals(recipe.hashCode(), recipe2.hashCode());
    }

    @Test
    void testHashCodeNull()
    {
        Recipe recipe2 = new Recipe();
        recipe.setName("Latte");
        recipe2.setName("Latte");
        recipe2.setName(null);
        assertEquals(recipe.hashCode(), recipe2.hashCode());
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

        assertTrue(recipe.equals(sameRecipe));
    }

    @Test
    void testNotEquals()
    {
        recipe.setName("Lavazza");
        recipe.setAmtSugar("3");
        recipe.setPrice("4");
        recipe.setAmtMilk("2");
        recipe.setAmtChocolate("4");
        recipe.setAmtCoffee("2");

        Recipe differentRecipe = new Recipe();
        differentRecipe.setName("Starbucks");
        differentRecipe.setAmtSugar("2");
        differentRecipe.setPrice("1");
        differentRecipe.setAmtMilk("2");
        differentRecipe.setAmtChocolate("4");
        differentRecipe.setAmtCoffee("3");

        assertFalse(recipe.equals(differentRecipe));
    }

    @Test
    void testRecipeDiffCoffee()
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

    @Test
    void testRecipeSameObj()
    {
        recipe.setName("Starbucks");
        recipe.setAmtSugar("3");
        recipe.setPrice("4");
        recipe.setAmtMilk("2");
        recipe.setAmtChocolate("4");
        recipe.setAmtCoffee("2");

        assertTrue(recipe.equals(recipe));
    }

    @Test
    void testRecipeDiffSugar()
    {
        recipe.setName("Lavazza");
        recipe.setAmtSugar("3");
        recipe.setPrice("4");
        recipe.setAmtMilk("2");
        recipe.setAmtChocolate("4");
        recipe.setAmtCoffee("2");

        Recipe sameRecipe = new Recipe();

        sameRecipe.setName("Lavazza");
        sameRecipe.setAmtSugar("1");
        sameRecipe.setPrice("4");
        sameRecipe.setAmtMilk("2");
        sameRecipe.setAmtChocolate("4");
        sameRecipe.setAmtCoffee("2");

        assertFalse(recipe.equals(sameRecipe));
    }

    @Test
    void testRecipeDiffChocolate()
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
        sameRecipe.setAmtChocolate("1");
        sameRecipe.setAmtCoffee("2");

        assertFalse(recipe.equals(sameRecipe));
    }

    @Test
    void testRecipeDiffMilk()
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
        sameRecipe.setAmtMilk("1");
        sameRecipe.setAmtChocolate("4");
        sameRecipe.setAmtCoffee("2");

        assertFalse(recipe.equals(sameRecipe));
    }

    @Test
    void testRecipeObject()
    {
        recipe.setName("Lavazza");
        recipe.setAmtSugar("3");
        recipe.setPrice("4");
        recipe.setAmtMilk("2");
        recipe.setAmtChocolate("4");
        recipe.setAmtCoffee("2");

        Object sameRecipe = new Object();

        assertFalse(recipe.equals(sameRecipe));
    }

    @Test
    void testRecipeEqualNull()
    {
        recipe.setName("Lavazza");
        recipe.setAmtSugar("3");
        recipe.setPrice("4");
        recipe.setAmtMilk("2");
        recipe.setAmtChocolate("4");
        recipe.setAmtCoffee("2");

        Recipe diffRecipe = new Recipe();
        diffRecipe.setAmtSugar("3");
        diffRecipe.setPrice("4");
        diffRecipe.setAmtMilk("2");
        diffRecipe.setAmtChocolate("4");
        diffRecipe.setAmtCoffee("2");
        diffRecipe.setName("Lavazza");
        diffRecipe.setName(null);

        assertTrue(recipe.equals(diffRecipe));
    }
}