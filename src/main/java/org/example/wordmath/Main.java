package org.example.wordmath;

/**
 * Application which allows to perform mathematical operations on words.
 * eg: "one plus one" -> "two"
 */
public class Main {
    public static void main(String[] args) {
        WordMath wordMath = new WordMath();
        TextInput textInput = new CommandLineTextInput();
        for (String input : textInput.getTestInput()) {
            System.out.println(input + " -> " + wordMath.calculate(input));
        }
    }

}
