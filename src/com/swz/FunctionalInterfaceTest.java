package com.swz;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Package: com.swz
 * @Description: 函数式接口
 * @author: swz
 * @date: 2018/11/29 14:30
 */
public class FunctionalInterfaceTest {

    /**
     * 1.函数式接口(FunctionalInterface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口；
     * 函数式接口可以被隐式转换为Lambda表达式；
     * 函数式接口可以现有的函数友好地支持Lambda。
     * <p>
     * 2.函数式接口实例
     * Predicate <T> 接口是一个函数式接口，它接受一个输入参数 T，返回一个布尔值结果;
     * 该接口包含多种默认方法来将Predicate组合成其他复杂的逻辑（比如：与，或，非）;
     * 该接口用于测试对象是 true 或 false。
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Predicate<Integer> predicate = n -> n % 2 == 0;
        // 传递参数 n
        System.out.print("输出所有偶数: ");
        eval(list, predicate);
        Predicate<Integer> predicate2 = n -> n > 3;
        System.out.print("\n输出大于3的所有数字: ");
        eval(list, predicate2 );

    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer i : list) {
            if (predicate.test(i)) {
                System.out.print(i + " ");
            }
        }
    }

}
