package com.swz;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @Package: com.swz
 * @Description: Nashorn, javascript 引擎。
 * @author: swz
 * @date: 2018/11/30 14:11
 */
public class NashornTest {

    /**
     * 1.Nashorn 一个 javascript 引擎。
     * 从JDK1.8开始，Nashorn取代Rhino(JDK 1.6, JDK1.7)成为Java的嵌入式JavaScript引擎。Nashorn完全支持ECMAScript 5.1规范
     * 以及一些扩展。它使用基于JSR292的新语言特性，其中包含在JDK 7中引入的 invokedynamic，将JavaScript编译成Java字节码。
     * 与先前的Rhino实现相比，这带来了2到10倍的性能提升。
     * <p>
     * 2.jjs是个基于Nashorn引擎的命令行工具。它接受一些JavaScript源代码为参数，并且执行这些源代码
     * <p>
     * 3.使用ScriptEngineManager, JavaScript 代码可以在 Java 中执行
     */
    public static void main(String[] args) {

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
        String name = "Runoob";
        Integer result = null;

        try {
            nashorn.eval("print('" + name + "')");
            result = (Integer) nashorn.eval("10 + 2");
        } catch (ScriptException e) {
            System.out.println("执行脚本错误: " + e.getMessage());
        }
        System.out.println(result.toString());
    }
}
