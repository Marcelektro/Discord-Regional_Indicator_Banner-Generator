package net.marcelektro;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.HashMap;
import java.util.Scanner;


/**
 * Welcome to my funny project, in which I try to make a Discord util tool, so I can easier make my channel titles.
 * I basically publish that, because I want to test using VCS (my first yes)
 */

public class Main {
    private static final String textIndicator = ":regional_indicator_%s: ";
    private static final String numberIndicator = ":%s: ";
    private static final String star = ":asterisk: ";
    private static final String hash = ":hash: ";
    private static final String exclamationPoint = ":grey_exclamation: ";
    private static final String questionMark = ":grey_question: ";

    private static final HashMap<Integer, String> numbers = new HashMap<>() { {
        put(0, "zero");
        put(1, "one");
        put(2, "two");
        put(3, "three");
        put(4, "four");
        put(5, "five");
        put(6, "six");
        put(7, "seven");
        put(8, "eight");
        put(9, "nine");
    } };

    /**
     * Main method of that project
     * @param args Args :D
     */
    public static void main(String... args) {

        System.out.println("--------------------------------------------");
        System.out.println("Welcome to RegionalIndicator Generator!");
        System.out.println("I like anime and cats UwU =(^-^)=");
        System.out.println("--------------------------------------------");

        while (true) { // Beautiful!
            System.out.println("Enter a text, so it can become a nice banner!");
            System.out.print("> ");

            String input = new Scanner(System.in).nextLine();
            String result = makeRegionalText(input);

            StringSelection stringSelection = new StringSelection(result);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, stringSelection);

            System.out.printf("Your text (%s) has been turned into a banner and is copied into your clipboard!%n", input);
        }

    }

    /**
     * <h2>Generates a cool looking Discord banner, that can be pasted to flex your power <br>(lmao)</h2>
     * <p>
     * Following letters will be looking nicely: (the rest will be just a text)
     *  <ul>
     *      <li>Alphanumeric (a-z)</li>
     *      <li>Numbers (0-9)</li>
     *      <li>Star (*)</li>
     *      <li>Hash (#)</li>
     *      <li>Exclamation point (!)</li>
     *      <li>Question mark (?)</li>
     *  </ul>
     * @param input A text to be converted into a banner
     * @return Nice looking text with regional indicator
     */
    private static String makeRegionalText(String input) {
        StringBuilder out = new StringBuilder();

        for (char c : input.toCharArray()) {

            if (Character.isSpaceChar(c)) {
                out.append("  ");
            } else if (Character.isAlphabetic(c)) {
                out.append(String.format(textIndicator, Character.toLowerCase(c)));
            } else if (Character.isDigit(c)) {
                out.append(String.format(numberIndicator, numbers.get(Character.getNumericValue(c))));
            } else if (c == '*') {
                out.append(star);
            } else if (c == '#') {
                out.append(hash);
            } else if (c == '!') {
                out.append(exclamationPoint);
            } else if (c == '?') {
                out.append(questionMark);
            } else {
                out.append(c);
            }

        }

        return out.toString();
    }
}
