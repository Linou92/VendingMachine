package se.lexicon;

public class Beverage extends Product{

    private int volumeMl;

    public Beverage(int id, String name, int price, int quantity, int volumeMl) {
        super(id, name, price, quantity);
        if (volumeMl <= 0) {
            throw new IllegalArgumentException("Volume must be greater than 0.");
        }
        this.volumeMl = volumeMl;
    }

    public int getVolumeMl() {
        return volumeMl;
    }

    public void setVolumeMl(int volumeMl) {
        this.volumeMl = volumeMl;
    }

    @Override
    public String getDescription(){
        return "(Beverage, " + volumeMl + " ml)";
    }
}
