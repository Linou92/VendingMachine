package se.lexicon;

public abstract class Product {

    private int id;
    private String name;
    private int price;
    private int quantity;

    public Product(int id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // stock management
    public boolean isInStock() {
        return quantity > 0;
    }

    public void decreaseStock(int quantity) {
        if (quantity > 0) {
            this.quantity -= quantity;
        }
    }

    // every product implements its own description
    abstract String getDescription();
}
