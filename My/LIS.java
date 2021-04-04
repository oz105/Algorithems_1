package My;

import java.util.Arrays;

public class LIS {
	
	/**
	 * return the length of LIS
	 * Complexity: O(n*log(n))
	 */
	
	public static int lisLength(int[] arr) {
		int n = arr.length ;
		int [] lis = new int [n] ;
		lis[0] = arr[0];
		int k = 1 ;
		for (int i = 1; i < n; i++) {
			int index = Arrays.binarySearch(lis, 0, k, arr[i]);
			if (index < 0) {
				index = -index - 1; 
			}
			if (index == k) {
				k++;
			}
			lis[index] = arr[i];
		}
		return k;
		
	}
	
	/**
	 * return the length of LIS
	 * Complexity: O((n*(n+log(n)) = (n^2 + n*log(n) = n^2)
	 */
	
	public static int[] lis(int[] arr) {
		int n = arr.length ;
		int [] lis = new int [n] ;
		int [][] mat = new int [n][n] ;
		lis[0] = mat[0][0] = arr[0];
		int k = 1 ;
		for (int i = 1; i < arr.length; i++) {
			int index = Arrays.binarySearch(lis, 0, k, arr[i]);
			if (index < 0) {
				index = -index - 1; 
			}
			if (index == k) {
				k++;
			}
			lis[index] = mat[index][index] = arr[i];
			for (int j = 0; j < index; j++) {
				mat[index][j] = mat[index-1][j] ; 
			}
		}
		return Arrays.copyOf(mat[k-1], k);
		
	}
	
	public static void main(String[] args) {
//		System.out.println(lisLength(new int[] { 5, 2, 9, 7, 8, 5, 3, 2, 1, 10, 6 }));
//		System.out.println(lisLength(new int[] { 1, 9, 10, 5, 6 }));
//		System.out.println(Arrays.toString(lis(new int[] { 5, 2, 9, 7, 8, 5, 3, 2, 1, 10, 6 })));
//		System.out.println(Arrays.toString(lis(new int[] { 1, 9, 10, 5, 6 })));
		System.out.println(Arrays.toString(lis(new int[] {10,12,20,21,16,4,17,18})));
	}
}
