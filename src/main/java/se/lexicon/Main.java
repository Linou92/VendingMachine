package se.lexicon;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        VendingMachine machine = new VendingMachine();

        // create products
        machine.addProduct(new Snack(1, "Chips", 15, 5, 130));
        machine.addProduct(new Beverage(2, "Cola", 20, 3, 330));
        machine.addProduct(new Fruit(3, "Apple", 10, 8, "Sweden"));

        // start UI
        ConsoleUI ui = new ConsoleUI(machine);
        IO.println("Welcome to Lexicon Vending Machine!");
        ui.start();
    }
}
