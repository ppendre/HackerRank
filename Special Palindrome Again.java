/*	Problem description :  https://www.hackerrank.com/challenges/special-palindrome-again
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

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
    	long result = 0;
    	
    	/* Count cases: all letters are the same */
    	for(int i = 0; i < s.length(); i++) {
    		int j = i;
    		while(j < s.length() && s.charAt(i) == s.charAt(j)) j++;
    		result += j - i;
    	}
    	
    	/* Count cases: except the middle all are the same */
    	for(int i = 1; i < s.length(); i++) {
    		
    	/* i: middle	j: left-right from the middle	*/
    		int j = 1;			// only counts from 3 elements
    		char prev = s.charAt(i - j);
    		while(i - j >= 0 && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j) && 
    							prev == s.charAt(i + j) && s.charAt(i + j) != s.charAt(i)  ) j++;
    		result += j - 1;   		
    		
    	}
    	return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
