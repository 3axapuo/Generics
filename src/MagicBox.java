// Вам предстоит реализовать класс MagicBox (англ. магическая коробка),
// который умеет выбирать случайным образом один из сохранённых в него объектов.

import java.util.Random;

// Тип добавляемых объектов должен быть тип-параметром класса - т.е.
// сам класс должен быть дженерик-классом с одним тип-параметром.
public class MagicBox<T> {
    private int countItems;
    protected T[] arrBox;

    private Random random = new Random(); // Для выбора случайного элемента воспользуйтесь классом Random (не забудьте заимпортить)

    // При конструировании объекта этого класса указывается,
    // сколько объектов в него можно положить (механика похожа на решение задачи про Полиморфизм).
    public MagicBox(int item) { // Массив создавать в конструкторе, размером который был указан в его параметре.
        this.countItems = countItems;
        arrBox = (T[]) new Object[item]; // Хранить сохранённые элементы предлагаем в массиве, как в задаче про Полиморфизм.
    }

    public boolean add(T item) {
        for (T i : arrBox) {
            if (i == null) {
                arrBox[countItems] = item;
                System.out.println("В магическую коробку добавлен элемент " + item + " от " + item.getClass());
                countItems++;
                return true; // Если коробка ещё не полна, то элемент должен в ней сохраниться и метод вернуть true
            }
        }
        return false; // Если полна, то коробка не должна измениться, а метод должен вернуть false
    }

    public T pick() { // также нужно реализовать метод T pick(), работающий следующим образом
        for (int i = 0; i < arrBox.length; i++) {
            if (arrBox[i] == null) {
                countItems--;
            }
        }
        // Если коробка не полна, то он выкидывает RuntimeException с сообщением,
        // что коробка не полна и осталось ещё столько-то ячеек заполнить
        if (arrBox.length > countItems) {
            throw new RuntimeException("ОШИБКА: магическая коробка не заполнена, найдены NULL значения в количестве: " + (arrBox.length - countItems));
        } else { return arrBox[random.nextInt(arrBox.length)];}
    }
}
