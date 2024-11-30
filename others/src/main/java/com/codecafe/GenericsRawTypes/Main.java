package com.codecafe.GenericsRawTypes;

public class Main {
    public static void main(String[] args) {


        //To create a parameterized type of Box<T>, you supply an actual type argument for the
        // formal type parameter T:
        Box<Integer> intBox = new Box<>();

        // If the actual type argument is omitted, you create a raw type of Box<T>
        Box rawBox = new Box();
        //Therefore, Box is the raw type of the generic type Box<T>.
        // However, a non-generic class or interface type is not a raw type.

        //For backward compatibility, assigning a parameterized type to its raw type is allowed:
        Box<String> stringBox = new Box<>();
        Box raw = stringBox;

        //But if you assign a raw type to a parameterized type, you get a warning:
        Box box = new Box();
        Box<String> b = box; // Warning : Unchecked Assignment

        //You also get a warning if you use a raw type to invoke
        //generic methods defined in the corresponding generic type:

        Box<String> s1 = new Box<>();
        Box s2 = s1;
        s2.set("Hello"); // Warning : Unchecked Invocation

        //Note:Important - The warning shows that raw types bypass generic type checks,
        // deferring the catch of unsafe code to runtime. Therefore, you should avoid using raw types.

        //---------UNCHECKED ERROR MESSAGES---------//
        //when mixing legacy code with generic code, you may encounter warning messages similar to the following:

        //Note: Example.java uses unchecked or unsafe operations.
        //Note: Recompile with -Xlint:unchecked for details.

       Box<Integer> bi;
       bi = createBox(); // Warning : Unchecked Assignment

        //The term "unchecked" means that the compiler does not have enough type information
        // to perform all type checks necessary to ensure type safety. The "unchecked" warning
        // is disabled, by default, though the compiler gives a hint. To see all "unchecked"
        // warnings, recompile with "-Xlint:unchecked".

        //To completely disable unchecked warnings, use the -Xlint:-unchecked flag.
        // The @SuppressWarnings("unchecked") annotation suppresses unchecked warnings

    }


    static Box createBox(){
        return new Box();
    }


}
