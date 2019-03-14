/*	Problem description :  https://www.hackerrank.com/challenges/3d-surface-area/problem
 *
 *	Time complexity: O(n*m)
 *	
 *	Environment: www.hackerrank.com - Java 8
 *	
 * 	To use outside HackerRank please modify 
 * 	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));   line to
 *	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
 */	

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int surfaceArea(int[][] A) {
    	int result = 0;		// Count the surface 
    	// For every grid count only that side, that is on surface
    	for(int i = 0; i < A.length; i++)
    		for(int j = 0; j < A[i].length; j++) {
    			// Top and bottom are always exist because of 1<= A[i,j] <= 100
    			result += 2;	
    			
    			// Up
    			if(i == A.length - 1) result += A[i][j];
    			else result += Integer.max(0, A[i][j] - A[i + 1][j]);
    			
    			// Down
    			if(i == 0) result += A[i][j];
    			else result += Integer.max(0, A[i][j] - A[i - 1][j]);
    			
    			// Right
    			if(j == A[i].length - 1) result += A[i][j];
    			else result += Integer.max(0, A[i][j] - A[i][j + 1]);
    			
    			// Left
    			if(j == 0) result += A[i][j];
    			else result += Integer.max(0, A[i][j] - A[i][j - 1]);    					
    		}
    	
    	return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    	
        String[] HW = scanner.nextLine().split(" ");

        int H = Integer.parseInt(HW[0]);

        int W = Integer.parseInt(HW[1]);

        int[][] A = new int[H][W];

        for (int i = 0; i < H; i++) {
            String[] ARowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < W; j++) {
                int AItem = Integer.parseInt(ARowItems[j]);
                A[i][j] = AItem;
            }
        }

        int result = surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
