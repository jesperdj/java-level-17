package com.jesperdj.java_level_17.h_preview;

/**
 * <a href="https://openjdk.java.net/jeps/406">JEP 406</a>: Pattern Matching for switch (Preview).
 * <p>
 * The next step in pattern matching: using it in switch expressions. Preview in JDK 17, second preview in JDK 18 (March 2022).
 * Expected to become a standard feature in a future Java version, maybe in JDK 19 (September 2022).
 */
public class PatternMatchingSwitch {

    public static void main(String[] args) {
        var root = new InnerNode(
                new InnerNode(new LeafNode(1), new InnerNode(new LeafNode(3), new LeafNode(5))),
                new InnerNode(new InnerNode(new LeafNode(2), new LeafNode(4)), new LeafNode(6)));

        System.out.println(sum(root));
        System.out.println(sumEven(root));
    }

    public static int sum(Node node) {
        // With this preview feature, you can switch on the type of the value.
        // Just like with pattern matching for instanceof, you can use a type pattern after the 'case' keyword.
        // Note that since this is a switch expression, the compiler must check for exhaustiveness: there must be a case for every possible value.
        // We have a closed class hierarchy, with sealed interface Node and two records that implement it, so in this example we do not need a default case.
        // See what happens here if we open up the class hierarchy by adding a non-sealed class (see below).
        return switch (node) {
            case InnerNode inner -> sum(inner.left()) + sum(inner.right());
            case LeafNode leaf -> leaf.value();
        };

        // In future versions of Java, you will probably be able to destructure records using pattern matching, so that you could write something like this:
//        return switch (node) {
//            case InnerNode(Node left, Node right) -> sum(left, right);
//            case LeafNode(int value) -> value;
//        };
    }

    public static int sumEven(Node node) {
        // You can also add extra conditions after '&&', just like with pattern matching for instanceof.
        return switch (node) {
            case InnerNode inner -> sumEven(inner.left()) + sumEven(inner.right());
            case LeafNode leaf && leaf.value() % 2 == 0 -> leaf.value();
            default -> 0;
        };
    }
}

// Binary tree node.
// One more detail about sealed classes and interfaces: if the subclasses or implementors are defined in the same source file,
// then the 'permits' clause is not necessary.
sealed interface Node {}

record InnerNode(Node left, Node right) implements Node {}
record LeafNode(int value) implements Node {}

// Try uncommenting this non-sealed class and see what happens with the switch expression in the sum() method.
// non-sealed class SpecialNode implements Node {}
