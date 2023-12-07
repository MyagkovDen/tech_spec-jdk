package src.homework3;
/*Внедрить итератор из задания 2 в коллекцию, написанную в задании 3 таким образом,
чтобы итератор был внутренним классом и, соответственно, объектом в коллекции.*/

import java.util.Arrays;
import java.util.Iterator;

public class Task1 {
    public static void main(String[] args) {
//        Integer[] arr = {1, 2, 3};
//        MyList<Integer> list = new MyList<>(arr);
//        System.out.println(list);
//        list.addElement(4);
//        list.addElement(5);
//        System.out.println(list);
//        list.removeElement(2);
//        list.removeElement(3);
//

        MyList<String> list = new MyList<>();
        list.addElement("hello");
        list.addElement("goodbye");
        list.addElement("ok");
        list.removeElement(1);

        MyList<String>.MyListIterator iterator = list.new MyListIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class MyList<T> {
    Object[] initialArray = new Object[0];
    T[] array;
    private int size;

    public MyList(T[] baseArray) {
        this.array = baseArray;
        this.size = array.length;
    }
    public MyList(){
        this.array = (T[]) initialArray;
        this.size = 0;
    }

    public <E extends T> void addElement(E element) {
        if (size == array.length) {
            Object[] newArray = new Object[array.length + 1];
            System.arraycopy(array, 0, newArray, 0, array.length);
            newArray[array.length] = element;
            array = (T[]) newArray;
        } else {
            array[size] = element;
        }
        size++;
    }

    public void removeElement(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null;
        size--;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    class MyListIterator implements Iterator<T> {
        private int index;

        public MyListIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            if (array[index] != null) return true;
            else return false;
        }

        @Override
        public T next() {
            return array[index++];
        }
    }
}
