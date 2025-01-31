package coffeemaker.domain;

import static org.junit.jupiter.api.Assertions.*;

import coffeemaker.exceptions.InventoryException;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    private Inventory invent = new Inventory();
    private Recipe r = new Recipe();

    @Test
    void testDefaults() {
        assertEquals(15, invent.getCoffee());
        assertEquals(15, invent.getMilk());
        assertEquals(15, invent.getSugar());
        assertEquals(15, invent.getChocolate());
    }

    @Test
    void testSetCoffee() {
        invent.setCoffee(-8);
        assertEquals(15, invent.getCoffee());
    }

    @Test
    void testAddCoffee() {
        assertThrows(InventoryException.class, () -> invent.addCoffee("5.2"));
        assertThrows(InventoryException.class, () -> invent.addCoffee("-6"));
        invent.addCoffee("5");
        assertEquals(20, invent.getCoffee());
    }

    @Test
    void testSetMilk() {
        invent.setMilk(-8);
        assertEquals(15, invent.getMilk());
    }

    @Test
    void testAddMilk() {
        assertThrows(InventoryException.class, () -> invent.addMilk("5.2"));
        assertThrows(InventoryException.class, () -> invent.addMilk("-6"));
        invent.addMilk("5");
        assertEquals(20, invent.getMilk());
    }

    @Test
    void testSetSugar() {
        invent.setSugar(-8);
        assertEquals(15, invent.getSugar());
    }

    @Test
    void testAddSugar() {
        assertThrows(InventoryException.class, () -> invent.addSugar("5.2"));
//        assertThrows(InventoryException.class, () -> invent.addSugar("-6"));
        //Defect above since it tries to add negative amounts of sugar
        invent.addSugar("5");
        assertEquals(20, invent.getSugar());
    }

    @Test
    void testAddSugarNegative()
    {
        assertThrows(InventoryException.class, () -> invent.addSugar("-6"));
    }


    @Test
    void testSetChocolate() {
        invent.setChocolate(-8);
        assertEquals(15, invent.getChocolate());
    }

    @Test
    void testAddChocolate() {
        assertThrows(InventoryException.class, () -> invent.addChocolate("5.2"));
        assertThrows(InventoryException.class, () -> invent.addChocolate("-6"));
        invent.addChocolate("5");
        assertEquals(20, invent.getChocolate());
    }

    @Test
    void testEnoughIngredients() {
        r.setAmtCoffee("15");
        r.setAmtMilk("15");
        r.setAmtSugar("15");
        r.setAmtChocolate("15");
        assertTrue(invent.enoughIngredients(r));
    }

//    @Test
//    void testEnoughIngredientsNullRecipe()
//    {
//        assertFalse(invent.enoughIngredients(null));
//    }

    @Test
    void testUseIngredientsNotEnough() {
        r.setAmtCoffee("15");
        r.setAmtMilk("15");
        r.setAmtSugar("15");
        r.setAmtChocolate("15");

        assertTrue(invent.useIngredients(r));

        assertEquals(0, invent.getMilk());
        assertEquals(0, invent.getCoffee());
        assertEquals(0, invent.getSugar());
        assertEquals(0, invent.getChocolate());

        assertFalse(invent.useIngredients(r));
    }

    @Test
    void testUseIngredients() {
        r.setAmtCoffee("15");
        r.setAmtMilk("15");
        r.setAmtSugar("15");
        r.setAmtChocolate("15");

        assertTrue(invent.useIngredients(r));

        assertEquals(0, invent.getMilk());
        assertEquals(0, invent.getCoffee());
        assertEquals(0, invent.getSugar());
        assertEquals(0, invent.getChocolate());
    }

    @Test
    void testToString() {
        assertEquals("Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n", invent.toString());
    }
}
