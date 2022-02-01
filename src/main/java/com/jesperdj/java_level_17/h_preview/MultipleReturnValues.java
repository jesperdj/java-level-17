package com.jesperdj.java_level_17.h_preview;

/**
 * This is just speculation!
 * <p>
 * If we get more powerful pattern matching with destructuring of records, a world of possibilities will open up. For example, it will be possible to work
 * with multiple return values easily.
 */
public class MultipleReturnValues {

    public static void main(String[] args) {
        var highscore = findTopScore();
        System.out.printf("Congratulations to %s for %d points", highscore.name(), highscore.score());

        // Imaginary syntax for destructuring the record returned by findTopScore().
//        var (score, name) = findTopScore();
//        System.out.printf("Congratulations to %s for %d points", name, score);
    }

    public static HighScore findTopScore() {
        return new HighScore(100000L, "Wizard");
    }
}

record HighScore(long score, String name) {}
