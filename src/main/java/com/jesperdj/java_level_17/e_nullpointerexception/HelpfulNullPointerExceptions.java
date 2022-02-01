package com.jesperdj.java_level_17.e_nullpointerexception;

/**
 * <a href="https://openjdk.java.net/jeps/358">JEP 358</a>: Helpful NullPointerExceptions.
 * <p>
 * NullPointerExceptions that tell you what exactly is null, since JDK 14.
 */
public class HelpfulNullPointerExceptions {

    public static void main(String[] args) {
        Customer customer = new Customer();
        Address address = new Address();
        customer.setAddress(address);

        // In Java before version 14, the following line would produce the following error message at runtime:
        // Exception in thread "main" java.lang.NullPointerException
        //   at com.jesperdj.java17.e_nullpointerexception.HelpfulNullPointerExceptions.main(HelpfulNullPointerExceptions.java:18)
        System.out.println(customer.getAddress().getCity().toUpperCase());

        // This does not tell you what exactly is null: it could be the variable 'customer', or the return value of any of the methods in the chain.
        // When you use Java 14 and newer, it tells you exactly what is null, saving you time when debugging:
        // Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.toUpperCase()"
        //     because the return value of "com.jesperdj.java17.e_nullpointerexception.Address.getCity()" is null
        //   at com.jesperdj.java17.e_nullpointerexception.HelpfulNullPointerExceptions.main(HelpfulNullPointerExceptions.java:18)

        // If your code is compiled with the '-g' option to include debug information in the class file, then it can also include the name of local variables
        // that are null in the error message.
        String text = null;
        System.out.println(text.toUpperCase());

        // To see the difference when you use IntelliJ: Preferences > Build, Execution, Deployment > Compiler > Java Compiler > check or uncheck
        // Generate debugging info and rebuild the project after changing this setting (Build > Rebuild Project).
    }
}
