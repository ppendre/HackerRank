/*	Problem description :  https://www.hackerrank.com/challenges/bigger-is-greater/problem
 *
 *	Time complexity: O(n*n + log(n))
 *	
 *	Environment: www.hackerrank.com - Java 8
 *	
 * 	To use outside HackerRank please modify 
 * 	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));   line to
 *	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
 */	

package BiggerisGreater;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    protected static void swap(char[] arr, int i, int j ) {
    	char temp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = temp;
    }
	
    static String biggerIsGreater(String w) {
    	char[] chars = w.toCharArray();  
    	boolean found = false;
    	int lastPos = chars.length - 2;		// index of char that is good for swap
    	int minCharPos = Integer.MAX_VALUE;
    	
    		// From the end of the string
    	while(!found && lastPos >= 0) {
    		minCharPos = Integer.MAX_VALUE;
    		for(int i = lastPos + 1; i < chars.length; i++) {
    			// Is there any char after this that is good for swap (is it greater?)
    			if(chars[i] > chars[lastPos]) {
    				found = true;
    				// Select the smallest    				
    				if(minCharPos == Integer.MAX_VALUE) {
    					minCharPos = i;
    				}
    				else {
    					minCharPos = chars[minCharPos] < chars[i] ?  minCharPos : i;
    				}
    			}
    		}
    		lastPos--;
    	}
    		
    	if(!found) return "no answer";
    		
    	swap(chars, minCharPos, lastPos + 1);
    	
    	// After the first swapped char the remained chars have to be sorted because of the the minimal rule   
    	Arrays.sort(chars, lastPos + 2, chars.length);
    	
    	return String.copyValueOf(chars); 

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
