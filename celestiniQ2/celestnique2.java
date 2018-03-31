
import java.util.Scanner;

public class celestnique2 {

	
	int data[][];
	int row, col;
	static int r1[], c1[], v1[], r2[], c2[], v2[];
	int len;

	public celestnique2(int r, int c,int size) {
		row = r;
		col = c;
		len = 0;
		data = new int[size][3];
	}

	public void insert(int r, int c, int val) {
		if (r > row || c > col) {
			System.out.println("Wrong entry");
		} else {
			data[len][0] = r;
			data[len][1] = c;
			data[len][2] = val;
			len++;
		}
	}

	public celestnique2 transpose() {

		celestnique2 result = new celestnique2(col, row,this.len);
		result.len = len;
		int count[] = new int[col + 1];
		for (int i = 1; i <= col; i++)
			count[i] = 0;
		for (int i = 0; i < len; i++)
			count[data[i][1]]++;
		int[] index = new int[col + 1];
		index[1] = 0;
		for (int i = 2; i <= col; i++)
			index[i] = index[i - 1] + count[i - 1];

		for (int i = 0; i < len; i++) {
			int rpos = index[data[i][1]]++;
			result.data[rpos][0] = data[i][1];
			result.data[rpos][1] = data[i][0];
			result.data[rpos][2] = data[i][2];
		}
		return result;
	}

	public void multiply(celestnique2 b) {
		b = b.transpose();
		int apos, bpos;
		celestnique2 result = new celestnique2(row, b.row,b.len);

		for (apos = 0; apos < len;) {

			int r = data[apos][0];

			for (bpos = 0; bpos < b.len;) {

				int c = b.data[bpos][0];

				int tempa = apos;
				int tempb = bpos;

				int sum = 0;
				while (tempa < len && data[tempa][0] == r && tempb < b.len && b.data[tempb][0] == c) {

					if (data[tempa][1] < b.data[tempb][1])

						tempa++;

					else if (data[tempa][1] > b.data[tempb][1])

						tempb++;
					else

						sum += data[tempa++][2] * b.data[tempb++][2];
				}

				if (sum != 0)
					result.insert(r, c, sum);

				while (bpos < b.len && b.data[bpos][0] == c)

					bpos++;
			}

			while (apos < len && data[apos][0] == r)

				apos++;
		}

		result.print();
	}
 public void convolve(int m1,int m2,int[] r12,int[] r22,int[] c12,int[] c22,int[] v12,int[] v22,int n)
    {
    	int conv[]=new int[n];
    		for(int i=0;i<m1;i++)
    		
    			for(int j=0;j<m2;j++)
    			{
    				// only if i+(m-i) equals m then convolution occurs
    				//only r c elements needs to be considered in sparse matrix else value is zero
    				//dimensions of resultant convolution matrix is of matrix A 
    				if(((r12[i]+r22[j])==n)&&(c12[i]+c22[j]==n))
    				{
    					conv[i]=v12[i]*v22[j];
    				}
    					
    			}
    		 System.out.println("Convolution: " );
    		 System.out.println("Sparse Matrix: \nRow Column Value");
    		 
    	        for (int i = 0; i < m1; i++) {
    	 
    	            System.out.println(r12[i] + " "
    	                             + c12[i] + " " + conv[i]);
    	        }
    	
        
 
       
    }

	public void print() {
		System.out.println("Dimension: " + row + "x" + col);
		System.out.println("Sparse Matrix: \nRow Column Value");

		for (int i = 0; i < len; i++) {

			System.out.println(data[i][0] + " " + data[i][1] + " " + data[i][2]);
		}
	}

	public static void main(String args[]) {

		System.out.println("\nEnter n: ");
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		System.out.println("\nEnter m1(no. of non zero elements in matrix A: ");
		int m1 = reader.nextInt();
		System.out.println("\nEnter m2(no. of non zero elements in matrix B: ");
		int m2 = reader.nextInt();
		celestnique2 a = new celestnique2(n, n,m1);
		celestnique2 b = new celestnique2(n, n,m2);
		
		r1 = new int[m1];
		c1 = new int[m1];
		v1 = new int[m1];
		r2 = new int[m2];
		c2 = new int[m2];
		v2 = new int[m2];
		
		for (int i = 0; i < m1; i++) {
			System.out.println("\nEnter Row Column Value of matrix A:");
			r1[i] = reader.nextInt();
			c1[i] = reader.nextInt();
			v1[i] = reader.nextInt();
		}

		for (int i = 0; i < m2; i++) {
			System.out.println("\nEnter Row Column Value of matrix B:");
			r2[i] = reader.nextInt();
			c2[i] = reader.nextInt();
			v2[i] = reader.nextInt();
		}

		for (int i = 0; i < m1; i++)
			a.insert(r1[i], c1[i], v1[i]);

		for (int i = 0; i < m2; i++)
			b.insert(r2[i], c2[i], v2[i]);

		reader.close();
		System.out.println("\nMultiplication: ");
		a.multiply(b);
                       a.convolve(m1,m2,r1,r2,c1,c2,v1,v2,n);
	}
}


