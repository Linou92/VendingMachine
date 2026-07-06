package se.lexicon;

public interface VendingMachineInterface {

    void insertCoin(int coin);
    void buyProduct(int productId);
    void returnChange();
    void displayProducts();
    int getBalance();
    void addProduct(Product product);
}
