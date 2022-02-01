package com.jesperdj.java_level_17.b_switch;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * <a href="https://openjdk.java.net/jeps/361">JEP 361</a>: Switch Expressions.
 * <p>
 * Enhanced switch statements and switch expressions, standard feature since JDK 14.
 */
public class BetterSwitchStatement {

    public static void main(String[] args) {
        DayOfWeek today = LocalDate.now().getDayOfWeek();

        // There are a number of problems with switch statements:
        // - You need a 'break' statement for each case, otherwise you get fallthrough behavior. This is a source of bugs.
        // - The block of the switch statement is a single scope. You cannot declare two variables with the same name for different cases.
        // - It is a statement instead of an expression (it doesn't evaluate to a value).
        switch (today) {
            case MONDAY:
                System.out.println("Start of the week");
                break;
            case TUESDAY:
                System.out.println("Get to work");
                break;
            case WEDNESDAY:
                System.out.println("Halfway through");
            case THURSDAY:
                System.out.println("Keep on going");
                break;
            case FRIDAY:
                System.out.println("Almost weekend");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Relax");
                break;
            default:
                throw new IllegalArgumentException(today.toString());
        }

        // There is a new syntax for switch which uses -> (arrow) instead of : (colon) for the cases.
        // When you use this, you don't need 'break' anymore, and you can write this in a more concise way.
        // You can specify a case that matches multiple values by using a comma (for example: case SATURDAY, SUNDAY).
        switch (today) {
            case MONDAY -> System.out.println("Start of the week");
            case TUESDAY -> System.out.println("Get to work");
            case WEDNESDAY -> System.out.println("Halfway through");
            case THURSDAY -> System.out.println("Keep on going");
            case FRIDAY -> System.out.println("Almost weekend");
            case SATURDAY, SUNDAY -> System.out.println("Relax");
            default -> throw new IllegalArgumentException(today.toString());
        }
    }
}
