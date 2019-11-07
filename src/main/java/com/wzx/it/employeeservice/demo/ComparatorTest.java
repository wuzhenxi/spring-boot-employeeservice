package com.wzx.it.employeeservice.demo;

import java.util.ArrayList;
import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args) {
        AppleEntity appleEntity1 = new AppleEntity("red", 20, "Y");
        AppleEntity appleEntity2 = new AppleEntity("red", 30, "Y");
        AppleEntity appleEntity3 = new AppleEntity("green", 30, "N");
        AppleEntity appleEntity4 = new AppleEntity("green", 20, "Y");
        AppleEntity appleEntity5 = new AppleEntity("black", 40, "N");
        AppleEntity appleEntity6 = new AppleEntity("white", 7, "Y");
        ArrayList<AppleEntity> list = new ArrayList<>();
        list.add(appleEntity1);
        list.add(appleEntity2);
        list.add(appleEntity3);
        list.add(appleEntity4);
        list.add(appleEntity5);
        list.add(appleEntity6);

        Comparator<AppleEntity> colorDesc = Comparator.comparing(AppleEntity::getColor).reversed();

        Comparator<AppleEntity> weightAsc = Comparator.comparing(AppleEntity::getWeight);

        Comparator.comparing(AppleEntity::getWeight,(s1,s2)->{return s1.compareTo(s2);});

        Comparator<AppleEntity> finalComparator = colorDesc.thenComparing(weightAsc).thenComparing(AppleEntity::getAFlag);

        list.sort(finalComparator);

        list.forEach(System.out::println);

    }
}
