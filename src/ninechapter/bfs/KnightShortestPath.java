package ninechapter.bfs;

import data_stucture.PrintUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 骑士最短路径
 * <p>
 * <p>
 * 骑士走的最短路径，类似中国象棋的马字跳跃方式
 *
 * @author
 * @create 2018-02-16 下午12:56
 **/
public class KnightShortestPath {

    //该算法思路
    // 1  从定点开始进行宽搜
    // 2  每到一个点进行探索性跳跃
    // 3  如果到了终点则返回步数
    // 4  否则宽搜完毕以后没有查找到结果则返回没找到
    public static class Point {

        int x, y;

        public Point() {
            x = 0;
            y = 0;
        }

        public Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public static int shortestPath(boolean[][] grid, Point source, Point destination) {

        //条件判断
        if (grid.length == 0 || grid[0].length == 0 || source == null || destination == null) {
            return -1;
        }

        //如果两个点相等
        if (isPointEqual(source, destination)) {
            return 0;
        }

        Queue<Point> pointQueue = new LinkedList<Point>();

        pointQueue.offer(source);


        int x_offset[] = {1, 1, -1, -1, 2, 2, -2, -2};

        int y_offset[] = {2, -2, 2, -2, 1, -1, 1, -1};

        int paths = 0;

        while (!pointQueue.isEmpty()) {
            paths++;
            int oldQueueSize = pointQueue.size();

            for (int index = 0; index < oldQueueSize; index++) {
                Point currentPoint = pointQueue.poll();

                for (int direction = 0; direction < 8; direction++) {

                    Point point = new Point(currentPoint.x + x_offset[direction], currentPoint.y + y_offset[direction]);

                    if (isPointEqual(point, destination)) {
                        return paths;
                    }
                    //如果跳的点在范围以内
                    if (inBound(grid, point)) {
                        //如果该点不是障碍物
                        if (!grid[point.x][point.y]) {
                            pointQueue.offer(point);
                            grid[point.x][point.y] = true;
                        }
                    }
                }

            }


        }

        return -1;
    }

    private static boolean isPointEqual(Point currentPoint, Point sourcePoint) {
        if (currentPoint == null || sourcePoint == null) {
            return false;
        }

        if (currentPoint == sourcePoint) {
            return true;
        }

        if (currentPoint.x == sourcePoint.x && currentPoint.y == sourcePoint.y) {
            return true;
        }

        return false;
    }


    private static boolean inBound(boolean grid[][], Point point) {
        if (grid.length == 0 || grid[0].length == 0) {
            return false;
        }

        int row = grid.length;
        int column = grid[0].length;

        if (point.x < 0 || point.x > row) {
            return false;
        }

        if (point.y < 0 || point.y > column) {
            return false;
        }

        return point.x < row && point.y < column;
    }


    public static void main(String args[]) {
        boolean[][] testCase1 = {{false, false, false}, {false, false, false}, {false, false, false}};
        boolean[][] testCase2 = {{false, true, false}, {false, false, false}, {false, false, false}};
        boolean[][] testCase3 = {{false, false, false, false, true, true}, {true, false, true, false, false, true}, {false, false, true, false, false, true},
                {false, false, true, true, false, true}, {true, false, true, false, false, true}, {false, false, true, false, false, true}, {false, false, true, false, false, true},
                {false, false, true, false, false, true}};
        PrintUtil.print(shortestPath(testCase1, new Point(2, 0), new Point(2, 2)));
        PrintUtil.print(shortestPath(testCase3, new Point(0, 0), new Point(7, 0)));
//        PrintUtil.print(shortestPath(testCase2, new Point(2, 0), new Point(2, 2)));
    }


}
