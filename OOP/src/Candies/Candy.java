package Candies;

import java.io.Serializable;

public abstract class Candy implements Serializable {
    String name;
    int weight;
    int price;

    public Candy(int weight, int price, String name) {
        this.weight = weight;
        this.price = price;
        this.name = name;
    }

    public Candy() {
    }

    public String showInfo() {
        return "Название - " + name + ", вес = " + weight + ", цена = " + price;
    }

    public void whatsTaste() {
        System.out.println("Вкус: " + name);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }
}
