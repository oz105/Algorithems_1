package My;

import java.util.Arrays;

public class SqureOfOne {
	
	public static int oneSqure (int [][] mat) {
		int n = mat.length , m = mat[0].length;
		int ans [][] = new int [n][m];
		int min = 0 ;
		int max = 0 ; 
		for (int i = 0; i < n; i++) {
			ans[i][0] = mat[i][0];
		}
		for (int i = 0; i < m; i++) {
			ans[0][i] = mat[0][i];
		}
		for (int i = 1; i < ans.length; i++) {
			for (int j = 1; j < ans.length; j++) {
				if(mat[i][j] != 0) {
					min = Math.min(ans[i-1][j-1], Math.min(ans[i-1][j],ans[i][j-1]));
					ans[i][j] = min + 1;
					if (min+1 > max) max = min+1 ;
				}
				else {ans[i][j] = 0 ;}
			}
		}
		for (int i = 0; i < ans.length; i++) {
			System.out.println(Arrays.toString(ans[i]));
		}
		return max ;	
	}
	
	
	public static int oneSqureOf2 (int [][] mat) {
		int n = mat.length , m = mat[0].length;
		int ans [][] = new int [n][m];
		int min = 0 ;
		int max = 0 ; 
		int count = 0 ;
		for (int i = 0; i < n; i++) {
			ans[i][0] = mat[i][0];
		}
		for (int i = 0; i < m; i++) {
			ans[0][i] = mat[0][i];
		}
		for (int i = 1; i < ans.length; i++) {
			for (int j = 1; j < ans.length; j++) {
				if(mat[i][j] != 0) {
					min = Math.min(ans[i-1][j-1], Math.min(ans[i-1][j],ans[i][j-1]));
					ans[i][j] = min + 1;
					if (min +1 == 2) { count ++ ;}
					if (min+1 > max) max = min+1 ;
				}
			}
		}
		for (int i = 0; i < ans.length; i++) {
			System.out.println(Arrays.toString(ans[i]));
		}
		return count ;	
	}
	
	public static void Generate(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int)Math.round(Math.random());
            }
        }
    }
	
	public static void main(String[] args) {
		int[][] arr = {
                {0, 0, 1, 0, 1},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 1, 1, 1}
        };
		int [][] arr2 = new int [6][6];
		Generate(arr2);
		System.out.println(oneSqure(arr));
		System.out.println(oneSqureOf2(arr));


	}

}
