package com.jesperdj.java_level_17.b_switch;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * <a href="https://openjdk.java.net/jeps/361">JEP 361</a>: Switch Expressions.
 * <p>
 * Enhanced switch statements and switch expressions, standard feature since JDK 14.
 */
public class SwitchExpressions {

    public static void main(String[] args) {
        DayOfWeek today = LocalDate.now().getDayOfWeek();

        // You can now also use switch as an expression, which means that it evaluates to a value that you can assign to a variable.
        // When you do this, then what's after the arrow for each case is the result value for that case.
        // Note that a semicolon is now required after the closing curly brace.
        var message1 = switch (today) {
            case MONDAY -> "Start of the week";
            case TUESDAY -> "Get to work";
            case WEDNESDAY -> "Halfway through";
            case THURSDAY -> "Keep on going";
            case FRIDAY -> "Almost weekend";
            case SATURDAY, SUNDAY -> "Relax";
        };
        System.out.println(message1);

        // Instead of a value, you can also write a block for a case. Use the new 'yield' keyword inside the block to return the result value.
        var message2 = switch (today) {
            case MONDAY -> {
                if (LocalTime.now().getHour() < 10) {
                    yield "Get some coffee and turn on your computer";
                } else {
                    yield "Read documents";
                }
            }
            case TUESDAY -> "Get to work";
            case WEDNESDAY -> "Halfway through";
            case THURSDAY -> "Keep on going";
            case FRIDAY -> "Almost weekend";
            case SATURDAY, SUNDAY -> "Relax";
        };
        System.out.println(message2);

        // When the values of the cases in a switch expression have different types, and you use 'var' to declare the variable that you're assigning the result
        // to, the compiler will compute a type that's general enough to hold any of the possible values. This can lead to strange, surprising types.
        var message3 = switch (today) {
            case MONDAY -> "Start of the week";
            case TUESDAY -> "Get to work";
            case WEDNESDAY -> 3;
            case THURSDAY -> "Keep on going";
            case FRIDAY -> "Almost weekend";
            case SATURDAY, SUNDAY -> "Relax";
        };

        // This will print java.lang.String, but according to IntelliJ the type of 'message3' is something complicated.
        // Replacing 'var' by 'String' above also doesn't work.
        System.out.println(message3.getClass().getName());
    }
}
