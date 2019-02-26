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
    	/* Using stack to store the position of smaller heights then the current height
    	 * If the height larger then previous heights in the stack -> next heights
    	 * If NOT -> calculate the areas that this building closes.
    	 */
    	
    	Stack<Integer> stack = new Stack<>();
    	long maxArea = 0;    	
    	
    	for(int i = 0; i < h.length; i++) {
    		while(!stack.isEmpty() && h[stack.peek()] >= h[i]) {
    			int prevHeight = stack.pop();
    			if(!stack.isEmpty()) {
    				maxArea = Math.max(maxArea, (long)(i - stack.peek() - 1) * h[prevHeight]);
    			}
    			else {
    				maxArea = Math.max(maxArea, (long)(i) * h[prevHeight]);
    			}
    		}
    		stack.push(i);    		
    	}
    	
    		// Finally check the open areas with a new building with zero height.
    	while(!stack.isEmpty()) {
			int prevHeight = stack.pop();
			if(!stack.isEmpty()) {
				maxArea = Math.max(maxArea, (long)(h.length - stack.peek() - 1) * h[prevHeight]);
			}
			else {
				maxArea = Math.max(maxArea, (long)(h.length) * h[prevHeight]);
			}
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
