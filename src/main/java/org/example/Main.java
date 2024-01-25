package org.example;

public class Main {
    public static void main(String[] args) {

        CustomArrayListImpl<String> myArrayList = new CustomArrayListImpl<>();

        for (int i = 1; i < 12; i++) {
            myArrayList.add(String.valueOf(i));
        }
        System.out.println(myArrayList);

        myArrayList.set(0, "10");
        System.out.println(myArrayList);

        myArrayList.add(0, "22");
        System.out.println(myArrayList);
        myArrayList.add(0, "33");
        System.out.println(myArrayList);
        myArrayList.add(0, "44");
        System.out.println(myArrayList);
        myArrayList.add(4, "55");
        System.out.println(myArrayList);

        myArrayList.remove(3);
        System.out.println(myArrayList);

        System.out.println(myArrayList.remove("77"));

        myArrayList.clear();
        System.out.println(myArrayList);
    }
}