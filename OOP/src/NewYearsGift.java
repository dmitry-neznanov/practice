import Candies.Candy;
import Candies.Gift;
import Utils.ConsoleScanner;
import Utils.NotFoundSuitableCandy;
import java.util.InputMismatchException;


public class NewYearsGift {
    public static void main(String[] args) {

        while (true) {

            System.out.println("Что вы хотите? Введите число: 1.Конфета или 2.Подарок");

            String chose = ConsoleScanner.getInputString();

            if (chose.matches("1")) {
                System.out.println("Какую конфету вы хотите? 1.Шоколад, 2.Карамель, 3.Вафли, 4.Фруктовая");

                try {
                    Candy order = new Gift().createCandy(ConsoleScanner.getInputString());

                    if (order != null) {
                        System.out.println("Ваш заказ - " + order.showInfo());
                        break;
                    }
                } catch (InputMismatchException e) {
                    e.printStackTrace();
                }

            } else if (chose.matches("2")) {
                Gift order = new Gift();

                System.out.println("1.Сортировать подарок 2.Найти конфету по цене");
                String var = ConsoleScanner.getInputString();

                if (var.matches("1")) {
                    order.sortCandiesByWeight();

                } else if (var.matches("2")) {
                    System.out.println("Введите ценовой диапозон");

                    try {
                        order.findCandyByPrice(ConsoleScanner.getInputInteger(), ConsoleScanner.getInputInteger());

                    } catch (InputMismatchException e) {
                        throw new InputMismatchException("Введен неправильный диапозон");

                    } catch (NotFoundSuitableCandy e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Ваш подарок - " + order);
                break;

            } else {
                System.out.println("Неправильно введен заказ. Попробуйте еще раз.");
            }
        }

        /*Candy candy = new Gift().createCandy("2");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data"))) {

            oos.writeObject(candy);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data"))){

            Candy myCandie = (Candy) ois.readObject();

            System.out.println(myCandie.showInfo());

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }*/


    }
}
