package se.lexicon;

public abstract class Product {

    private int id;
    private String name;
    private int price;
    private int quantity;

    public Product(int id, String name, int price, int quantity) {
        if (id <= 0) {
            throw new IllegalArgumentException("Product id must be greater than 0.");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }

        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }

        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
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

    public void decreaseStock() {
        if (quantity > 0) {
            this.quantity --;
        }
    }

    // every product implements its own description
    abstract String getDescription();
}
