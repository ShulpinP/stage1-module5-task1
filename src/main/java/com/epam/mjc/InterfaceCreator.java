package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase (){
        return x -> x.stream().allMatch(word -> Character.isUpperCase(word.charAt(0)));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> x.addAll((x.stream().filter(elem -> elem % 2 ==0)).toList());
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream().filter(value -> Character.isUpperCase(value.charAt(0))).
                filter(value ->value.charAt(value.length()-1) == '.').
                filter(value ->value.split(" ").length > 3).toList();

    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> x.stream().collect(Collectors.toMap(String :: toString, String :: length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> Stream.concat(list1.stream(),list2.stream()).toList();
    }
}
