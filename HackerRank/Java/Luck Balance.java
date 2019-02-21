 /* Problem description :  https://www.hackerrank.com/challenges/luck-balance
  * 
  *	Time complexity: O( n * log(n) )
  *	
  *	Environment: www.hackerrank.com - Java 8
  *	
  * To use outside HackerRank please modify 
  * BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));   line to
  * BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
  */	

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    /* We lose all unimportant contests to maximize luck.
     * And lose the k highest luck contests. 
     */
	
	// Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        int result = 0;
        List<Integer> impList = new ArrayList<>();	// Contains only the important contests        
    	
        for(int i = 0; i < contests.length; i++) {
        	if(contests[i][1] == 0) 
        		result += contests[i][0];
        	else 
        		impList.add(contests[i][0]);
        	
        }       
        
    	impList.sort(Collections.reverseOrder());
        
        for(int i = 0; i < impList.size(); i++) {
        	if(i < k)
        		result += impList.get(i);
        	else 
        		result -= impList.get(i);
        }
    	return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
