import java.util.Scanner;

public class celestniques3 {

	private static boolean search(int[][] mat, int m, int n, int x) {

		int i = 0, j = n - 1;

		while (i < m && j >= 0) {
			if (mat[i][j] == x) {
				return true;
			}
			if (mat[i][j] > x)
				j--;
			else
				i++;
		}
		return false;

	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 } };
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number to be searched:");
		int num = s.nextInt();
		boolean found = search(mat, 4, 5, num);
		if (found)
			System.out.print("Found");
		else
			System.out.print("Not found");
		s.close();
	}

}
