/*    Problem description : www.hackerrank.com/challenges/down-to-zero-ii
 *
 *    Dynamic Programming using ArrayList 
 *    
 *    Environment: www.hackerrank.com - Java 8
 *    
 *     To use outside HackerRank environment please modify 
 *     BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));   line to
 *     BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
 */    

import java.io.*;
import java.math.*;
import java.util.*;


public class Solution {

    	//Dynamic programming lookUp table for storing previous results
    static ArrayList<Integer> lookUp = new ArrayList<>();
    static { 
	lookUp.add(0); 
    }

    static int downToZero(int n) {
        	// if it was computed previously -> DONE
        if(lookUp.size() > n) {
            return lookUp.get(n);
        }
        	// Check its divisors and select that serves the minimum steps
        for(int i = lookUp.size(); i <= n; i++) {
            int minStep = lookUp.get(i - 1) + 1;
            for(int divA = 2; divA * divA <= i; divA++) {
                if(i % divA == 0) {
                    minStep = Math.min(minStep, lookUp.get(i / divA) + 1);
                }
            }
            	// Storing the result in lookUp table
            lookUp.add(minStep);
        }
        return lookUp.get(n);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(scanner.nextLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            int result = downToZero(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
