package org.example;

public class QuickSort {
    public static void main(String[] args) {

        CustomArrayListImpl<String> customArrayList = new CustomArrayListImpl<>();
        customArrayList.add("Orange");
        customArrayList.add("Yellow");
        customArrayList.add("Red");
        customArrayList.add("White");
        customArrayList.add("Pink");
        customArrayList.add("Black");
        customArrayList.add("Green");
        customArrayList.add("Blue");

        System.out.println(quickSort(customArrayList));
    }

    private static <T extends Comparable<T>> CustomArrayListImpl<T> quickSort(CustomArrayListImpl<T> list) {

        if (list.size() < 2) {
            return list;
        }

        CustomArrayListImpl<T> greater = new CustomArrayListImpl<>();
        CustomArrayListImpl<T> less = new CustomArrayListImpl<>();

        T pivot = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(pivot) < 0) {
                less.add(list.get(i));
            } else {
                greater.add(list.get(i));
            }
        }

        less = quickSort(less);
        greater = quickSort(greater);

        less.add(pivot);
        for (T i : greater) {
            less.add(i);
        }
        return less;
    }
}