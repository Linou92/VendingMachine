package se.lexicon;

public class Fruit extends Product{

    private String origin;

    public Fruit(int id, String name, int price, int quantity, String origin) {
        super(id, name, price, quantity);
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String getDescription(){
        return getName() + " (Fruit, " + origin + ")";
    }
}

