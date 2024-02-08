package org.example.basic;

/** Problem Statement – Given a sting , return the character that appears the minimum number of times in the string.
 * The string will contain only ascii characters, from the ranges (“a”-”z”,”A”-”Z”,0-9), and case matters .
 * If there is a tie in the minimum number of times a character appears in the string return the character that appears first in the string.
*/
 public class MinOccuranceString {

    public static void main(String[] args) {
       System.out.println(minOccuranceString("aabbcc"));
        /*
        assert minOccuranceString("aabbcc") == 'a';
        assert minOccuranceString("aabbccA") == 'a';
        assert minOccuranceString("aabbccA123") == 'A';
        assert minOccuranceString("aabbccA123!@#") == 'A';

         */
    }

    private static char minOccuranceString(String input) {
        int[] count = new int[256];
        for (char c : input.toCharArray()) {
            count[c]++;
        }

        for(int i=0 ; i<count.length; i++){
            if(count[i]>0)
                System.out.println((char)i);
        }

        int min = Integer.MAX_VALUE;
        char result = 0;
        for (char c : input.toCharArray()) {
            if (count[c] < min) {
                min = count[c];
                result = c;
            }
        }
        return result;
    }

}
