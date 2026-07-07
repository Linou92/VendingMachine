package se.lexicon;

public class PurchaseResult {

    private boolean success;
    private String message;
    private Product product;
    private int change;

    public PurchaseResult(boolean success, String message, Product product, int change) {
        this.success = success;
        this.message = message;
        this.product = product;
        this.change = change;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Product getProduct() {
        return product;
    }

    public int getChange() {
        return change;
    }
}
