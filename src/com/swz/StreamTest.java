package com.swz;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @Package: com.swz
 * @Description: 流Stream
 * @author: swz
 * @date: 2018/11/29 15:17
 */
public class StreamTest {

    /**
     * 1.Stream使用一种类似用SQL语句从数据库查询数据的直观方式来提供一种对Java集合运算和表达的高阶抽象;
     * Stream API可以极大提高Java程序员的生产力，让程序员写出高效率、干净、简洁的代码;
     * 这种风格将要处理的元素集合看作一种流，流在管道中传输，并且可以在管道的节点上进行处理，比如筛选，排序，聚合等;
     * 元素流在管道中经过中间操作（intermediate operation）的处理，最后由最终操作(terminal operation)得到前面处理的结果。
     * <p>
     * 2.Stream（流）是一个来自数据源的元素队列并支持聚合操作;
     * 元素：是特定类型的对象，形成一个队列。Java中的Stream并不会存储元素，而是按需计算;
     * 数据源 ：流的来源。可以是集合，数组，I/O channel，产生器generator等;
     * 聚合操作： 类似SQL语句一样的操作，比如filter, map, reduce, find,match, sorted等。
     * <p>
     * 3.Stream操作还有两个基础的特征：
     * a.Pipelining:：中间操作都会返回流对象本身。这样多个操作可以串联成一个管道，如同流式风格（fluent style）。
     * 这样做可以对操作进行优化，比如延迟执行(laziness)和短路( short-circuiting)。
     * b.内部迭代：以前对集合遍历都是通过Iterator或者For-Each的方式,显式的在集合外部进行迭代，这叫做外部迭代。
     * Stream提供了内部迭代的方式，通过访问者模式(Visitor)实现。
     */
    public static void main(String[] args) {

        // stream() −为集合创建串行流。
        // parallelStream() − 为集合创建并行流。
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);

        // Stream 提供了新的方法 'forEach' 来迭代流中的每个数据。以下代码片段使用forEach 输出了10个随机数
        // limit 方法用于获取指定数量的流。以下代码片段使用 limit 方法打印出 10 条数据
        // sorted 方法用于对流进行排序。以下代码片段使用 sorted 方法对输出的 10 个随机数进行排序
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);

        // map 方法用于映射每个元素到对应的结果，以下代码片段使用 map 输出了元素对应的平方数：
        List<Integer> numbers = Arrays.asList(3, 2, 3, 4, 3, 5);
        List<Integer> squaresList  = numbers.stream().map(i ->i*i).distinct().collect(Collectors.toList());
        System.out.println(squaresList);

        // filter 方法用于通过设置条件过滤出元素。以下代码片段使用filter 方法过滤出空字符串：
        List<String> strings2 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        int count = (int) strings2.stream().filter(string -> string.isEmpty()).count();
        System.out.println(count);

        // Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors可用于返回列表或字符串：
        List<String> strings3 = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered3 = strings3.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选列表: " + filtered3);
        String mergedString = strings3.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);
        // 一些产生统计结果的收集器也非常有用。它们主要用于int、double、long等基本类型上，它们可以用来产生类似如下的统计结果
        List<Integer> numbers2 = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers2.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());

    }

}
