package com.swz;

import java.util.Optional;

/**
 * @Package: com.swz
 * @Description: Optional类
 * @author: swz
 * @date: 2018/11/30 11:25
 */
public class OptionalTest {

    /**
     * 1.Optional类是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象；
     * Optional十个容器：它可以保存类型为T的值，或仅仅保存null；
     * Optional类的引入很好的解决空指针异常。
     */

    public static void main(String[] args) {

        OptionalTest optionalTest = new OptionalTest();
        Integer value1 = null;
        Integer value2 = new Integer(10);
        // 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(value1);
        // 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(value2);
        System.out.println(optionalTest.sum(a, b));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b) {
        // 判断值是否存在
        System.out.println("第一个参数值存在： " + a.isPresent());
        System.out.println("第二个参数值存在： " + b.isPresent());
        // 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(new Integer(0));
        Integer value2 = b.get();
        return value1 + value2;
    }

}
