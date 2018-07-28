package offer;

/**
 * 机器人运动范围
 *
 * @author
 * @create 2018-04-23 下午11:44
 **/
public class RobotMovingCount {


    public static void main(String[] args) {
    }


    //通过回溯法对四个方向探索
    public  static int movingCount(int threshold, int rows, int cols) {
        boolean[] vistedArray = new boolean[rows * cols];

        for (int i = 0; i < rows * cols; i++) {
            vistedArray[i] = false;
        }

        return movingCount(threshold, 0, 0, rows, cols, vistedArray);

    }


    public static  int movingCount(int threshold, int row, int col, int rowLength, int colLength, boolean[] vistedArray) {
        int count = 0;

        if (isCanMove(threshold, row, col, rowLength, colLength, vistedArray)) {
            vistedArray[row * colLength + col] = true;

            count += movingCount(threshold, row + 1, col, rowLength, colLength, vistedArray);

            count += movingCount(threshold, row - 1, col, rowLength, colLength, vistedArray);

            count += movingCount(threshold, row, col + 1, rowLength, colLength, vistedArray);

            count += movingCount(threshold, row, col - 1, rowLength, colLength, vistedArray);

        }

        return count;


    }


    public static boolean isCanMove(int threshold, int row, int column, int rowLength, int colLength, boolean[] vistedArray) {
        if (getSum(row) <= threshold && getSum(column) <= threshold &&
                row >= 0 && row < rowLength && column < colLength && column >= 0 &&
                !vistedArray[row * colLength + column]) {
            return true;
        }
        return false;
    }


    public static  int getSum(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }


}
