package offer;

import java.util.ArrayList;

/**
 * Created by Larry-sea on 2017/3/19.
 * <p>
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {

    public static void main(String[] args) {

        int matrix1[][]=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int matrix[][] = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        ArrayList<Integer> list = printMatrix(matrix1);
        System.out.println("list" + list);

    }


    /**
     * 顺时针打印矩阵
     *
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int row = matrix.length;
        int column = matrix[0].length;
        int top = 0;
        int bottom = row - 1;
        int right = column - 1;
        int left = 0;

        if (row == 0 || column == 0) {
            return arrayList;
        }

        while (left <= right && bottom >= top) {
            //从左读入到最右边
            for (int i = left; i <= right; i++) {
                arrayList.add(matrix[top][i]);
            }

            //从上到最下面
            for (int i = top+1; i <=bottom; i++) {
                arrayList.add(matrix[i][right]);
            }

            //从右到左
            if(top!=bottom)
            for (int i = right-1; i >= left; i--) {
                arrayList.add(matrix[bottom][i]);
            }

            //从下到上
            if(right!=left)
            for (int i = bottom-1; i >top; i--) {
                arrayList.add(matrix[i][left]);
            }

            //缩小整体范围
            top++;
            bottom--;
            right--;
            left++;

        }
        return arrayList;
    }


}
