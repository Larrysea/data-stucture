package offer;

import data_stucture.PrintUtil;

/**
 * 在矩阵中寻找是否存在一个字符序列
 *
 * @author
 * @create 2018-04-24 下午10:26
 **/
public class FindPathInMatrix {


    public static void main(String[] args) {
        char[] matrix = {'a', 'b', 'e', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] path = {'b', 'c', 'c', 'e', 'd'};
        char[] matrix1 = {'A', 'B', 'C', 'E', 'S', 'F', 'C', 'S', 'A', 'D', 'E', 'E'};
        char[] path1 = {'A', 'B', 'C', 'B'};
        PrintUtil.print(hasPath(matrix, 3, 4, path) + "");
    }


    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        //如果矩阵的长度为0
        if (matrix == null || matrix.length == 0 || str == null || str.length == 0) {
            return false;
        }

        boolean[] visitedArray = new boolean[matrix.length];

//        int pathLength = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, rows, cols, i, j, visitedArray, pathLength, str)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static int pathLength = 0;

    //是否有路径
    private static boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, boolean[] vistedArray, int pathLength, char[] str) {
        boolean hasPath = false;

        if (row >= 0 && row < rows
                && col >= 0 && col < cols) {
            //如果路径长度最终达到和结果路径长度一样标识存在这么一条路径
            if (pathLength == str.length - 1 && matrix[row * cols + col] == str[pathLength]) {
                System.out.println(matrix[row * cols + col]);
                return true;
            }

        }


        //如果当前路访问的字符和路径中字符相等，则进行下一步的判断
        if (row >= 0 && row < rows
                && col >= 0 && col < cols
                && matrix[row * cols + col] == str[pathLength]
                && !vistedArray[row * cols + col]) {

            System.out.println(matrix[row * cols + col]);

            ++pathLength;

            vistedArray[row * cols + col] = true;

            hasPath = hasPathCore(matrix, rows, cols, row + 1, col, vistedArray, pathLength, str)
                    || hasPathCore(matrix, rows, cols, row - 1, col, vistedArray, pathLength, str)
                    || hasPathCore(matrix, rows, cols, row, col + 1, vistedArray, pathLength, str)
                    || hasPathCore(matrix, rows, cols, row, col - 1, vistedArray, pathLength, str);


            if (!hasPath) {
                //返回到上一个位置
                --pathLength;
                vistedArray[row * cols + col] = false;
            }
        }
        return hasPath;
    }
}
