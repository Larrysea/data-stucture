package ninechapter.common_datastructure;

import data_stucture.PrintUtil;

/**
 * 矩阵乘法
 *
 * @author
 * @create 2018-04-14 下午2:38
 **/
public class MatrixMultiply {


    public static void main(String[] args) {
        int[][] testCase1 = {{1, 0, 0}, {-1, 0, 3}};
        int[][] testCase2 = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};
        PrintUtil.printMatrix(multiply(testCase1, testCase2));
    }


    /**
     * 矩阵乘法
     *
     * @param A: a sparse matrix
     * @param B: a sparse matrix
     * @return: the result of A * B
     */
    public static int[][] multiply(int[][] A, int[][] B) {
        // write your code here
        //检查行列是否相等
        if (A[0].length != B.length) {
            return new int[A.length][B[0].length];
        }

        int[][] result = new int[A.length][B[0].length];

        int column = 0;
        for (int row = 0; row < A.length; row++) {
            //初始化第二个
            for (int bColumn = 0; bColumn < B[0].length; bColumn++) {
                int sum = 0;
                for (column = 0; column < A[row].length; column++) {
                    sum += (A[row][column]) * (B[column][bColumn]);
                }
                result[row][bColumn] = sum;
            }

        }

        return result;

    }
}
