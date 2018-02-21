package ninechapter.bfs;

import data_stucture.PrintUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 安排课程问题，在上某门课之前需要先修某一门课，并且必须修满n们课
 *
 * @author
 * @create 2018-02-20 下午9:32
 **/
public class CourseSchedule {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {



        //首先构造每个点的度
        //还有边集
        int[] degree = new int[numCourses];

        List[] edges = new List[numCourses];


        //初始化边集
        for (int i = 0; i < numCourses; i++) {

            edges[i] = new ArrayList();

        }


        //构造边集,和入度统计
        for (int courseIndex = 0; courseIndex < prerequisites.length; courseIndex++) {
            //入度增一
            degree[prerequisites[courseIndex][0]]++;
            edges[prerequisites[courseIndex][1]].add(prerequisites[courseIndex][0]);
        }


        Queue order = new LinkedList();

        //将入度为0的点添加到对列
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                //将入度为0的节点添加到顺序中
                order.offer(i);
            }
        }


        int[] result = new int[numCourses];

        //课程数
        int numCount = 0;

        //进行宽搜的删除边操作
        while (!order.isEmpty()) {
            //入度为0的课程
            int pointer = (int) order.poll();
            //将课程顺序记录下来
            result[numCount] = pointer;
            //入度为0的领接边
            int edgesLength = edges[pointer].size();
            numCount++;

            for (int i = edgesLength - 1; i >= 0; i--) {
                int course = (int) edges[pointer].get(i);
                //“删除”到改点的链接，此处的删除不是真正的删除，只是从入度减一
                degree[course]--;
                //如果该点入度为一添加到遍历队列上
                if (degree[course] == 0) {
                    order.offer(course);
                }
            }


        }

        //课程数相等，返回正确结果
        if (numCount == numCourses) {
            return result;
        }

        //否则返回空序列
        return new int[0];

    }


    public static void main(String[] args) {
        int[][] prerequisties = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        PrintUtil.printArray(findOrder(4, prerequisties));
        int[] testArray = {1, 2, 3, 4, 5, 6};
        for (int i = testArray.length-1; i >= 0; i--) {
            PrintUtil.print(testArray[i]);
        }
    }


}
