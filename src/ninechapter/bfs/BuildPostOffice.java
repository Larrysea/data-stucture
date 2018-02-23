package ninechapter.bfs;

import data_stucture.PrintUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二维矩阵中找到一个点离其他点距离之和最小的一个点。
 *
 * @author
 * @create 2018-02-22 下午9:24
 **/
public class BuildPostOffice {

    //为空可以跳
    static int EMPTY = 0;
    //是墙不能跳
    static int WALL = 2;
    //是房子可以跳
    static int HOUSE = 1;

    //矩阵
    static int[][] mGrid;

    //行
    static int mRow = 0;
    //列
    static int mColumn = 0;


    static int[] xOffset = {0, 1, -1, 0};
    static int[] yOffset = {1, 0, 0, -1};

    //访问空白节点的距离
    static int[][] distanceSum;

    //空白节点访问次数
    static int[][] vistedTimes;

    public static void main(String[] args) {
        int[][] testCase1 = {{0, 1, 0, 0, 0},
                {1, 0, 0, 2, 1},
                {0, 1, 0, 0, 0}};
        PrintUtil.print(shortestDistance(testCase1));

    }


    private static void setGrid(int row, int column, int[][] grid) {
        mRow = row;
        mColumn = column;
        mGrid = grid;
        distanceSum = new int[mRow][mColumn];
        vistedTimes = new int[mRow][mColumn];
    }


    /**
     * @param grid: a 2D mGrid
     * @return: An integer
     */
    public static int shortestDistance(int[][] grid) {
        // write your code here

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        setGrid(grid.length, grid[0].length, grid);

        int houseLength = getCoordinateList(HOUSE, grid).size();

        int shortestPath = Integer.MAX_VALUE;
        //从房子开始出发到每一个空白节点
        for (Coordinate coordiante : getCoordinateList(HOUSE, grid)) {
            countDistanceAndVistedTimes(distanceSum, vistedTimes, coordiante);
        }

        //查看所有空白节点的，比较出路径最小的空白节点则是邮局所在地
        for (Coordinate emtpyCoordiante : getCoordinateList(EMPTY, grid)) {
            //首先判断该点是否是每个点都可达如果不是则跳过
            if (vistedTimes[emtpyCoordiante.x][emtpyCoordiante.y] != houseLength) {
                continue;
            }

            shortestPath = Math.min(shortestPath, distanceSum[emtpyCoordiante.x][emtpyCoordiante.y]);

        }

        if (shortestPath == Integer.MAX_VALUE) {
            return -1;
        }
        return shortestPath;

    }

    //获取特定类型的coordinate数组
    private static List<Coordinate> getCoordinateList(int type, int grid[][]) {
        List<Coordinate> coordinateList = new ArrayList<>();

        for (int i = 0; i < mRow; i++) {
            for (int j = 0; j < mColumn; j++) {
                if (grid[i][j] == type) {
                    coordinateList.add(new Coordinate(i, j));
                }
            }
        }
        return coordinateList;
    }


    //计算每个点被访问的次数好距离之和
    private static void countDistanceAndVistedTimes(int[][] distance, int[][] vistedTimes, Coordinate startPoint) {

        //是否被访问过
        boolean[][] hasbeenVisted = new boolean[mRow][mColumn];

        Queue<Coordinate> queue = new LinkedList<>();

        queue.add(startPoint);

        hasbeenVisted[startPoint.x][startPoint.y] = true;

        int steps = 0;
        //对列是否为空
        while (!queue.isEmpty()) {
            int oldSize = queue.size();
            steps++;
            //宽度遍历
            for (int i = 0; i < oldSize; i++) {
                Coordinate point = queue.poll();

                //四个方向的探索
                for (int direction = 0; direction < 4; direction++) {

                    Coordinate coordinate = new Coordinate(point.x + xOffset[direction], point.y + yOffset[direction]);

                    //是否在边界范围以内
                    if (!isInBound(coordinate, mRow, mColumn)) {
                        continue;
                    }

                    //如果是已经访问过了，则不再进行访问
                    if (hasbeenVisted[coordinate.x][coordinate.y]) {
                        continue;
                    }

                    //没有访问过，将当前领边节点添加到宽搜队列中
                    queue.offer(coordinate);


                    hasbeenVisted[coordinate.x][coordinate.y] = true;
                    //设置当前节点的路径值
                    distance[coordinate.x][coordinate.y] += steps;

                    //设置访问次数
                    vistedTimes[coordinate.x][coordinate.y]++;
                }
            }

        }

    }

    //判断是否在合法范围以内
    public static boolean isInBound(Coordinate coordinate, int row, int column) {
        if (coordinate.x < 0 || coordinate.x >= row) {
            return false;
        }

        if (coordinate.y < 0 || coordinate.y >= column) {
            return false;
        }

        return mGrid[coordinate.x][coordinate.y] == EMPTY;
    }


}
