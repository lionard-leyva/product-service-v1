package com.oneclick.productservice.testbuilders;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ReduceTest {

    @Test
    public void test() {
        List<Integer> gastos = new ArrayList<>();
        int total = 0;
        gastos.add(10);
        gastos.add(20);
        gastos.add(30);
        //Aqui reduce nos devuelve un Optional<Integer> y si no hay ninguna suma, nos devuelve un Optional.empty()
        //el identiity es el valor por defecto de la funcion reduce es o si o podriaser 1
        gastos.stream().reduce(Integer::sum).ifPresent(System.out::println);
        System.out.println(total);
    }
}
