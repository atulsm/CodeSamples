package org.example.wordmath;

public class CommandLineTextInput implements TextInput {
    public String[] getTestInput() {
        return new String[] {
            "one plus one",
            "two minus one",
            "three multiplied by two",
            "four divided by two"/*,
            "one plus two plus three",
            "nine minus five minus six",
            "seven multiplied by four multiplied by three",
            "eight divided by four divided by two",
            "one plus two minus three multiplied by four divided by five",
            "one plus two minus three multiplied by four divided by five plus six minus seven multiplied by eight plus nine divided by ten"
       */
        };
    }
}
