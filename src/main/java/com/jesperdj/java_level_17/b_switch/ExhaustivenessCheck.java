package com.jesperdj.java_level_17.b_switch;

import java.util.Random;

/**
 * <a href="https://openjdk.java.net/jeps/361">JEP 361</a>: Switch Expressions.
 * <p>
 * Enhanced switch statements and switch expressions, standard feature since JDK 14.
 */
public class ExhaustivenessCheck {

    enum Status {
        NEW, PROCESSING, SUCCESS, FAILURE
    }

    public static void main(String[] args) {
        Random random = new Random();

        // An advantage of switch expressions over switch statements is that the compiler will check that there is a case that covers every possible
        // input value. This is necessary because an expression must always result in a value.
        // This is especially nice with enums, because it protects you from a bug when you forget to add a case for an enum constant (as long as you don't
        // have a default case). Also, if you add a constant to the enum later, the switch expression will not compile anymore.
        Status status = Status.values()[random.nextInt(Status.values().length)];
        var message2 = switch (status) {
            case NEW -> "New";
            case PROCESSING -> "Processing...";
            case SUCCESS -> "Success";
            case FAILURE -> "Failed";
        };
        System.out.println(message2);
    }
}
