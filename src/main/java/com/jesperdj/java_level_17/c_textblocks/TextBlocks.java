package com.jesperdj.java_level_17.c_textblocks;

import java.math.BigDecimal;

/**
 * <a href="https://openjdk.java.net/jeps/378">JEP 378</a>: Text Blocks.
 * <p>
 * Text blocks, standard since JDK 15.
 */
public class TextBlocks {

    public static void main(String[] args) {
        // Consider this example of a string literal containing formatted JSON. It is hard to write and hard to read.
        // Escape sequences and string concatenation make it hard to see what's part of the JSON and what's Java syntax.
        String json1 = "{\n" +
                "    \"name\": \"Notepad\",\n" +
                "    \"description\": \"100 sheets\",\n" +
                "    \"price\": 2.95\n" +
                "}\n";
        System.out.println(json1);

        // You can now use a text block to make this much more readable. Things to note:
        // - It starts with triple quotes and a newline and ends with triple quotes.
        // - You don't need to escape quotes inside the text block.
        // - Newlines in the text block are included in the resulting string, except the newline after the opening triple quotes
        //     (that is considered part of the opening delimiter of the text block).
        // - Leading indentation spaces are automatically stripped.
        // - Trailing spaces are automatically stripped from every line.
        String json2 = """
                {
                    "name": "Notepad",
                    "description": "100 sheets",
                    "price": 2.95
                }
                """;
        System.out.println("#" + json2 + "#");

        // How much space is considered to be indentation depends on the placement of the leftmost character in any of the lines in the text block,
        // including the line with the ending triple quotes.
        // IntelliJ shows you with a vertical line where the content of the text block starts.
        String json3 = """
                  {
                      "name": "Notepad",
                      "description": "100 sheets",
                      "price": 2.95
                  }
                """;
        System.out.println("#" + json3 + "#");

        // Use a backslash at the end of a line to prevent a newline from being inserted there.
        String json4 = """
                {
                    "name": "Notepad", \
                    "description": "100 sheets", \
                    "price": 2.95
                }
                """;
        System.out.println("#" + json4 + "#");

        // One feature that developers ask for which is related to text blocks, is string interpolation (other programming languages have this feature).
        // That is not yet available in Java, but might be added in the future. You can now use the 'formatted(...)' method which replaces percent-sign
        // placeholders.
        String name = "Notepad";
        String description = "100 sheets";
        BigDecimal price = new BigDecimal("2.95");
        String json5 = """
                {
                    "name": "%s",
                    "description": "%s",
                    "price": %s
                }
                """.formatted(name, description, price);
        System.out.println(json5);
    }
}
