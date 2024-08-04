package com.example.practicejava.family;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        // HashSet 예시
        Set<String> hashSet = new HashSet<>();
        hashSet.add("apple");
        hashSet.add("banana");
        hashSet.add("orange");
        System.out.println("HashSet: " + hashSet);

        // LinkedHashSet 예시
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("apple");
        linkedHashSet.add("banana");
        linkedHashSet.add("orange");
        System.out.println("LinkedHashSet: " + linkedHashSet);

        // TreeSet 예시
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("apple");
        treeSet.add("banana");
        treeSet.add("orange");
        System.out.println("TreeSet: " + treeSet);

        // EnumSet 예시
        enum Fruit { APPLE, BANANA, ORANGE }
        Set<Fruit> enumSet = EnumSet.of(Fruit.APPLE, Fruit.BANANA);
        System.out.println("EnumSet: " + enumSet);
    }
}
