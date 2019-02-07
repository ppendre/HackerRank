/*	Problem description :  https://www.hackerrank.com/challenges/fraudulent-activity-notifications
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

    /*	This solution is base on there is only 201 different value of expenditure -----   0 <= expenditure[i] <= 200
     *   
     */
	
	static int activityNotifications(int[] expenditure, int d) {
    	int result = 0;
    	int[] med = new int[201];	// Contains the frequency of last d spendings 
    	
    	for(int i = 0; i < d; i++) {		// Initialize the first d spendings
    		med[expenditure[i]]++;
    	}
    	for(int i = d; i < expenditure.length; i++) {
    		int left = 0;
    		int right = 0;
    		
    		int spending = 0;
    		int pos = 0;
    		while(spending * 2 < d ) {	// find the middle element from left
    			spending += med[pos];
    			pos++;
    		}
    		left = pos - 1;				// the value of middle element from left
    		
    		pos = med.length - 1; 
    		spending = 0;
    		while(spending * 2 < d) {	// find the middle element from right
    			spending += med[pos];
    			pos--;
    		}
    		right = pos + 1;			// the value of middle element from right
    		
    		result += (left + right) <= expenditure[i] ? 1 : 0 ;
    		med[expenditure[i - d]]--;	// remove the d previously spending			
    		med[expenditure[i]]++;		// add next spending
    	}
    	return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
