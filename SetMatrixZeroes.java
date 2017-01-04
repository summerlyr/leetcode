public class SetMatrixZeroes {

	public void setZeroes(int[][] matrix) {
		if (matrix == null)
			return;
		int m = matrix.length;
		int n = matrix[0].length;

		int[] rows = new int[m];
		int[] cols = new int[n];
		for (int i = 0; i < m; i++) {
			// if(rows[i]==1) continue;
			for (int j = 0; j < n; j++) {
				// System.out.println(matrix[i][j]);
				// if(cols[j]==1) continue;
				if (matrix[i][j] == 0) {
					rows[i] = 1;
					cols[j] = 1;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			if (rows[i] == 1) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		for (int j = 0; j < n; j++) {
			if (cols[j] == 1) {
				for (int i = 0; i < m; i++) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	public void setZeroes2(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row = false;
        boolean col = false;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j]==0) {
                    if(i==0) row = true;
                    if(j==0) col = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                if(matrix[i][0]==0||matrix[0][j]==0) matrix[i][j] = 0;
            }
        }
        if(row==true) {
            for(int i=0;i<n;i++) {
                matrix[0][i]=0;
            }
        }
        if(col==true) {
            for(int i=0;i<m;i++) {
                matrix[i][0]=0;
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetMatrixZeroes sz = new SetMatrixZeroes();
		int[][] matrix = { { 0, 0, 0, 5 }, { 4, 3, 1, 4 }, { 0, 1, 1, 4 }, { 1, 2, 1, 3 }, { 0, 0, 1, 1 } };
		sz.setZeroes(matrix);
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}

	}

}
