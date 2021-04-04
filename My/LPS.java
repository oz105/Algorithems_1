package My;

public class LPS {

	/**
	 * Longest Palindromic SubString Complexity: O(n^2)
	 */
	public static int lpsLen(String s) {
		String reverse = new StringBuilder(s).reverse().toString();
		return LCS(s, reverse);
	}

	private static int LCS(String X, String Y) {
		int n = X.length() + 1;
		int m = Y.length() + 1;
		int[][] mat = new int[n][m];
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (X.charAt(i - 1) == Y.charAt(j - 1)) {
					mat[i][j] = mat[i - 1][j - 1] + 1;
				} else {
					mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
				}
			}
		}
		return mat[n - 1][m - 1];
	}
	
	public static String lps(String s) {
		String reverse = new StringBuilder(s).reverse().toString();
		return findLCS(s, reverse);
	}
	
	public static String findLCS (String X , String Y) {
		int n = X.length();
		int m = Y.length();
		int[][] mat = new int[n+1][m+1];
		for (int i = 0; i < n+1 ; i++) {
			mat[i][0] = 0;

		}
		for (int j = 0; j < m+1 ; j++) {
			mat[0][j] = 0;
		}
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < m+1; j++) {
				if (X.charAt(i - 1) == Y.charAt(j - 1)) {
					mat[i][j] = mat[i - 1][j - 1] + 1;
				} else {
					mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
				}
			}
		}
		int i = n, j = m;
		String res = "";
		while (mat[i][j] != 0) {
			if (X.charAt(i - 1) == Y.charAt(j - 1)) {
				res = X.charAt(i - 1) + res;
				i--;
				j--;
			} else {
				if (mat[i][j - 1] > mat[i - 1][j]) {
					j--;
				} else {
					i--;
				}
			}
		}
		return res ;
	}

	public static void main(String[] args) {
		System.out.println(lpsLen("wasitacaroracatisaw"));
		System.out.println(lpsLen("alfalfa"));
		System.out.println(lpsLen("aubcxctybza"));
		System.out.println(lps("wasitacaroracatisaw"));
		System.out.println(lps("alfalfa"));
		System.out.println(lps("aubcxctybza"));
	}
}
