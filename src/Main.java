import java.time.Instant;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в магическую коробку! \nСколько элементов хранить в коробке ?\nВведите целое число!");
        int input = scanner.nextInt() + 1;
        //В Main продемонстрируйте работу класса, создайте для этого магическую коробку для строк и
        //вторую для чисел и продемонстрируйте на них работу методов.
        MagicBox<String> strBox = new MagicBox<>(input / 2);
        MagicBox<Number> intBox = new MagicBox<>(input / 2);
        for (int i = 1; i < input; i++) {
            intBox.add(Math.random() * input); // заполняем коробку случайными числами
            strBox.add(String.valueOf(Instant.ofEpochSecond(ThreadLocalRandom.current().nextInt()))); // заполняем коробку случайными датами
        }
        System.out.println("-- Случайное число: " + intBox.pick()
                + "\n-- Случайная дата: " + strBox.pick());
        scanner.close();
    }
}
