package com.jesperdj.java_level_17.d_patternmatching;

import java.util.Random;

/**
 * <a href="https://openjdk.java.net/jeps/394">JEP 394</a>: Pattern Matching for instanceof.
 * <p>
 * Pattern matching for instanceof, standard since JDK 16.
 */
public class PatternMatchingInstanceof {

    public static void main(String[] args) {
        Object value = getValue();

        // A problem when you use instanceof in an if-statement: Inside the block, you are required to use a type cast, even though you already know that
        // the value is of the type that you are casting to. The cast will never fail, so it shouldn't be necessary.
        if (value instanceof String) {
            String str = (String) value;
            System.out.println(str.toUpperCase());
        }

        // Since Java 16, you can use the following syntax to declare the variable 'str', so that you need the explicit type cast anymore.
        if (value instanceof String str) {
            System.out.println(str.toUpperCase());
        }

        // It goes further than this. Take a look at the following example.
        if (value instanceof String str) {
            if (str.length() > 4) {
                System.out.println(str.toUpperCase());
            }
        }

        // To get rid of the nested if-statements, you can add the condition of the inner if-statement to the outer one.
        // You can use the variable defined in the instanceof expression in any place where it is 'definitely assigned'.
        if (value instanceof String str && str.length() > 4) {
            System.out.println(str.toUpperCase());
        }

        // This would not work (it's not even clear what this is supposed to mean when value is not a String).
//        if (value instanceof String str || str.length() > 4) { ... }
    }

    private static Object getValue() {
        if (new Random().nextBoolean()) {
            return "Hello World";
        } else {
            return 42;
        }
    }
}
