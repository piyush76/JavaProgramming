package com.piyush.learning.basicjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by piyush on 6/25/14.
 *
 * code to check if abstract classes perform better than interfaces
 *
 */
public class DesignInterfaceAbstractTest {


    public static void main(String[] args) {
        Random random = new Random();

        List<Foo> foos = new ArrayList<Foo>(40000);

        List<Bar> bars = new ArrayList <Bar> (40000);

        for (int i = 0; i < 40000; i++) {
            foos.add(random.nextBoolean() ? new Foo1Impl() : new Foo2Impl());
            bars.add(random.nextBoolean() ? new Bar1Impl() : new Bar2Impl());
        }

        long start = System.nanoTime();

        for (Foo foo : foos) {
            foo.foo();
        }

        System.out.println("interface " +  (System.nanoTime() - start));

        start = System.nanoTime();

        for (Bar bar : bars) {
            bar.bar();
        }

        System.out.println("Abstract class " +  (System.nanoTime() - start));

    }

    abstract static class Foo {
        public abstract int foo();
    }

    static interface Bar {
        int bar();
    }

   public static class Foo1Impl extends Foo {

        @Override
        public int foo() {
            int i = 10;
            i++;
            return i;
        }
    }

    public static class Foo2Impl extends Foo {
        @Override
        public int foo() {
            int i = 10;
            i++;
            return i;
        }
    }

    static class Bar1Impl implements Bar {
        @Override
        public int bar() {
            int i = 10;
            i++;
            return i;
        }
    }
    static class Bar2Impl implements Bar {
        @Override
        public int bar() {
            int i = 10;
            i++;
            return i;
        }
    }
}
