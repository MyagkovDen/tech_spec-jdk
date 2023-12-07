package src.homework3;

/*Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true,
если они одинаковые, и false в противном случае. Массивы могут быть любого типа данных,
но должны иметь одинаковую длину и содержать элементы одного типа. */
public class Task3 {
    public static <T> boolean compareArrays(T[] array1, T[] array2) {
        if (array1.length != array2.length ||
                !array1.getClass().getSimpleName().equals(array2.getClass().getSimpleName())) {
            return false;
        } else {
            for (int i = 0; i < array1.length; i++) {
                if (!array1[i].equals(array2[i])) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        Byte[] arr1 = {1, 2, 4};
//        Byte[] arr2 = {1, 2, 3};
        String[] arr2 = {"hello", "goodbye", "ok"};
        Object[] arr1 = {"hello", "goodbye", "ok"};
        System.out.println(compareArrays(arr1, arr2));
    }
}
