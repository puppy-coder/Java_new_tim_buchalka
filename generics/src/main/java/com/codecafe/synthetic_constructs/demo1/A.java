package com.codecafe.synthetic_constructs.demo1;

import java.lang.reflect.Method;

public class A<T extends B & C & D> {
    private final T element;

    public A(T t) {
        this.element = t;
    }

    public T get() {
        return element;
    }

    public static void main(String[] args) {
        A<Element> a1 = new A<>(new Element());
        B e = a1.get();
        C c = a1.get();
        D d = a1.get();
        Element f = a1.get();

        Method[] methods = A.class.getDeclaredMethods();

        for (Method m : methods) {
            System.out.println("Method: " + m.getName() + ", isSynthetic: " + m.isSynthetic());
        }
    }
}
