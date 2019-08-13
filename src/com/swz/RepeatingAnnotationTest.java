package com.swz;

import java.lang.annotation.*;

/**
 * @Package: com.swz
 * @Description: 重复注解，拓宽注解的应用场景
 * @author: swz
 * @date: 2018/11/30 15:18
 */
public class RepeatingAnnotationTest {

    public static void main(String[] args) {
        for( Filter filter: Filterable.class.getAnnotationsByType( Filter.class ) ) {
            System.out.println( filter.value() );
        }
    }

    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    public @interface Filters {
        Filter[] value();
    }

    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    @Repeatable( Filters.class )
    public @interface Filter {
        String value();
    }

    @Filter( "filter1" )
    @Filter( "filter2" )
    public interface Filterable {
    }



}
