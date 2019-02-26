/*    Problem description : https://www.hackerrank.com/challenges/queens-attack-2/problem
 *
 *    Time complexity: O(log(n) + k)
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

// Implementing Pair class to 2 int with hashCode() and equals()

class Pair
{
	public final int first;   	// first field of a Pair
	public final int second;  	// second field of a Pair

	Pair(int first, int second)
	{
		this.first = first;
		this.second = second;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		Pair pair = (Pair) o;

		if (pair.first != first)
			return false;
		return pair.second == second;
	}

	@Override
	public int hashCode()
	{
		return 31 * first + second;
	}

	@Override
	public String toString()
	{
		return "(" + first + ", " + second + ")";
	}

}


public class Solution {

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
     	// freeMoves contains the reachable pairs from the queen position
    	HashSet<Pair> freeMoves = new HashSet<>();
    	
    	// Add horizontal and vertical lines
    	for(int i = 1; i <= n; i++) {
    		freeMoves.add(new Pair(r_q, i));
    		freeMoves.add(new Pair(i, c_q));
    	}
    	
    	// Add diagonals
    	int x = r_q;
    	int y = c_q;
    	while (x >= 1 && y >= 1) 	freeMoves.add(new Pair(x--, y--));    		
    	x = r_q;	y = c_q;
    	while (x <= n && y >= 1) 	freeMoves.add(new Pair(x++, y--));
    	x = r_q;	y = c_q;
    	while (x <= n && y <= n) 	freeMoves.add(new Pair(x++, y++));
    	x = r_q;	y = c_q;
    	while (x >= 1 && y <= n) 	freeMoves.add(new Pair(x--, y++));
    	
    	// Remove the position of the queen
    	freeMoves.remove(new Pair(r_q, c_q));
    	
    	// Check the obstacles and if it is in the reachable pairs remove it and pairs that is blocked by it  
    	for(int i = 0; i < k; i++) {
    		Pair pair = new Pair(obstacles[i][0], obstacles[i][1]);
    		if(freeMoves.contains(pair)) {
    			freeMoves.remove(pair);
    			x = pair.first;	y = pair.second;
    			// Up
    			if(pair.first == r_q && pair.second > c_q) {
    				while (y <= n) 	freeMoves.remove(new Pair(x, y++));
    			}
    			// Down
    			if(pair.first == r_q && pair.second < c_q) {
    				while (y >= 1) 	freeMoves.remove(new Pair(x, y--));
    			}
    			// Left
    			if(pair.first < r_q && pair.second == c_q) {
    				while (x >= 1) 	freeMoves.remove(new Pair(x--, y));
    			}
    			// Right
    			if(pair.first > r_q && pair.second == c_q) {
    				while (x <= n) 	freeMoves.remove(new Pair(x++, y));
    			}
    			// Right and Up 
    			if(pair.first > r_q && pair.second > c_q) {
    				while (x <= n && y <= n) 	freeMoves.remove(new Pair(x++, y++));
    			}
    			// Right and Down
    			if(pair.first > r_q && pair.second < c_q) {
    				while (x <= n && y >= 1) 	freeMoves.remove(new Pair(x++, y--));
    			}
    			// Left and Down
    			if(pair.first < r_q && pair.second < c_q) {
    				while (x >= 1 && y >= 1) 	freeMoves.remove(new Pair(x--, y--));
    			}
    			// Left and Up
    			if(pair.first < r_q && pair.second > c_q) {
    				while (x >= 1 && y <= n) 	freeMoves.remove(new Pair(x--, y++));
    			}
    		}
    	}
    	
    	return freeMoves.size();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
