package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataTransformDemo {
    public static void main(String[] args) {

        DataTransform<Integer> doubleValue = num -> num * 2;
        System.out.println(doubleValue);
        System.out.println(doubleValue.transform(2));

        DataTransform<String> addPrefix = string -> "prefixe-" +string;
        System.out.println(addPrefix.transform("apres"));

        DataTransform<List<Integer>> sortList = list ->{
            Collections.sort(list);
            return list;
        };

        List<Integer> numbers = Arrays.asList(912, 21, 6984 , 68);
        System.out.println(sortList.transform(numbers));


    }
}
