package example;

public class Product {

    int amount;
    String name;

    public Product(int amount, String name) {
        this.amount = amount;
        this.name = name;
    }


    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmout() {
        return this.amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
