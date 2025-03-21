package com.lambda;

import org.junit.Test;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestLambda {

    /**
     * 方法引用，Lambda的快捷方式
     */

    @Test
    public void testLambdaMethodReference() {
        // 静态方法引用
        Function<String, Integer> stringToInteger1 = (a) -> Integer.parseInt(a);
        System.out.println(stringToInteger1.apply("12345"));
        Function<String, Integer> stringToInteger2 = Integer::parseInt;

        // 实例方法引用（指向特定对象）
        Consumer<String> printString1 = (a) -> System.out.println(a);
        Consumer<String> printString2 = System.out::println;

        // 实例方法引用（指向任意对象）
        Function<String, Integer> stringLength1 = (a) -> a.length();
        Function<String, Integer> stringLength2 = String::length;
        BiPredicate<List<String>, String> contains1 = (a, b) -> a.contains(b);
        BiPredicate<List<String>, String> contains2 = List::contains;

        BiPredicate<Map<String, Object>, String> bi1 = (a, b) -> a.containsKey(b);
        BiPredicate<Map<String, Object>, String> bi2 = Map::containsKey;
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("abc", 123);
        boolean a = bi2.test(hashMap, "abc");
        System.out.println(a);

    }

    /**
     * 构造函数引用，Lambda的快捷方式
     */
    @Test
    public void testLambdaConstructReference() {
        // 无参构造函数引用
        Supplier<List<String>> s1 = () -> new ArrayList<>();
        Supplier<List<String>> s2 = LinkedList::new;
        List<String> strings = s2.get();

        // 有参构造函数引用
        Function<Integer, String[]> f1 = (t) -> new String[t];
        Function<Integer, String[]> f2 = String[]::new;

        Function<Integer, Map<String, Object>> f3 = (t) -> new HashMap<>(t);
        Function<Integer, Map<String, Object>> f4 = HashMap::new;


    }
}
