/*    Problem description : https://www.hackerrank.com/challenges/game-of-two-stacks/problem
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
    
    static int twoStacks(int x, int[] a, int[] b) {
    	int sum = 0;
    	int counter = 0;
    	int counterMax = 0;
    	int pointA = -1;	// The index of element from 'stack A' which is taken   
    	int pointB = -1;	// The index of element from 'stack B' which is taken
    	
    		// Get elements from 'stack A' until it is possible
    	while(pointA < a.length - 1 && sum + a[pointA + 1] <= x ) {
    		pointA++;
    		sum += a[pointA];    		
    		counter++;
    	}

    	counterMax = counter; 		
    	
		// Get elements from 'stack B' until it is possible
		// If it is not possible remove element from the 'stack A' and check again
    	// Do this until there aren't more elements in 'stack B' OR 
    	//	until giving back more elements to 'stack A' is impossible

    	while(pointB < b.length - 1) {
    		if(sum + b[pointB + 1] <= x) {
    			pointB++;
    			sum += b[pointB];        		
        		counter++;
        		counterMax = Math.max(counterMax, counter); 
    		}
    		else {
    			if(pointA <= -1 ) break;  
    			sum -= a[pointA];
    			pointA--;
    			counter--;    			
    		}    		    				
    	}
    	
    	return counterMax;        

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            String[] nmx = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmx[0].trim());

            int m = Integer.parseInt(nmx[1].trim());

            int x = Integer.parseInt(nmx[2].trim());

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");

            for (int aItr = 0; aItr < n; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr].trim());
                a[aItr] = aItem;
            }

            int[] b = new int[m];

            String[] bItems = scanner.nextLine().split(" ");

            for (int bItr = 0; bItr < m; bItr++) {
                int bItem = Integer.parseInt(bItems[bItr].trim());
                b[bItr] = bItem;
            }

            int result = twoStacks(x, a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}

