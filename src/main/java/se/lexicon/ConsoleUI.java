package se.lexicon;

public class ConsoleUI {

    private VendingMachine machine;

    public ConsoleUI(VendingMachine machine) {
        this.machine = machine;
    }

    public void start(){
        boolean running = true;
        machine.displayProducts();
        while (running) {
            String input = IO.readln(String.format("""
                    1. Insert a coin
                    2. Select a product
                    3. Return change
                    4. Exit
                    """));
            switch (input) {
                case "1" -> {
                    handleInsertCoin();
                    break;
                }
                case "2" -> {
                    handleSelectProduct();
                    break;
                }
                case "3" -> {
                    machine.returnChange();
                    break;
                }
                case "4" -> {
                    running = false;
                    IO.println("Goodbye !");
                    break;
                }
                default -> IO.println("Invalid input!");
            }
        }
    }

    private void handleInsertCoin() {
        String input = IO.readln("Insert a coin: ");
        int coin = Integer.parseInt(input);
        machine.insertCoin(coin);
    }

    private void handleSelectProduct() {
        String input = IO.readln("Select a product id: ");
        int productId = Integer.parseInt(input);
        machine.buyProduct(productId);
    }
}
