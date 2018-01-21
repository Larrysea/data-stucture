package ninechapter;

import data_stucture.PrintUtil;

/**
 * 找出一个数组中最靠近目标数的下标
 *
 * @author
 * @create 2018-01-21 下午5:05
 **/
public class CloseArrayInSortedArray {




    public static void main(String[] args) {
        int test[] ={1,3,3,4};
        int test1[]={1,4,6};
        PrintUtil.print(closestNumber(test,2));
        PrintUtil.print(closestNumber(test1,5));

    }





    /*
     * @param A: an integer array sorted in ascending order
     * @param target: An integer
     * @return: an integer
     */
    public static int closestNumber(int[] A, int target) {
        // write your code here
        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (A[mid] == target) {
                end = mid;
            } else if (A[mid] > target) {
                end = mid;

            } else {
                start = mid;
            }

        }

        if (Math.abs(A[start] - target) > Math.abs(A[end] - target)) {
            return end;
        } else {
            return start;
        }

    }




}
