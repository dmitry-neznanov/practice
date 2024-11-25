package Candies;


import Utils.GeneratorForCandies;

public class Caramel extends Candy implements ICandy {
    private String filling;

    public Caramel(int weight, int price, String name, String filling) {
        super(weight, price, name);
        this.filling = filling;
    }

    public Caramel() {
        super();
    }

    public String showInfo() {
        return "Название - " + name + ", начинка - " + filling + ", вес = " + weight + ", цена = " + price;
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    @Override
    public Candy buildCandy() {
        String[] names = {"Коровка", "Буренка"};
        String[] filling = {"шоколад", "сгущенка"};
        return new Caramel(GeneratorForCandies.genWeight(), GeneratorForCandies.genPrice(),
                names[(int) (Math.random() * names.length)], filling[(int) (Math.random() * filling.length)]);
    }
}
