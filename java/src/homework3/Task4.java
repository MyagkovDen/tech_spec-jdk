package src.homework3;

/*Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
Класс должен иметь методы getFirst(), getSecond() для получения значений пары, а также
переопределение метода toString(), возвращающее строковое представление пары.*/
public class Task4 {
    public static void main(String[] args) {
      //  Pair <Integer, Double> pair = new Pair<>(5, 7.3);
      //  Pair <String, Integer> pair = new Pair<>("hello", 7);
        Pair <String, Car> pair = new Pair<>("description", new Car("red", 1.6));
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
        System.out.println(pair);
    }

}

class Pair<T, E> {
    private final T firstValue;
    private final E secondValue;

    public Pair(T firstValue, E secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public T getFirst() {
        return firstValue;
    }

    public E getSecond() {
        return secondValue;
    }

    @Override
    public String toString() {
        return "[" + firstValue + " : " + secondValue + "]";
    }
}

class Car{
    String color;
    Double engine;

    public Car(String color, Double engine) {
        this.color = color;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", engine=" + engine +
                '}';
    }
}
