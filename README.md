# Lexicon Vending Machine

A Java console-based vending machine application.

## Features

- Supports snacks, beverages, and fruits
- Accepts Swedish coins:
  - 1 kr
  - 2 kr
  - 5 kr
  - 10 kr
  - 20 kr
  - 50 kr
- Handles:
  - product selection
  - balance management
  - automatic change return
  - stock management
  - invalid purchases

## Diagram

```mermaid
classDiagram
    class Product {
        <<abstract>>
        - id: int
        - name: String
        - price: int
        - quantity: int

        + getDescription(): String abstract
        + decreaseStock(): void
        + isInStock(): boolean
    }

    class Snack {
        - weightGrams: int
        + getDescription(): String
    }

    class Beverage {
        - volumeMl: int
        + getDescription(): String
    }

    class Fruit {
        - origin: String
        + getDescription(): String
    }

    class VendingMachineInterface {
        <<interface>>
        + insertCoin(int coin)
        + buyProduct (int productId)
        + returnChange()
        + displayProducts()
        + getBalance(): int
    }

    class VendingMachine{
        - products: List~Product~
        - balance: int

        + insertCoin()
        + buyProduct()
        + returnChange()
        + displayProducts()
        + getBalance(): int
        + addProduct(Product product)
    }
       
Product <|-- Snack
Product <|-- Beverage
Product <|-- Fruit

VendingMachineInterface <|.. VendingMachine

VendingMachine "1" *-- "0..*" Product
    
```

## Build

Clone the repository and run:

```bash
mvn clean package
```

After building run java -jar target/VendingMachine-1.0.SNAPSHOTjar
