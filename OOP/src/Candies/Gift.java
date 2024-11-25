package Candies;
import Utils.NotFoundSuitableCandy;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;

public class Gift {
    private final List<Candy> candies = new ArrayList<>();
    private int sumOfWeight = 0;

    public Gift() {
        candies.add(new Chocolate().buildCandy());
        candies.add(new Caramel().buildCandy());
        candies.add(new Fruit().buildCandy());
        candies.add(new Waffle().buildCandy());
    }

    public Candy createCandy(String item) throws InputMismatchException {
        return switch (item) {
            case "1" -> new Chocolate().buildCandy();
            case "2" -> new Caramel().buildCandy();
            case "3" -> new Waffle().buildCandy();
            case "4" -> new Fruit().buildCandy();
            default -> throw new InputMismatchException("Неправильно введен заказ. Попробуйте еще раз.");
        };
    }

    public void weightOfGift() {
        for (Candy allCandies : candies) {
            sumOfWeight += allCandies.getWeight();
        }
        System.out.println("Общий вес подарка: " + sumOfWeight);
    }

    public void showInfo() {
        for (Candy candy : candies) {
            candy.showInfo();
        }
    }

    @Override
    public String toString() {
        List<String> names = new ArrayList<>();

        for (Candy list : candies) {
            names.add(list.getName());
        }
        return names.toString();
    }

    public void sortCandiesByWeight() {
        System.out.println("Сортировка подарка по весу");
        candies.sort(Comparator.comparingInt(Candy::getWeight));
        for (Candy sortedGift : candies) {
            System.out.println(sortedGift.getName() + " вес - " + sortedGift.getWeight());
        }
    }

    public void findCandyByPrice(int minPrice, int maxPrice) {
        List<Candy> list = new ArrayList<>();

        for (Candy candy : candies) {
            if (candy.getPrice() >= minPrice && candy.getPrice() <= maxPrice) {
                list.add(candy);
            }
        }
        if (!list.isEmpty()) {
            for (Candy candy : list) {
                System.out.println("Конфета подходящая по ценовому диапозону - " + candy.getName() + " цена: " + candy.getPrice());
            }
        } else {
            throw new NotFoundSuitableCandy("Нет подходящих конфет");
        }
    }
}
