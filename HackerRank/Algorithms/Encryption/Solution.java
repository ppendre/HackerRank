/*	Problem description :  https://www.hackerrank.com/challenges/encryption/problem
 *
 *	Time complexity: O(n)
 *	
 *	Environment: www.hackerrank.com - Java 8
 *	
 * 	To use outside HackerRank please modify 
 * 	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));   line to
 *	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
 */	

package Encryption;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static String encryption(String s) {
    	String sWOSpace = s.replace(" ", "");
    		// Define the minimal size matrix 
    	double sqrt = Math.sqrt(sWOSpace.length());
    	int rows = (int)Math.floor(sqrt);
    	int columns = (int)Math.ceil(sqrt);
    	    	
    	char[] charArray = sWOSpace.toCharArray();
    	StringBuilder result = new StringBuilder(sWOSpace.length() + columns);
    	
    	for(int i = 0; i < columns; i++) {
    		int j = i;
    		while(j < charArray.length) {
    			result.append(charArray[j]);
    			j += columns;
    		}
    		// Add space after every columns
    		// Special case is the last column
    		if(i != columns - 1) {
    			result.append(" ");
    		}
    	}
    	
    	return result.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH"))); 

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
