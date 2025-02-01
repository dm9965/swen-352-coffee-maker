package coffeemaker.domain;

import static org.junit.jupiter.api.Assertions.*;

import coffeemaker.exceptions.InventoryException;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    private Inventory invent = new Inventory();
    private Recipe r = new Recipe();

    @Test
    void testCoffeeDefault() {
        assertEquals(15, invent.getCoffee());
    }

    @Test
    void testMilkDefault() {
        assertEquals(15, invent.getMilk());
    }

    @Test
    void testSugarDefault() {
        assertEquals(15, invent.getSugar());
    }

    @Test
    void testChocolateDefault() {
        assertEquals(15, invent.getChocolate());
    }

    @Test
    void testSetCoffee() {
        invent.setCoffee(-8);
        assertEquals(15, invent.getCoffee());
    }

    @Test
    void testAddCoffeeFloat() {
        assertThrows(InventoryException.class, () -> invent.addCoffee("5.2"));
    }

    @Test
    void testAddCoffeeNegative() {
        assertThrows(InventoryException.class, () -> invent.addCoffee("-6"));
    }

    @Test
    void testAddCoffee() {
        invent.addCoffee("5");
        assertEquals(20, invent.getCoffee());
    }

    @Test
    void testSetMilk() {
        invent.setMilk(-8);
        assertEquals(15, invent.getMilk());
    }

    @Test
    void testAddMilkFloat() {
        assertThrows(InventoryException.class, () -> invent.addMilk("5.2"));
    }

    @Test
    void testAddMilkNegative() {
        assertThrows(InventoryException.class, () -> invent.addMilk("-6"));
    }

    @Test
    void testAddMilk() {
        invent.addMilk("5");
        assertEquals(20, invent.getMilk());
    }

    @Test
    void testSetSugar() {
        invent.setSugar(-8);
        assertEquals(15, invent.getSugar());
    }

    @Test
    void testAddSugarFloat() {
        assertThrows(InventoryException.class, () -> invent.addSugar("5.2"));
    }

    @Test
    void testAddSugarNegative()
    {
        assertThrows(InventoryException.class, () -> invent.addSugar("-6"));
    }

    @Test
    void testAddSugar() {
        invent.addSugar("5");
        assertEquals(20, invent.getSugar());
    }

    @Test
    void testSetChocolate() {
        invent.setChocolate(-8);
        assertEquals(15, invent.getChocolate());
    }

    @Test
    void testAddChocolateFloat() {
        assertThrows(InventoryException.class, () -> invent.addChocolate("5.2"));
    }

    @Test
    void testAddChocolateNegative() {
        assertThrows(InventoryException.class, () -> invent.addChocolate("-6"));
    }

    @Test
    void testAddChocolate() {
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

    @Test
    void testUseCoffee() {
        r.setAmtCoffee("15");

        invent.useIngredients(r);

        assertEquals(0, invent.getCoffee());
    }

    @Test
    void testUseMilk() {
        r.setAmtMilk("15");

        invent.useIngredients(r);

        assertEquals(0, invent.getMilk());
    }

    @Test
    void testUseSugar() {
        r.setAmtSugar("15");

        invent.useIngredients(r);

        assertEquals(0, invent.getSugar());
    }

    @Test
    void testUseChocolate() {
        r.setAmtChocolate("15");

        invent.useIngredients(r);

        assertEquals(0, invent.getChocolate());
    }

    @Test
    void testNotEnoughCoffee() {
        r.setAmtCoffee("15");

        assertTrue(invent.useIngredients(r));

        assertFalse(invent.useIngredients(r));
    }

    @Test
    void testNotEnoughMilk() {
        r.setAmtMilk("15");

        assertTrue(invent.useIngredients(r));

        assertFalse(invent.useIngredients(r));
    }

    @Test
    void testNotEnoughSugar() {
        r.setAmtSugar("15");

        assertTrue(invent.useIngredients(r));

        assertFalse(invent.useIngredients(r));
    }

    @Test
    void testNotEnoughChocolate() {
        r.setAmtChocolate("15");

        assertTrue(invent.useIngredients(r));

        assertFalse(invent.useIngredients(r));
    }

    @Test
    void testToString() {
        assertEquals("Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n", invent.toString());
    }
}
