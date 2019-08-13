package com.swz;

/**
 * @Package: com.swz
 * @Description: 默认方法
 * @author: swz
 * @date: 2018/11/29 15:01
 */
public class DefaultMethodTest {

    /**
     * 1.简单说，默认方法就是接口可以有实现方法，而且不需要实现类去实现其方法;
     * 我们只需在方法名前面加个default关键字即可实现默认方法。
     * 默认方法是为了解决接口的修改与现有的实现不兼容的问题。
     * <p>
     * 2.另一个特性是接口可以声明（并且可以提供实现）静态方法
     */
    public static void main(String[] args) {
        Vehicle vehicle = new Car();
        vehicle.print();
    }

     interface Vehicle {
        default void print() {
            System.out.println("我是一辆车!");
        }

        // 静态方法
        static void blowHorn() {
            System.out.println("按喇叭!!!");
        }
    }

     interface FourWheeler {
        default void print() {
            System.out.println("我是一辆四轮车!");
        }
    }

    static class Car implements Vehicle, FourWheeler {

        //@Override
        //public void print() {
        //    System.out.println("我是一辆四轮汽车!");
        //}
        public void print() {
            Vehicle.super.print();
            FourWheeler.super.print();
            Vehicle.blowHorn();
            System.out.println("我是一辆汽车!");
        }
    }

}
