package se.lexicon;

public class ConsoleUI {

    private VendingMachine machine;

    public ConsoleUI(VendingMachine machine) {
        this.machine = machine;
    }

    public void start(){
        boolean running = true;
        handleDisplayProducts();
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
                    handleReturnChange();
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
        if (machine.insertCoin(coin)) {
            IO.println("Balance: " + machine.getBalance() + " kr");
        } else {
            IO.println("Invalid coin. Only 1, 2, 5, 10, 20, 50 kr accepted.");
        }
    }

    private void handleSelectProduct() {
        String input = IO.readln("Select a product id: ");
        int productId = Integer.parseInt(input);
        PurchaseResult result = machine.buyProduct(productId);
        IO.println(result.getMessage());
        if (!result.isSuccess()) {
            IO.println("Purchase failed.");
        } else {
            if (result.isSuccess() && result.getChange() > 0) {
                IO.println("Change returned: " + result.getChange() + " kr");
            }

            IO.println("Balance: " + machine.getBalance() + " kr");
        }
    }

    public void handleReturnChange() {
        int change = machine.returnChange();
        if(change == 0){
            IO.println("No balance to return.");
        }
        else IO.println("Returned balance: " + change + " kr");
    }

    public void handleDisplayProducts() {
        IO.println("------------------------------------");
        for (Product product : machine.displayProducts()) {
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
                """, machine.getBalance()));
    }
}
