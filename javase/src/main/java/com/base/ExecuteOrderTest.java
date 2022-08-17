package com.base;

/**
 * class B extends A ,然后A类也就是父类里面有静态代码块，普通代码块，静态方法，静态成员变量，普通成员变量，普通方法。<br>
 * 子类也是这样，然后继承之后，关于程序打印输出的结果。<br>
 * <br>
 * 结论：<br>
 * 1.父类【静态成员】和【静态代码块】，按在代码中出现的顺序依次执行。<br>
 * 2.子类【静态成员】和【静态代码块】，按在代码中出现的顺序依次执行。<br>
 * 3.父类的【普通成员变量被普通成员方法赋值】和【普通代码块】，按在代码中出现的顺序依次执行。<br>
 * 4.执行父类的构造方法。<br>
 * 5.子类的【普通成员变量被普通成员方法赋值】和【普通代码块】，按在代码中出现的顺序依次执行。<br>
 * 6.执行子类的构造方法。<br>
 *
 * @author fanjie
 * @date 2022/8/17 14:34
 */
public class ExecuteOrderTest {
    public static void main(String[] args) {
        new Children();
    }

    static class Parent {
        private static final String NAME = "parent";
        private static final String template = "[%s] —— %s%n";

        public Parent() {
            System.out.printf(template, NAME, "构造方法");
        }

        private static String staticStringParent = staticMethod();
        private String stringParent = method();

        static {
            System.out.printf(template, NAME, "静态代码块");
        }

        {
            System.out.printf(template, NAME, "普通代码块");
        }

        private static String staticMethod() {
            System.out.printf(template, NAME, "静态成员");
            return "staticMethod";
        }

        private String method() {
            System.out.printf(template, NAME, "普通成员");
            return "method";
        }
    }

    static class Children extends Parent {
        private static final String NAME = "children";
        private static final String template = "[%s] —— %s%n";

        public Children() {
            System.out.printf(template, NAME, "构造方法");
        }

        private static String staticStringParent = staticMethod();
        private String stringParent = method();

        static {
            System.out.printf(template, NAME, "静态代码块");
        }

        {
            System.out.printf(template, NAME, "普通代码块");
        }

        private static String staticMethod() {
            System.out.printf(template, NAME, "静态成员");
            return "staticMethod";
        }

        private String method() {
            System.out.printf(template, NAME, "普通成员");
            return "method";
        }
    }

}
