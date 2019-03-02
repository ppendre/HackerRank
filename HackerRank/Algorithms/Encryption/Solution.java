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
    	int rows = (int)Math.floor(Math.sqrt(sWOSpace.length()));
    	int columns = rows;
    	
    		// Define the minimal size matrix 
    	if(rows * columns < sWOSpace.length()) {
    		columns++;
    		if(rows * columns < sWOSpace.length()) {
    			rows++;
    		}
    	}
    	
    	char[] charArray = sWOSpace.toCharArray();
    	StringBuilder result = new StringBuilder(sWOSpace.length() + columns);
    	
    	for(int i = 0; i < rows * columns; i++) {
    			// Add space after every column;
    			// Special case is the first character
    		if((i % rows == 0 && i > 0) ) {
    			result.append(" ");
    		}
    			// Add the proper char to result
    			// Special case the last column, it maybe shorter.
    		if((i % rows) * columns  + i / rows < charArray.length)
    			result.append(charArray[(i % rows) * columns  + i / rows]);
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
