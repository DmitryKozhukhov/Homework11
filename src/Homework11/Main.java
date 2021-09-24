package Homework11;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {


    /**
     * 1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
     *
     * 2. Написать метод, который преобразует массив в ArrayList;
     *
     * 3. Задача:
     *
     * a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
     *
     * b. Класс Box, в который можно складывать фрукты.
     *    Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
     *
     * c. Для хранения фруктов внутри коробки можно использовать ArrayList;
     *
     * d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
     *   вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
     *
     * e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
     *    которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
     *    Можно сравнивать коробки с яблоками и апельсинами;
     *
     * f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
     *    Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
     *    Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
     *
     * g. Не забываем про метод добавления фрукта в коробку.
     */

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 6, 2, 5};
        doTask1(arr, 2, 3);
        doTask2(arr);

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();

        Orange orange3 = new Orange();
        Orange orange4 = new Orange();

        Box<Apple> box1 = new Box(apple1, apple2, apple3);
        Box<Orange> box2 = new Box(orange1, orange2);
        Box<Orange> box3 = new Box(orange3, orange4);

        Apple apple4 = new Apple();
        Apple apple5 = new Apple();

        Orange orange = new Orange();

        box1.add(apple4, apple5);
        box2.add(orange);

        System.out.println("Коробка1 с яблоками = " + box1.getWeight());
        System.out.println("Коробка2 с апельсинами = " + box2.getWeight());
        System.out.println("Коробка3 с апельсинами = " + box3.getWeight());

        System.out.println(box1.compare(box2));

        box3.transfer(box2);

        System.out.println("Коробка1 с яблоками = " + box1.getWeight());
        System.out.println("Коробка2 с апельсинами = " + box2.getWeight());
        System.out.println("Коробка3 с апельсинами = " + box3.getWeight());

    }

    public static <T> void doTask1(T[] arr, int a, int b) {
        T tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
        for (T ar : arr) {
            System.out.println(ar);
        }
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println();
    }

    public static <T> void doTask2(T[] arr){
        ArrayList<T> arrayList = new ArrayList<>(Arrays.asList(arr));
        for (T a : arrayList){
            System.out.println(a);
        }
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println();
    }
}
