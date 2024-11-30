package com.codecafe.GenericBoundedTypeParameters;

public class Box<T> {

    //There may be times when you want to restrict the types that can be used as type arguments
    // in a parameterized type. For example, a method that operates on numbers might only want to accept
    // instances of Number or its subclasses. This is what bounded type parameters are for.

    private T t;

    public void set(T t){
        this.t = t;
    }

    public T get(){
        return t;
    }

    public <U extends Number> void inspect(U u){
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }

}
