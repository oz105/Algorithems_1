package My;

import java.util.ArrayList;
import java.util.Arrays;

public class LisCycle {
	
	public static int[] LisCycleString(int [] arr) {
		int n = arr.length;
		int[] copy = null;
		int max = 0;
		for (int i = 0; i < n; i++) {
			int a = arr[i];
			int index = i ; 
			int [] b = new int [n-1];
			for (int j = 0; j < n-1; j++) {
				b[j] = arr[(index+1)%n];
				index = (index+1)%n ;
			}
			int [] ans = lis(b);
			if(ans.length >= max) {
				max = ans.length;
				copy = Arrays.copyOf(ans,ans.length);
			}
		}
		return copy ;
	}
	
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
//		int [] arr = {1,11,2,10,4,5,2,1} ;
//		int [] arr = {0,0,0,5,0,1,0,7,3,6,3,3,1,1} ;
		int [] arr = {10,8,1,4,3,7} ;

		System.out.println(Arrays.toString(LisCycleString(arr)));
	}

}
