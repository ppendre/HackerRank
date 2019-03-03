/*	Problem description :  https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
 *
 *	Time complexity: O(n*n + log(n))
 *	
 *	Environment: www.hackerrank.com - Java 8
 *	
 * 	To use outside HackerRank please modify 
 * 	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));   line to
 *	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
 */	


package OrganizingContainersofBalls;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    /* Idea: Except of the order the sum of every columns are same that 
     * 		 the sum of every rows
     */
	
	static String organizingContainers(int[][] container) {
    	int[] balls = new int[container.length];
    	int[] conts = new int[container.length];
    	
    	for(int i = 0; i < container.length; i++) {
    		for(int j = 0; j < container.length; j++) {
    			balls[i] += container[i][j];
    			conts[j] += container[i][j];
    		}    		
    	}
    	Arrays.sort(balls);
    	Arrays.sort(conts);
    	
    	return Arrays.equals(balls, conts) ? "Possible" : "Impossible";    	
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
