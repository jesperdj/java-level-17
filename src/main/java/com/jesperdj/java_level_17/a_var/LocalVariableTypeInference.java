package com.jesperdj.java_level_17.a_var;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.function.Predicate;

/**
 * <a href="https://openjdk.java.net/jeps/286">JEP 286</a>: Local-Variable Type Inference.
 * <p>
 * The 'var' reserved type name, standard feature since JDK 10.
 */
public class LocalVariableTypeInference {

    public static void main(String[] args) {
        // The syntax of Java can be verbose. Note how on the left side and right side of the '=' in this variable declaration, you have to repeat yourself.
        HashMap<Integer, String> map1 = new HashMap<Integer, String>();

        // The 'diamond operator' was added to JDK 7 to make this a little more concise in case you are using generic types, but we still have to tell the
        // compiler that this is a HashMap twice.
        HashMap<Integer, String> map2 = new HashMap<>();

        // With the 'var' reserved type name, you can make this better.
        var map3 = new HashMap<Integer, String>();

        // Note that this does not make Java a dynamically typed language like JavaScript. You cannot assign a value of a completely different type
        // to the same variable later. Java is still statically typed; by using 'var', you are telling the compiler to figure out the type by itself.
//        map3 = new ArrayList<String>(); // Error: incompatible types

        // You don't have to initialize the variable using 'new' or by using a literal value. You can also initialize it with the return value of a method,
        // for example; it works as long as the compiler is able to determine the type.
        var path = Paths.get("image.png");

        // You must initialize the variable in the same statement as the declaration. You cannot first declare the variable and then initialize it.
//        var name;
//        name = "Jesper";

        // Initializing the variable with null is not allowed. Any reference type can be null, so this is not enough information to determine the intended type.
//        var empty = null;

        // You can use the diamond operator together with 'var'. The type parameters will then be inferred to the type java.lang.Object, so the type of map4
        // here is HashMap<Object, Object>.
        var map4 = new HashMap<>();

        // You cannot assign a lambda expression or method reference directly to a variable declared with 'var'. The compiler needs to be able to determine the
        // target type of the lambda expression or method reference, and when you use 'var' there is not enough information to determine the target type.
        Predicate<String> p1 = s -> s.isEmpty();
//        var p2 = s -> s.isEmpty();
//        var p3 = (String s) -> s.isEmpty();
//        var p4 = String::isEmpty;

        // Note that 'var' is not a keyword, but a reserved type name. This is for backward compatibility; people might have used the name 'var' as a variable
        // name. By making it a reserved type name and not a keyword, it's still possible to use 'var' as a variable name.
        var var = "var";
    }
}
