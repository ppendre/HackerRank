/*	Problem description :  https://www.hackerrank.com/challenges/utopian-tree/problem
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
import java.util.*;

public class Solution {

    static int utopianTree(int n) {
    	int height = 1;		// Height of the tree, at the beginning is 1  
    	for(int i = 1; i <= n; i++) {
    			// If there is spring doubles 
    		if((i&1) == 1) {
    			height = height << 1;
    		}
    		// If there is summer increase by 1
    		else {
    			height++;
    		}
    	}
    	
    	return height;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = utopianTree(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
