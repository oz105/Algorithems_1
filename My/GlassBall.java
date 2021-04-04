package My;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GlassBall {

	
	/**
	 * 2 glass ball problem
	 * Complexity: O(n^2)
	 */
	
	public static int numOfChecking2(int n) { // n = num of floors.
		if (n == 0) return 0;
		if (n == 1) return 1;
		if (n == 2) return 2;
		int floor[][] = new int[3][n + 1];
		int res;
		for (int i = 1; i <= 2; i++) {// run when we have only 1 floor or 0 floor .
			floor[i][1] = 1;
			floor[i][0] = 0;
		}
		for (int j = 1; j < n + 1; j++) {
			floor[1][j] = j;
		}
		for (int j = 2; j < n + 1; j++) {
			floor[2][j] = n;
			for (int j2 = 1; j2 <= j; j2++) {
				res = 1 + Math.max(floor[2 - 1][j2 - 1], floor[2][j - j2]);
				if (res < floor[2][j])
					floor[2][j] = res;
				}
			}
		
		return floor[2][n];
	}
	
	/**
	 * 3 glass ball problem
	 * Complexity: O(3*n^2)
	 */
	
	public static int numOfChecking3(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		if (n == 2) return 2;
		int floor[][] = new int[4][n + 1];
		int res;
		for (int i = 1; i <= 3; i++) {// run when we have only 1 floor or 0 floor .
			floor[i][1] = 1;
			floor[i][0] = 0;
		}
		for (int j = 1; j < n + 1; j++) {
			floor[1][j] = j;
		}
		for (int i = 2; i < 4; i++) {
			for (int j = 2; j < n + 1; j++) {
				floor[i][j] = n;
				for (int j2 = 1; j2 <= j; j2++) {
					res = 1 + Math.max(floor[i - 1][j2 - 1], floor[i][j - j2]);
					if (res < floor[i][j])
						floor[i][j] = res;
				}
			}
		}
		return floor[3][n];
	}
	
	/**
	 * k glass ball problem
	 * Complexity: O(k*n^2)
	 */
	
	static int numOfCheckingBreakBall(int k, int n) { // k = num of balls , n = num of floors.
		if (n == 0) return 0;
		if (n == 1) return 1;
		if (n == 2) return 2;
		int floor[][] = new int[k + 1][n + 1];
		int res;
		for (int i = 1; i <= k; i++) {// run when we have only 1 floor or 0 floor .
			floor[i][1] = 1;
			floor[i][0] = 0;
		}
		for (int j = 1; j < n + 1; j++) {
			floor[1][j] = j;
		}
		for (int i = 2; i < k + 1; i++) {
			for (int j = 2; j < n + 1; j++) {
				floor[i][j] = Integer.MAX_VALUE;
				for (int j2 = 1; j2 <= j; j2++) {
					res = 1 + Math.max(floor[i - 1][j2 - 1], floor[i][j - j2]);
					if (res < floor[i][j]) {
						floor[i][j] = res;
					}
				}
			}
		}
		return floor[k][n];
	}
	
	static int[][] breakBallMat(int k, int n) { // k = num of balls , n = num of floors.
		int floor[][] = new int[k + 1][n + 1];
		if( n>= 2) {
			int res;
			for (int i = 1; i <= k; i++) {// run when we have only 1 floor or 0 floor .
				floor[i][1] = 1;
				floor[i][0] = 0;
			}
			for (int j = 1; j < n + 1; j++) {
				floor[1][j] = j;
			}
			for (int i = 2; i < k + 1; i++) {
				for (int j = 2; j < n + 1; j++) {
					floor[i][j] = Integer.MAX_VALUE;
					for (int j2 = 1; j2 <= j; j2++) {
						res = 1 + Math.max(floor[i - 1][j2 - 1], floor[i][j - j2]);
						if (res < floor[i][j])
							floor[i][j] = res;
					}
				}
			}
		}
		return floor;
	}
	
	public static int[] pathOfDrops(int k , int n ) {
		int [][] floor = breakBallMat(k, n);
		int [] path = new int [floor[k][n]];
		String res = "" ;
		int level = n ;
		for (int i = 0; i < path.length; i++) {
			int x = floor [k][level];
			path[i] = x ;
			level = level - (level - x ) ;
		}
		return path ;	
	}
	public static int findClosestTringleNum (int x) {
		int y = 0 ;
		int i = 1 ;
		while (x > y) {
			y = i + y ; 
			i++ ;
		}
		return y ;
	}
	public static String pathOfDropsFor2(int n) {
		String res = "" ;
		int y = findClosestTringleNum(n);
		int x = 0 ;
		int i = 1 ;
		while (x!=y) {
			if(i>1) {res = "," + res;}
			x = x+i ;
			res = i + res ;
			i++ ;
		}
		return res ;
	}
	
	
	
	
	public static void main(String[] args) {
//		for (int i = 2; i < 50; i++) {
//			if(numOfCheckingBreakBall(3, i) != numOfChecking3(i) ) {
//				System.out.println(false);
//				System.out.println(i);
//				System.out.println("right "+numOfCheckingBreakBall(2, i));
//				System.out.println("not right "+numOfChecking2(i));
//
//			}
//			
//		}
		System.out.println(numOfCheckingBreakBall(2, 100));
		System.out.println(numOfChecking2(37));
//		System.out.println(pathOfDropsFor2(13));
//		System.out.println(numOfChecking3(14));
//		System.out.println(Arrays.toString(pathOfDrops(3, 4)));
//		System.out.println(findClosestTringleNum(100));
	}
	

}
