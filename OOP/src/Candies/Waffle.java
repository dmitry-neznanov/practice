package Candies;

import Utils.GeneratorForCandies;

public class Waffle extends Candy implements ICandy {
    private String typeOfWaffles;

    public Waffle(int weight, int price, String name, String typeOfWaffles) {
        super(weight, price, name);
        this.typeOfWaffles = typeOfWaffles;
    }

    public Waffle() {
        super();
    }

    public String getTypeOfWaffles() {
        return typeOfWaffles;
    }

    public void setTypeOfWaffles(String typeOfWaffles) {
        this.typeOfWaffles = typeOfWaffles;
    }

    public String showInfo() {
        return "Название - " + name + ", вафли - " + typeOfWaffles + ", вес = " + weight + ", цена = " + price;
    }

    @Override
    public Candy buildCandy() {
        String[] names = {"Коломенские", "Яшкино"};
        String[] typeOfWaffles = {"шоколадные", "сливочные"};
        return new Waffle(GeneratorForCandies.genWeight(), GeneratorForCandies.genPrice(),
                names[(int) (Math.random() * names.length)], typeOfWaffles[(int) (Math.random() * typeOfWaffles.length)]);
    }
}
