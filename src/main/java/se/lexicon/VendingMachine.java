package se.lexicon;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine implements VendingMachineInterface {

    private List<Product> products;
    private int balance;
    private final int[] validCoins = {1, 2, 5, 10, 20, 50};

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
    public void displayProducts() {
        IO.println("------------------------------------");
        for (Product product : products) {
            IO.println(String.format("""
                            [%d] %s   - %d kr   %s   Stock: %d     
                            """, product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getDescription(),
                    product.getQuantity()));
        }
        IO.println(String.format("""
                ------------------------------------
                Balance: %d kr
                """, balance));
    }

    // Payment
    @Override
    public void insertCoin(int coin) {
        if (!isValidCoin(coin)) {
            IO.println("Invalid Coin! Only 1, 2, 5, 10, 20, 50 kr accepted.");
            return;
        }
        balance += coin;
        IO.println("Balance: " + balance + " kr");
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public void returnChange() {
        if (balance == 0) {
            IO.println("No balance to return.");
            return;
        }
        IO.println("Change returned: " + balance + " kr");
        balance = 0;
    }

    // Purchase logic
    @Override
    public void buyProduct(int productId) {
        // check if product exists or in stock
        Product product = findProductById(productId);
        if (product == null) {
            IO.println("Product not found.");
            return;
        }
        if (!product.isInStock()) {
            IO.println("Product is out of stock.");
            return;
        }
        // not enough balance
        int price = product.getPrice();
        if (balance < price) {
            int missing = price - balance;
            IO.println("Insufficient balance. Missing " + missing + " kr.");
            return;
        }
        // successful purchase
        product.decreaseStock();
        balance -= price;
        IO.println("Dispensing: " + product.getName() + product.getDescription());
        // return change if any
        if (balance > 0) {
            IO.println("Returned change: " + balance + " kr");
            balance = 0;
        } else IO.println("Balance: 0 kr");
    }

    // Helpers
    private boolean isValidCoin(int coin) {
        for (int c : validCoins) {
            if (c == coin) return true;
        }
        return false;
    }

    public Product findProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public  List<Product> getProducts() {
        return products;
    }
}
