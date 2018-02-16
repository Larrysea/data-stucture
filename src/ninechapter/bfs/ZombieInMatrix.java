package ninechapter.bfs;

import data_stucture.PrintUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 计算僵尸感染整个人群所需要耗费的时间
 *
 * @author
 * @create 2018-02-14 下午3:16
 **/
public class ZombieInMatrix {


    //该算法思路，首先遍历一遍计算出所有人类的数量
    //然后进行宽搜，每一次宽搜将周围变成僵尸，这个宽搜记录天数
    //而这个宽搜遍历的队列长度不是实时的，而是这一天的僵尸数量，当天新转化的僵尸不纳入队伍考虑

    static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    //墙
    private static int WALL = 2;
    //人类型
    private static int PEOPLE = 0;
    //僵尸
    private static int ZOMBIE = 1;

    /*
     * @param grid: a 2D integer grid
     * @return: an integer
     */
    public static int zombie(int[][] grid) {
        // write your code here

        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int peopleCount = 0;

        //僵尸队列
        Queue<Coordinate> zombieQueue = new LinkedList<>();

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (isPeople(grid, row, column)) {
                    peopleCount++;

                } else if (isZombie(grid, row, column)) {
                    zombieQueue.offer(new Coordinate(column, row));
                }
            }
        }

        //如果一个人都没有
        if (peopleCount == 0) {
            return 0;
        }

        //需要的天数
        int days = 0;

        //坐标变换数组


        int x_offset[] = {0, 1, -1, 0};

        int y_offset[] = {1, 0, 0, -1};

        while (!zombieQueue.isEmpty()) {
            days++;
            int lastDayZombieCount = zombieQueue.size();


            for (int zombieCount = 0; zombieCount < lastDayZombieCount; zombieCount++) {
                Coordinate zombieCoor = zombieQueue.poll();

                //僵尸行数
                int zombieRow = zombieCoor.y;
                //僵尸列数

                int zombieColumn = zombieCoor.x;

                //开始四个方向狂咬
                for (int direction = 0; direction < 4; direction++) {
                    Coordinate passerby = new Coordinate(zombieColumn + x_offset[direction], zombieRow + y_offset[direction]);

                    //如果是人则咬
                    if (isPeople(grid, passerby.y, passerby.x)) {
                        zombieBit(grid, passerby.y, passerby.x);
                        zombieQueue.offer(passerby);
                        peopleCount--;
                        if (peopleCount == 0) {
                            return days;
                        }
                    }

                }
            }

        }

        return -1;
    }


    //僵尸咬
    private static void zombieBit(int[][] grid, int row, int column) {
        grid[row][column] = ZOMBIE;

    }

    private static boolean cornerCheck(int[][] grid, int row, int column) {
        //范围合理性检查
        if (row < 0 || row > grid.length - 1) {
            return false;
        }

        if (column < 0 || column > grid[0].length - 1) {
            return false;
        }

        return true;
    }

    private static boolean isPeople(int[][] grid, int row, int column) {
        if (cornerCheck(grid, row, column)) {
            //如果是人返回true
            return (grid[row][column] == PEOPLE);
        }
        return false;

    }


    private static boolean isZombie(int[][] grid, int row, int column) {
        if (cornerCheck(grid, row, column)) {

            //如果是人返回true
            return (grid[row][column] == ZOMBIE);

        }
        return false;
    }


    public static void main(String[] args) {
        int[][] grid = {{0, 1, 2, 0, 0}, {1, 0, 0, 2, 1}, {0, 1, 0, 0, 0}};
        PrintUtil.print(zombie(grid));
    }

}

