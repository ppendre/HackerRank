/*	Problem description :  https://www.hackerrank.com/challenges/ctci-making-anagrams
 *
 *	Time complexity: O(n)
 *	
 *	Environment: www.hackerrank.com - Java 8
 *	
 * 	To use outside HackerRank please modify 
 * 	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));   line to
 	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
 */	

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int result = 0;
        // ch array counts only the differences of letters frequency
        // At a string increases
        // At b string decreases
        int[] ch = new int[26];   //only ascii[a-z]
        
        
        //Arrays.fill(ch, 0);
        for(int i = 0; i < a.length(); i++) {
            ch[a.charAt(i) - 'a']++;
        }
        for(int i = 0; i < b.length(); i++) {
            ch[b.charAt(i) - 'a']--;
        }
        for(int i = 0; i < ch.length; i++) {
            result += Math.abs(ch[i]);  // Differencies from zero is count.
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
