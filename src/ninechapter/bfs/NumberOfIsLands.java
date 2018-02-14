package ninechapter.bfs;

import data_stucture.PrintUtil;
import sun.management.counter.perf.PerfInstrumentation;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 岛屿的数量，给出一个二维矩阵，true为岛屿，如果相邻的上下左右同样为1，则这两个点事同一个岛屿，否则不是
 *
 * @author
 * @create 2018-02-13 下午5:29
 **/
public class NumberOfIsLands {


    public static void main(String[] args) {
        boolean[][] matrix = {{true, true, false, false, false},
                {false, true, false, false, true},
                {false, false, false, true, true},
                {false, false, false, false, false},
                {false, false, false, false, true},
                {false, false, true, false, true}};
        int numbers = numIslands(matrix);

        PrintUtil.print(numbers);

        PrintUtil.printMatrix(matrix);

    }


    /*
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public static int numIslands(boolean[][] grid) {

        //判断是否是空矩阵如果是则，返回为空
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        //行高
        int row = grid.length;
        //列长
        int column = grid[0].length;
        //岛屿数量
        int landNumbers = 0;

        // 岛屿中每个点进行遍历
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            for (int columnIndex = 0; columnIndex < column; columnIndex++) {
                if (grid[rowIndex][columnIndex]) {
                    markIsLand(grid, columnIndex, rowIndex);
                    landNumbers++;
                }
            }
        }

        return landNumbers;

    }

    //宽搜岛屿的周围是岛屿
    public static void markIsLand(boolean[][] grid, int columnIndex, int rowIndex) {
        //坐标变化数组，知道保证在四个方向上会分别的遍历到就可以
        int x_offset[] = {0, 1, -1, 0};
        int y_offset[] = {1, 0, 0, -1};

        int row = grid.length;

        int column = grid[0].length;

        //宽搜的队列
        Queue<Coordinate> coordinateQueue = new LinkedList<>();

        //标记该点的坐标为
        grid[rowIndex][columnIndex] = false;

        //开始探索的第一个岛屿为根据点
        coordinateQueue.add(new Coordinate(columnIndex, rowIndex));

        //宽搜的队列循环
        while (!coordinateQueue.isEmpty()) {
            Coordinate currentCoordinate = coordinateQueue.poll();

            int currentX = currentCoordinate.x;

            int currentY = currentCoordinate.y;

            //四个方向的探索
            for (int i = 0; i < 4; i++) {
                //往外部延伸
                Coordinate coordinate = new Coordinate(currentX + x_offset[i], +currentY + y_offset[i]);

                //如果超过边界范围以内则继续搜索
                if (!isInbound(coordinate, row, column)) {
                    continue;
                }

                //该延伸点在边界范围以内，且该点是岛屿
                if (grid[coordinate.y][coordinate.x]) {
                    //将该海岛打通
                    grid[coordinate.y][coordinate.x] = false;

                    //在从该海岛中继续探索周围是否存在海岛
                    coordinateQueue.add(coordinate);
                }

            }
        }


    }

    //判断该变化坐标点是否在区间以内，是则返回true,否则返回false
    public static boolean isInbound(Coordinate coordinate, int row, int column) {

        return coordinate.x >= 0 && coordinate.x < column && coordinate.y >= 0 && coordinate.y < row;
    }


}

class Coordinate {
    int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

