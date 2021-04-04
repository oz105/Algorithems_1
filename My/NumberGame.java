package My;

import java.util.Arrays;

public class NumberGame {
	
	/**
	 * return the length of LIS
	 * Complexity: O(n^2)
	 */
	
	
	public static int numberGame(int [] numbers) {
		int n = numbers.length;
		int [][] mat = new int [n][n];
		for (int i = 0; i < n; i++) {mat[i][i] = numbers[i] ;}
		for (int i = n-1; i >= 0 ; i--) {
			for (int j = i+1 ; j < n ; j++) {
				mat[i][j] = Math.max(numbers[i] - mat[i+1][j], numbers[j] - mat[i][j-1]);
			}
		}
		return mat[0][n-1];
	}
	
	public static int numberGameCycle(int[] arr) {
		int n = arr.length ;
		int max = Integer.MIN_VALUE ;
		for (int i = 0; i < n; i++) {
			int a = arr[i] ;
			int cycle[] = new int [n-1];
			int k = (i+1) % n;
			for (int j = 0; j < n-1; j++) {
				cycle[j] = arr[k];
				k = (k+1) % n;
			}
			int res = numberGame(cycle);
			if (a-res > max) {max = a-res;}
		}
		return max ;
	}
	
	/**
	 * OPTIMAL 
	 * returns the the picking numbers of 2 sides
	 * Complexity: O(n^2 + n/2 = n^2)
	 */
	public static int [] numberGamePick (int [] arr ) {
		int n = arr.length;
		int [][] mat = new int [n][n];
		for (int i = 0; i < n; i++) {mat[i][i] = arr[i] ;}
		for (int i = n-1; i > 0 ; i--) {
			for (int j = i+1; j < n; j++) {
				mat[i][j] = Math.max(arr[i]-mat[i+1][j], arr[j]-mat[i][j-1]);
			}
		}
		int i = 0 , j = n-1 ;
		int pick = 0 ;
		int[] player1 = null ;
		int[] player2 = null ;
		if (n%2 ==0 ) {
			player1 = new int [n/2];
			player2 = new int [n/2];

		}else {
			player1 = new int [n/2+1];
			player2 = new int [n/2 ];

		}
		
		for (int k = 0; k < player1.length; k++) {
			if(arr[i]-mat[i+1][j] > arr[j]-mat[i][j-1]) {
				player1[k] = arr[i];
				i++;
			}else {
				player1[k] = arr[j];
				j--;
			}
			if(k<player2.length) {
				if(arr[i]-mat[i+1][j] > arr[j]-mat[i][j-1]) {
					player2[k] = arr[i];
					i++;
				}else {
					player2[k] = arr[j];
					j--;
				}
			}
		}
		System.out.println(Arrays.toString(player2));
		System.out.println(Arrays.toString(player1));
		return player1;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,3,6,1,3,6};
		System.out.println(numberGame(arr));
		System.out.println(numberGamePick(arr));
	}

}
