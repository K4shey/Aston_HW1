package org.example;

/**
 * Кастомная реализация коллекции ArrayList. Реализованы лишь некоторые методы.
 */

import java.util.Arrays;
import java.util.Iterator;

public class CustomArrayListImpl<T extends Comparable<T>> implements CustomArrayList<T> {

    /**
     * Множитель, указывающий во сколько раз увеличиваем размер массива при достижении лимита
     */
    private static final float FACTOR = 1.5F;

    /**
     * Емкость массива для хранения элементов
     */
    private static final int CAPACITY = 10;
    /**
     * Массив для непосредственного хранения элементов коллекции
     */
    private Object[] array = new Object[CAPACITY];
    /**
     * Количество элементов в коллекции
     */
    private int size = 0;


    /**
     * @return size Количество элементов в коллекции
     */
    public int size() {
        return size;
    }

    /**
     * Добавляет элемент в конец коллекции
     *
     * @param element Элемент для добавления
     */
    public void add(T element) {
        checkCapacity(size);
        array[size++] = element;
    }

    /**
     * Вставляет элемент в коллекцию на указанную позицию
     *
     * @param index   позиция для вставки
     * @param element элемент для вставки
     */
    public void add(int index, T element) {
        checkIndex(index);
        checkCapacity(size);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    /**
     * Устанавливает новое значение элемента по индексу в коллекции
     *
     * @param index   позиция для установки
     * @param element элемент для установки
     */
    public void set(int index, T element) {
        checkIndex(index);
        array[index] = element;
    }

    /**
     * Получает значение элемента коллекции по индексу
     *
     * @param index позиция в коллекции
     * @return элемент коллекции
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    /**
     * Удаляет первое вхождение элемента из коллекции
     *
     * @param element элемент к удалению
     * @return boolean результат удаления
     */
    public boolean remove(T element) {
        int index = indexOf(element); // если передадут null в indexOf будет NPE
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * Удаляет элемент коллекции по индексу
     *
     * @param index позиция элемента для удаления
     */
    public void remove(int index) {
        checkIndex(index);
        if (size > 0) {
            if (index < size - 1) {
                System.arraycopy(array, index + 1, array, index, size - index - 1);
            }
            array[--size] = null;
        }
    }

    /**
     * Ищет первое вхождение элемента в коллекции
     *
     * @param element Искомый элемент
     * @return позиция элемента если найден, -1 в противном случае
     */
    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(array[i])) {// NPE
                return i;
            }
        }
        return -1;
    }

    /**
     * Очищает коллекцию
     */
    public void clear() {
        size = 0;
        array = new Object[CAPACITY];
    }

    /**
     * Обеспечивает отображение коллекции в консоли
     *
     * @return Строка, содержащая отображение коллекции
     */
    @Override
    public String toString() {
        return "MyArrayList{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }

    /**
     * Создает итератор
     *
     * @return итератор
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int idx = 0;

            @Override
            public boolean hasNext() {
                return idx < size;
            }

            @Override
            public T next() {
                return (T) array[idx++];
            }
        };
    }

    private void checkIndex(int index) {
        if (index < 0 || index > array.length - 1) {
            throw new IndexOutOfBoundsException("Value " + index + " is out of bound");
        }
    }

    private void checkCapacity(int size) {
        if (size + 1 > array.length) {
            Object[] newArray = new Object[(int) (size * FACTOR + 1)];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }
}