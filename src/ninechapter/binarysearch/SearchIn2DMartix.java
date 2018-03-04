package ninechapter.binarysearch;

import data_stucture.PrintUtil;

/**
 * 在一个矩阵中寻找一个数，该矩阵按行递增，且下一行的第一个数，大于上一行的最后一个数
 *
 * @author
 * @create 2018-01-21 下午5:23
 **/
public class SearchIn2DMartix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        PrintUtil.print(searchMatrix(matrix, 20) + "");
    }


    /*
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        //一行都没有
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        //有行但是行中没有数据
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int start = 0;


        int column = matrix[0].length;
        int row = matrix.length;
        int end = row * column - 1;


        while (start <=end) {
            int mid = start + (end - start) / 2;
            int number = matrix[mid / column][mid % column];
            if (number == target) {
                return true;
            } else if (number > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
            System.out.println("start" + start + "end" + end + "mid" + mid);
        }




        return false;
    }


}
