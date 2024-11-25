package Candies;

import Utils.GeneratorForCandies;


public class Fruit extends Candy implements ICandy {
    private String taste;

    public Fruit(int weight, int price, String name, String taste) {
        super(weight, price, name);
        this.taste = taste;
    }

    public Fruit() {
        super();
    }

    public String getTaste() {
        return taste;

    }
    public String showInfo(){
        return "Название - " + name + ", вкус - " + taste + ", вес = " + weight + ", цена = " + price;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }
    @Override
    public Candy buildCandy() {
        String[] names = {"Хасбо","Тропический остров"};
        String[] fruitFilling = {"лимонная","апельсиновая"};
        return new Fruit(GeneratorForCandies.genWeight(), GeneratorForCandies.genPrice(),
                names[(int) (Math.random() * names.length)],fruitFilling[(int) (Math.random() * fruitFilling.length)]);
    }
}
