package se.lexicon;

public class Snack extends Product{

    private int weightGrams;

    public Snack(int id, String name, int price, int quantity, int weightGrams) {
        super(id, name, price, quantity);
        this.weightGrams = weightGrams;
    }

    public int getWeightGrams() {
        return weightGrams;
    }

    public void setWeightGrams(int weightGrams) {
        this.weightGrams = weightGrams;
    }

    @Override
    public String getDescription(){
       return "(Snack, " + weightGrams + " g)";
    }
}
