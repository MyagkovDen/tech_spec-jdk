package src.homework3;

/*Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
sum(), multiply(), divide(), subtract(). Параметры этих методов – два
числа разного типа, над которыми должна быть произведена операция.*/
public class Task2 {
    public static void main(String[] args) {
        System.out.println(Calculator.sum(10579874095831295078f, 2.3));
        System.out.println(Calculator.multiply(23423658689787421L, 2.2));
        System.out.println(Calculator.divide(1, 200));
        System.out.println(Calculator.subtruct(1, 2));
    }
}

class Calculator {

    public static <X extends Number, Y extends Number> Float sum(X x, Y y) {
        return x.floatValue() + y.floatValue();
    }

    public static <X extends Number, Y extends Number> Float multiply(X x, Y y) {
        return x.floatValue() * y.floatValue();
    }

    public static <X extends Number, Y extends Number> Float divide(X x, Y y) {
        return x.floatValue() / y.floatValue();
    }

    public static <X extends Number, Y extends Number> Float subtruct(X x, Y y) {
        return x.floatValue() - y.floatValue();
    }

}
