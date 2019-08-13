package com.swz;

/**
 * @Package: com.swz
 * @Description: Lambda测试
 * @author: swz
 * @date: 2018/11/29 10:30
 */
public class LambdaTest {

    /**
     * 1. Lambda表达式的语法格式如下：
     * (parameters)->expression 或 (parameters)->{statements;}
     * 以下是Lambda表达式的重要特征：
     * a.可选类型声明：不需要声明参数类型，编译器可以统一识别参数值；
     * b.可选参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号；
     * c.可选的大括号：如果主体包含了一个语句，就不需要使用大括号；
     * d.可选的返回关键字：如果主体只有一个返回值则编译器会自动返主体回值，大括号需要指定表达式返回一个数值。
     * <p>
     * 2. 使用Lambda表达式主要用来定义执行行内执行的方法类型接口，例如，一个简单方法接口。在上面例子中，我们使用各种类型的Lambda表达式来
     * 定义MathOperation接口的方法，然后我们定义了sayMessage的执行。
     * Lambda表达式免去了使用匿名方法的麻烦，并且给予Java简单但强大的函数化的编程能力。
     * <p>
     * 3. Lambda表达式只能引用标记了final的外部局部变量，这就是说不能在Lambda内部修改定义在域外的局部变量，否则会编译错误。
     */
    final static String salutation = "Hello! ";

    public static void main(String[] args) {

        LambdaTest LambdaTest = new LambdaTest();
        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;
        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;
        // 大括号中的返回值
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };
        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + LambdaTest.operate(10, 5, addition));
        System.out.println("10 - 5 = " + LambdaTest.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + LambdaTest.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + LambdaTest.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message -> System.out.println("Hello " + message);
        // 用括号
        GreetingService greetService2 = (message) -> System.out.println(salutation + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");
    }

    interface MathOperation {
        int operatation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operatation(a, b);
    }

}
