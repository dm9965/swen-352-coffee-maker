package coffeemaker.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeBookTest {

    @Test
    void getRecipes() {
        RecipeBook recipeBook = new RecipeBook();
        assertAll(
                () -> assertNotNull(recipeBook.getRecipes()),
                () -> assertEquals(recipeBook.getRecipes().length, 4),
                () -> assertNull(recipeBook.getRecipes()[0])
        );
    }

    @Test
    void addRecipe() {
        RecipeBook recipeBook = new RecipeBook();
        Recipe recipe = new Recipe();
        recipe.setName("Test");
        assertAll(
                () -> assertTrue(recipeBook.addRecipe(recipe)),
                () -> assertEquals(recipeBook.getRecipes()[0].getName(), "Test")
        );
    }

    @Test
    void testAddRecipeOrder() {
        RecipeBook recipeBook = new RecipeBook();
        for(int i = 0; i < recipeBook.getRecipes().length; i++)
        {
            Recipe recipe = new Recipe();
            recipe.setName("Test" + i);
            recipeBook.addRecipe(recipe);
        }
        assertAll(
                () -> assertEquals(recipeBook.getRecipes()[0].getName(),"Test0"),
                () -> assertEquals(recipeBook.getRecipes()[1].getName(),"Test1"),
                () -> assertEquals(recipeBook.getRecipes()[2].getName(),"Test2"),
                () -> assertEquals(recipeBook.getRecipes()[3].getName(),"Test3")
        );
    }

    @Test
    void addRecipeDuplicate() {
        RecipeBook recipeBook = new RecipeBook();
        Recipe recipe = new Recipe();
        recipe.setName("Test");
        Recipe duplicate = new Recipe();
        duplicate.setName("Test");
        recipeBook.addRecipe(recipe);
        assert(!recipeBook.addRecipe(duplicate));
    }

    @Test
    void addRecipeFull() {
        RecipeBook recipeBook = new RecipeBook();
        for(int i = 0; i < recipeBook.getRecipes().length; i++)
        {
            Recipe recipe = new Recipe();
            recipe.setName("Test" + i);
            recipeBook.addRecipe(recipe);
        }
        assertFalse(recipeBook.addRecipe(new Recipe()));
    }

    @Test
    void deleteRecipe() {
        RecipeBook recipeBook = new RecipeBook();
        Recipe recipe = new Recipe();
        recipe.setName("Test");
        recipeBook.addRecipe(recipe);
        assertEquals(recipeBook.deleteRecipe(0), "Test");
    }

    @Test
    void testDeleteRecipeNull()
    {
        RecipeBook recipeBook = new RecipeBook();
        assertNull(recipeBook.deleteRecipe(0));
    }

    @Test
    void DeleteRecipeFull() {
        RecipeBook recipeBook = new RecipeBook();
        for(int i = 0; i < recipeBook.getRecipes().length; i++)
        {
            Recipe recipe = new Recipe();
            recipe.setName("Test" + i);
            recipeBook.addRecipe(recipe);
        }
        for(int i = 0; i < recipeBook.getRecipes().length; i++)
        {
            recipeBook.deleteRecipe(i);
        }
        Recipe newRecipe = new Recipe();
        newRecipe.setName("Full");
        assertTrue(recipeBook.addRecipe(newRecipe));
    }

    @Test
    void replaceRecipe() {
        RecipeBook recipeBook = new RecipeBook();
        Recipe oldRecipe = new Recipe();
        oldRecipe.setName("BeforeTest");
        recipeBook.addRecipe(oldRecipe);
        Recipe newRecipe = new Recipe();
        newRecipe.setName("AfterTest");
        assertAll(
                () -> assertEquals(recipeBook.replaceRecipe(0,newRecipe),"BeforeTest"),
                () -> assertEquals(recipeBook.getRecipes()[0].getName(),"AfterTest")
        );
    }

    @Test
    void replaceNullRecipe() {
        RecipeBook recipeBook = new RecipeBook();
        Recipe oldRecipe = new Recipe();
        assertNull(recipeBook.replaceRecipe(0,oldRecipe));
    }

    @Test
    void replaceRecipeNull() {
        RecipeBook recipeBook = new RecipeBook();
        Recipe newRecipe = new Recipe();
        newRecipe.setName("BeforeTest");
        recipeBook.addRecipe(newRecipe);
        assertAll(
                () -> assertEquals(recipeBook.replaceRecipe(0,null),"BeforeTest"),
                () -> assertNull(recipeBook.getRecipes()[0])
        );
    }

    @Test
    void testReplaceRecipeDuplicate()
    {
        RecipeBook recipeBook = new RecipeBook();
        Recipe newRecipe = new Recipe();
        newRecipe.setName("BeforeTest");
        recipeBook.addRecipe(newRecipe);
        assertAll(
                () -> assertEquals(recipeBook.replaceRecipe(0,newRecipe),"BeforeTest"),
                () -> assertEquals(recipeBook.getRecipes()[0].getName(), "BeforeTest")
        );
    }
}