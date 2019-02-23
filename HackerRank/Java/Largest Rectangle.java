/*    Problem description : https://www.hackerrank.com/challenges/largest-rectangle/problem
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
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static long largestRectangle(int[] h) {
    	
    	int maxHeight = (int)Math.pow(10, 6);
    	int[] array = new int[maxHeight + 1];
    	Arrays.fill(array, -1);
    	long maxArea = 0;
    	
    	for(int i = 0; i < h.length; i++) {
    		int height = h[i] + 1;
    		while(height < maxHeight + 1 && array[height] != -1) {
    			maxArea = Math.max(( i - array[height]) * height,  maxArea);
    			array[height] = -1;
    			height++;
    		}
    		height = h[i];
    		while(height >= 0 && array[height] == -1) {
    			array[height] = i;
    			height--;
    		}
    	}
    	
    	int height = 0;
    	while(height < maxHeight + 1 && array[height] != -1) {
			maxArea = Math.max((h.length - array[height]) * height,  maxArea);			
			height++;
		}
    	
    	return maxArea;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
