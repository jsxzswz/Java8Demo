package com.swz;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.swz
 * @Description: 方法引用
 * @author: swz
 * @date: 2018/11/29 13:45
 */
public class MethodQuoteTest {

    /**
     * 1. 方法引用通过方法的名字来指向一个方法；
     * 方法引用可以使语言的构造更紧凑简洁，减少冗余代码；
     * 方法引用使用一对冒号::。
     **/
    public static void main(String[] args) {
        List names = new ArrayList<>();
        names.add("Google");
        names.add("SWZ");
        names.add("taobao");
        names.forEach(System.out::println);
    }

}
