package ninechapter;

import data_stucture.PrintUtil;

/**
 * 寻找出一个数组中的峰
 *
 * @author
 * @create 2018-01-21 下午7:15
 **/
public class FindPeek {


    public static void main(String[] args) {

        int test1[] = {1, 2, 1, 3, 4, 5, 7, 6};

        int test2[] = {100, 102, 104, 7, 9, 11, 4, 3};
        PrintUtil.print(findPeak(test1));
        PrintUtil.print(findPeak(test2));


    }


    /*
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public static int findPeak(int[] A) {
        if (A.length == 0) {
            return -1;
        }
        // write your code here
        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            //上升区间
            if (A[mid] < A[mid + 1] && A[mid] > A[mid - 1]) {
                start = mid;

            }
            //下降区间
            else if (A[mid] > A[mid + 1] && A[mid - 1] > A[mid]) {
                end = mid;
            }
            //相等的情况
            else if (A[mid] > A[mid + 1] && A[mid] > A[mid - 1]) {
                return mid;
            }
            //在谷底的情况
            else if (A[mid] < A[mid + 1] && A[mid] < A[mid - 1]) {
                start = mid;
            }
        }
        if (A[start] > A[end]) {
            return A[start];
        } else {
            return A[end];
        }

    }

}
