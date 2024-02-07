package org.example.wordmath;

public class Expression {
    private final int left;
    private final int right;
    private final OPERATORS operator;

    enum OPERATORS {
        PLUS("plus"),
        MINUS("minus"),
        MULTIPLIED("multiplied"),
        DIVIDED("divided");

        private final String operator;

        OPERATORS(String operator) {
            this.operator = operator;
        }

        public String getOperator() {
            return operator;
        }
    }

    enum NUMBER_WORD {
        ONE("one"),
        TWO("two"),
        THREE("three"),
        FOUR("four"),
        FIVE("five"),
        SIX("six"),
        SEVEN("seven"),
        EIGHT("eight"),
        NINE("nine");

        private final String valueString;

        NUMBER_WORD(String valueString) {
            this.valueString = valueString;
        }

        public int getIntValue() {
           return switch(this){
                case ONE -> 1;
                case TWO -> 2;
                case THREE -> 3;
                case FOUR -> 4;
                case FIVE -> 5;
                case SIX -> 6;
                case SEVEN -> 7;
                case EIGHT -> 8;
                case NINE -> 9;
                default -> throw new IllegalArgumentException("Invalid number word: " + valueString);
            };
        }

    }

    public Expression(String input){
        input = input.replace("multiplied by", "multiplied")
                .replace("divided by", "divided");

        String[] parts = input.split(" ");
        if(parts.length != 3){
            throw new IllegalArgumentException("Invalid input: " + input);
        }

        this.left = NUMBER_WORD.valueOf(parts[0].toUpperCase()).getIntValue();
        this.operator = OPERATORS.valueOf(parts[1].toUpperCase());
        this.right = NUMBER_WORD.valueOf(parts[2].toUpperCase()).getIntValue();;
    }

    public int evaluate(){
        return switch (operator) {
            case PLUS -> left + right;
            case MINUS -> left - right;
            case MULTIPLIED -> left * right;
            case DIVIDED -> left / right;
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }

    @Override
    public String toString() {
        return "Expression{" +
                "left=" + left +
                ", right=" + right +
                ", operator=" + operator +
                '}';
    }
}
