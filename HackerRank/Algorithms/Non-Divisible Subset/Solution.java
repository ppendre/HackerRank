/*    Problem description : https://www.hackerrank.com/challenges/non-divisible-subset/problem
 *
 *    Time complexity: O(n)
 *    
 *    Environment: www.hackerrank.com - Java 8
 *    
 *    To use outside HackerRank environment please modify 
 *    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));   line to
 *    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
 */    

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int nonDivisibleSubset(int k, int[] S) {
    	int subsetNum = 0;
    	int[] modulo = new int[k];
    	
    	// Count elements depends on modulo k
    	for(int i = 0; i < S.length; i++) {
    		modulo[S[i] % k]++;    		
    	}
    	
    	// Edge cases 1: if k is even only 1 element count from modulo k/2
    	//	for example k = 8	4 + 12 is divisible by 8
    	if((k&1) == 0) {
    		subsetNum++;
    	}
    	// Edge cases 2: modulo k == 0 only 1 element count
    	//	for example k = 8	8 + 16 is divisible by 8  
    	if(modulo[0] != 0) {
    		subsetNum++;
    	}
    	// Create pairs as the sum of the two elements is k
    	// Only either element of the sum belongs to the subset
    	// Choice that element from every pair witch representing larger subset
    	for(int i = 1; i <= (k - 1) / 2; i++) {
    		subsetNum += Math.max(modulo[i],  modulo[k - i]);
    	}
    	    	
    	return subsetNum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] S = new int[n];

        String[] SItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int SItem = Integer.parseInt(SItems[i]);
            S[i] = SItem;
        }

        int result = nonDivisibleSubset(k, S);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
