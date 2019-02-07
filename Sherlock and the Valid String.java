/*	Problem description :  https://www.hackerrank.com/challenges/sherlock-and-valid-string
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

    // Complete the isValid function below.
    static String isValid(String s) {
        int[] arr = new int[26];	// elements forom ascii[a-z]
        for(int i = 0; i < s.length(); i ++ ){	// count the frequencies
            arr[s.charAt(i) - 'a']++;
        }   
        /*	Put frequencies into map - key: frequencies,   value: frequencies of frequency */           
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr.length; i++) {
        	if(arr[i] != 0) 
        		map.put(arr[i], map.getOrDefault(arr[i], 0) +1);
        }
        /* If only 1 freq. -> OK
         * If more then 2 freq. -> BAD
         * If at least 1 freq. of freq is 1 -> OK
         * If the difference of freq is 1 and some of them freq. of freq is 1 -> OK
         * All other case -> BAD
         */
        
        if(map.size() > 2 ) return "NO";
        if (map.size() == 1) return "YES";
        int firstFreq = 0;
        int firstValue = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet() ) {
        	if(entry.getValue() == 1 && entry.getKey() == 1) return "YES";        	
        	if(firstFreq == 0) {
        		firstFreq = entry.getKey();
        		firstValue = entry.getValue();
        	}
        	else
        		if(Math.abs(firstFreq - entry.getKey()) == 1 && (firstValue == 1 || entry.getValue() == 1) )
        			return "YES";
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
