package se.lexicon;

import java.util.List;

public interface VendingMachineInterface {

    boolean insertCoin(int coin);
    PurchaseResult buyProduct(int productId);
    int returnChange();
    List<Product> displayProducts();
    int getBalance();
    void addProduct(Product product);
}
