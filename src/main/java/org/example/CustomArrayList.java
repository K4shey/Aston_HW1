package org.example;

public interface CustomArrayList<T extends Comparable<T>> extends Iterable<T> {

    /**
     * Возвращает количество элементов
     *
     * @return Количество элементов в коллекции
     */
    int size();

    /**
     * Добавляет элемент в конец коллекции
     *
     * @param element Элемент для добавления
     */
    void add(T element);

    /**
     * Вставляет элемент в коллекцию на указанную позицию
     *
     * @param index   позиция для вставки
     * @param element элемент для вставки
     */
    void add(int index, T element);

    /**
     * Устанавливает новое значение элемента по индексу в коллекции
     *
     * @param index   позиция для установки
     * @param element элемент для установки
     */
    void set(int index, T element);

    /**
     * Получает значение элемента коллекции по индексу
     *
     * @param index позиция в коллекции
     * @return элемент коллекции
     */
    T get(int index);

    /**
     * Удаляет первое вхождение элемента из коллекции
     *
     * @param element элемент к удалению
     * @return результат удаления
     */
    boolean remove(T element);

    /**
     * Удаляет элемент коллекции по индексу
     *
     * @param index позиция элемента для удаления
     */
    void remove(int index);

    /**
     * Ищет первое вхождение элемента в коллекции
     *
     * @param element искомый элемент
     * @return позиция элемента если найден, -1 в противном случае
     */
    int indexOf(T element);

    /**
     * Очищает коллекцию
     */
    void clear();
}
