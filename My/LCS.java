package My;

public class LCS {
	
	/**
	 * return the length of LCS
	 * Complexity: O(n*m)
	 */

	public static int lcsLength(String s1, String s2) {
		int n = s1.length(), m = s2.length();
		int mat[][] = new int[n + 1][m + 1];
		for (int i = 0; i < n + 1; i++) {
			mat[i][0] = 0;

		}
		for (int j = 0; j < m + 1; j++) {
			mat[0][j] = 0;
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					mat[i][j] = mat[i - 1][j - 1] + 1;
				} else {
					mat[i][j] = Math.max(mat[i][j - 1], mat[i - 1][j]);
				}
			}
		}
		return mat[n][m];
	}

	/**
	 * return the String of LCS
	 * Complexity: O(2n*m)
	 */
	
	public static String lcsString(String s1, String s2) {
		int n = s1.length(), m = s2.length();
		int mat[][] = new int[n + 1][m + 1];
		for (int i = 0; i < n + 1; i++) {
			mat[i][0] = 0;

		}
		for (int j = 0; j < m + 1; j++) {
			mat[0][j] = 0;
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					mat[i][j] = mat[i - 1][j - 1] + 1;
				} else {
					mat[i][j] = Math.max(mat[i][j - 1], mat[i - 1][j]);
				}
			}
		}
		int i = n, j = m;
		String res = "";
		while (mat[i][j] != 0) {
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				res = s1.charAt(i - 1) + res;
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
		return res;
	}

	/**
	 * find the shortest String that contains s1 and s2 lcs.
	 * Complexity: O(n*m)
	 */
	
	public static String findBetween(String s1, String s2) {
		String lcs = lcsString(s1, s2);
		int length = s1.length() + s2.length() - lcs.length();
		String res = "";
		int i = 0, j = 0, index = 0;
		while (length > 0) {
			if (index < lcs.length()) {
				if (i < s1.length() && s1.charAt(i) == lcs.charAt(index)) {
					while (s2.charAt(j) != lcs.charAt(index)) {
						res = res + s2.charAt(j);
						length--;
						j++;
					}
					res = res + s1.charAt(i);
					length--;
					j++;
					i++;
					index++;
				} else if (j < s2.length() && s2.charAt(j) == lcs.charAt(index)) {
					while (s1.charAt(i) != lcs.charAt(index)) {
						res = res + s1.charAt(i) ;
						length--;
						i++;
					}
					res = res+ s1.charAt(i);
					length--;
					i++;
					j++;
					index++;
				}

			} else {
				while (j < s2.length()) {
					res = res + s2.charAt(j);
					length --;
					j++;
				}
				while (i < s1.length()) {
					res = res + s1.charAt(i);
					length --;
					i++;
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		String s1 = "bdcaba";
		String s2 = "abcbdab";
		System.out.println(lcsLength(s1, s2));
		System.out.println(lcsString(s1, s2));
		String s3 = findBetween("abcbdab", "bdcaba");
		System.out.println(s3);
		System.out.println(lcsString(s2, s3));
		System.out.println(lcsString(s1, s3));


	}

}
