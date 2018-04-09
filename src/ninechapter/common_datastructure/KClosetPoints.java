package ninechapter.common_datastructure;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最近的k个点
 *
 * @author
 * @create 2018-04-09 下午11:11
 **/
public class KClosetPoints {


    public static void main(String[] args) {
    }

    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }


    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k:      An integer
     * @return: the k closest points
     */
    public static Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here

        PriorityQueue<Point> queue = new PriorityQueue<Point>(k, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                int diff = getDistance(b, origin) - getDistance(a, origin);
                if (diff == 0) {
                    diff = b.x - a.x;
                    if (diff == 0) {
                        diff = b.y - a.y;
                    }
                }

                return diff;
            }


        });


        for (int i = 0; i < points.length; i++) {
            queue.offer(points[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        Point[] result = new Point[k];


        while (!queue.isEmpty() && k >= 0) {
            result[--k] = queue.poll();
        }

        return result;

    }


    //计算两个点的距离
    private static int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);

    }
}
