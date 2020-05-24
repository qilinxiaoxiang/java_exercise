package com.wsbo.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleTest {
    @Test
    public void testArrayClass() {
        Class[] classes = new Class[]{int[].class, int.class, Integer.class, Long.class, Long[].class, long[].class, BigDecimal.class, String.class, String[].class, List.class, ArrayList.class};
        System.out.println("isSimple | isSynthetic | isList |class");
        Arrays.stream(classes).forEach(c -> {
            System.out.println(BeanUtils.isSimpleValueType(c) + ":" + c.isSynthetic() + ":" + List.class.isAssignableFrom(c) + ":" + c.toString());
        });

    }

    @Test
    public void testEmptyForEach() {
        List<String> list = new ArrayList<>();
        System.out.println("empty start");
        list.forEach(System.out::println);
        System.out.println("empty end");
        list = null;
        System.out.println("null start");
        list.forEach(System.out::println);
        System.out.println("null end");
    }

    @Test
    public void testArray() {
        int[] ints = new int[]{};
    }
}
