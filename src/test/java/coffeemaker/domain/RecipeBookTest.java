package coffeemaker.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeBookTest {

    @Test
    void getRecipes() {
        RecipeBook recipeBook = new RecipeBook();
        assertNotNull(recipeBook.getRecipes());
        assert(recipeBook.getRecipes().length == 4);
    }

    @Test
    void addRecipe() {
        RecipeBook recipeBook = new RecipeBook();
        Recipe recipe = new Recipe();
        recipe.setName("Test");
        assert(recipeBook.addRecipe(recipe));
        assert(recipeBook.getRecipes()[0].getName().equals("Test"));
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
        assertEquals(recipeBook.replaceRecipe(0,newRecipe),"BeforeTest");
        assert(recipeBook.getRecipes()[0].getName().equals("AfterTest"));
    }
}