package se.lexicon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendingMachineTests {

    private VendingMachine machine;

    @BeforeEach
    void setUp() {
        machine = new VendingMachine();
        machine.addProduct(new Snack(1, "Chips", 20, 3, 130));
        machine.addProduct(new Beverage(2, "Cola", 15, 5, 330));
        machine.addProduct(new Fruit(3, "Apple", 10, 2, "Sweden"));
    }

    /* --------------------------
          TEST 1 - Valid coin
       -------------------------- */
    @Test
    void inserValidCoin_shouldIncreaseBalance(){
        machine.insertCoin(10);
        assertEquals(10, machine.getBalance());
    }

    /* --------------------------
          TEST 2 - Invalid coin
       -------------------------- */
    @Test
    void inserInvalidCoin_shouldNotChangeBalance(){
        machine.insertCoin(7);
        assertEquals(0, machine.getBalance());
    }

    /* ------------------------------------
          TEST 3 - Successful purchase
       ------------------------------------ */
    @Test
    void purchase_shouldSucceed_whenEnoughBalance(){
        machine.insertCoin(20);
        machine.buyProduct(1); // chips 20kr
        Product product = machine.findProductById(1);
        assertEquals(0, machine.getBalance());
        assertEquals(2, product.getQuantity());
    }

    /* ------------------------------------
         TEST 4 - Insufficient balance
      ------------------------------------ */
    @Test
    void purchase_shouldFail_whenNotEnoughBalance(){
        machine.insertCoin(10);
        machine.buyProduct(1); // chips 20kr
        Product product = machine.findProductById(1);
        assertEquals(10, machine.getBalance());
        assertEquals(3, product.getQuantity());
    }

    /* ------------------------------------
         TEST 5 - Out of stock
      ------------------------------------ */
    @Test
    void purchase_shouldFail_whenOutOfStock(){
        // set stock to 0
        Product product = machine.findProductById(1);
        product.decreaseStock();
        product.decreaseStock();
        product.decreaseStock();
        machine.insertCoin(50);
        machine.buyProduct(1);
        assertEquals(50, machine.getBalance());
        assertEquals(0, product.getQuantity());
    }

    /* ------------------------------------
         TEST 6 - Return change
      ------------------------------------ */
    @Test
    void returnChange_shouldResetBalance(){
        machine.insertCoin(50);
        machine.returnChange();
        assertEquals(0, machine.getBalance());
    }

    /* ------------------------------------
         TEST 7 - Product list size
      ------------------------------------ */
    @Test
    void productList_shouldContainThreeProducts(){
        assertEquals(3, machine.getProducts().size());
    }
}
