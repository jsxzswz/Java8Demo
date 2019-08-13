package com.swz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Package: com.swz
 * @Description: 测试
 * @author: swz
 * @date: 2019/1/22 14:20
 */
public class Test {

    public static void main(String[] args) {
        int[] ints = new int[]{2, 324, 4, 57, 1};
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
        List lists = new ArrayList<>();
        lists.add(2);
        lists.add(324);
        lists.add(4);
        lists.add(57);
        lists.add(1);
        Collections.sort(lists);
        System.out.println(lists);

    }
}
