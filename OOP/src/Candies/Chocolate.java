package Candies;

import Utils.GeneratorForCandies;


public class Chocolate extends Candy implements ICandy {
    private String typeOfChocolate;

    public Chocolate(int weight, int price, String name, String typeOfChocolate) {
        super(weight, price, name);
        this.typeOfChocolate = typeOfChocolate;
    }

    public Chocolate() {
        super();
    }

    public String showInfo() {
        return "Название - " + name + ", шоколад - " + typeOfChocolate + ", вес = " + weight + ", цена = " + price;
    }

    public String getTypeOfChocolate() {
        return typeOfChocolate;
    }

    public void setTypeOfChocolate(String typeOfChocolate) {
        this.typeOfChocolate = typeOfChocolate;
    }

    @Override
    public Candy buildCandy() {
        String[] names = {"Сникерс", "Твикс"};
        String[] typesOfChocolate = {"белый", "молочный"};
        return new Chocolate(GeneratorForCandies.genWeight(), GeneratorForCandies.genPrice(),
                names[(int) (Math.random() * names.length)], typesOfChocolate[(int) (Math.random() * typesOfChocolate.length)]);
    }
}
