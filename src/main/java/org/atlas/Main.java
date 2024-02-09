package org.atlas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Read from System.in and create an Object
        Scanner scanner = new Scanner(System.in);

        String count  = scanner.next();
        String a  = scanner.next();
        String b  = scanner.next();

        for(int i = 0; i < Integer.parseInt(count); i++) {
            String input = scanner.next();
            Tuple tuple = new Tuple(a, b);
            System.out.println(input + " " + tuple);
        }



    }

    private static class Tuple {
        private final String a;
        private final String b;
        public Tuple(String a, String b) {
            this.a = a;
            this.b = b;
        }

        public String getA() {
            return a;
        }

        public String getB() {
            return b;
        }

        public String toString() {
            return a + " " + b;
        }
    }
}
