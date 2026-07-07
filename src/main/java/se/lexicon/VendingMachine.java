package se.lexicon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VendingMachine implements VendingMachineInterface {

    private final List<Product> products;
    private int balance;

    public VendingMachine() {
        this.products = new ArrayList<>();
        this.balance = 0;
    }

    // Inventory
    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> displayProducts() {
        return products;
    }

    // Payment
    @Override
    public boolean insertCoin(int coin) {
        if (!CoinValidator.isValidCoin(coin)) {
            return false;
        }
        balance += coin;
        return true;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public int returnChange() {
        int change = balance;
        balance = 0;
        return change;
    }

    // Purchase logic
    @Override
    public PurchaseResult buyProduct(int productId) {
        // check if product exists or in stock
        Product product = findProductById(productId);
        if (product == null) {
            return new PurchaseResult(false, "Product not found.", null, 0);
        }
        if (!product.isInStock()) {
            return new PurchaseResult(false, "Product is out of stock.", null, 0);
        }
        // not enough balance
        int price = product.getPrice();
        if (balance < price) {
            int missing = price - balance;
            return new PurchaseResult(false,
                    "Insufficient balance. Missing " + missing + " kr.",
                    null,
                    0);
        }
        // successful purchase
        product.decreaseStock();
        balance -= price;
        int change = balance;
        // return change if any
        if (balance > 0) {
            balance = 0;
        }
        return new PurchaseResult(
                true,
                "Dispensing: " + product.getName() + " " + product.getDescription(),
                product,
                change
        );
    }

    // Helpers
    public Product findProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public  List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }
}
