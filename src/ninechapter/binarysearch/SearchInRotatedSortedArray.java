package ninechapter.binarysearch;

import data_stucture.PrintUtil;

/**
 * 在旋转排序数组中寻找查询
 * <p>
 * Example
 * For [4, 5, 1, 2, 3] and target=1, return 2.
 * <p>
 * For [4, 5, 1, 2, 3] and target=0, return -1.
 *
 * @author
 * @create 2018-01-21 下午8:08
 **/
public class SearchInRotatedSortedArray {


    public static void main(String[] args) {
        int test1[] = {1, 2, 4, 5, 6};
        int test2[] = {6, 5, 4, 3, 2, 1};
        int test3[] = {4, 5, 1, 2, 3};
        int test4[] = {5};
        int test5[] = {1, 2, 3};
        int test6[]={4,5,6,7,0,1,2};
//        PrintUtil.print(binarySearch(test3, 0,1,1));
//        PrintUtil.print(binarySearch(test3, 2, 4, 1));
//        PrintUtil.print(search(test3, 1));

        PrintUtil.print(search(test6, 2));


    }

//    /*
//     * @param A: an integer rotated sorted array
//     * @param target: an integer to be searched
//     * @return: an integer
//     */
//    public static int search(int[] A, int target) {
//        // write your code here
//        //找出峰值点
//        //分别在上升区间和下降区间进行二分查找
//        if (A.length == 0) {
//            return -1;
//        }
//
//        int start = 0;
//        int end = A.length - 1;
//
//        int peekIndex = -1;
//        while (start + 1 < end) {
//            int mid = start + (end - start) / 2;
//            if (A[mid] == target) {
//                end = mid;
//            } else if (A[mid] > A[mid + 1]) {
//                start = mid;
//            } else {
//                end = mid;
//            }
//        }
//        if (A[start] > A[end]) {
//            peekIndex = start;
//        } else {
//            peekIndex = end;
//        }
//        if (A[peekIndex] == target) {
//            return peekIndex;
//        }
//        int leftResult = binarySearch(A, 0, peekIndex, target);
//        int rightResult = binarySearch(A, peekIndex + 1, A.length - 1, target);
//        if (leftResult != -1) {
//            return leftResult;
//        } else {
//            return rightResult;
//        }
//
//
//    }
//
//    public static int binarySearch(int array[], int startIndex, int endIndex, int target) {
//        if (endIndex - startIndex == 0) {
//            return -1;
//        }
//        int start = startIndex;
//        int end = endIndex;
//        while (start + 1 < end) {
//            int mid = start + (end - start) / 2;
//            if (array[mid] == target) {
//                end = mid;
//            } else if (array[mid] > target) {
//                end = mid;
//            } else {
//                start = mid;
//            }
//        }
//
//        if (array[start] == target) {
//            return start;
//        }
//
//        if (array[end] == target) {
//            return end;
//        }
//        return -1;
//    }

    public static int search(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        if (A.length == 0) {
            return -1;
        }

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            //根据这个题意描述的情况类似于二四象限分别有两根递增的线，而该结果有课能在第二象限，也有可能在第四象限，
            //如果确定在某一个象限了就可以在该象限中进行二分搜索，mid值如果大于第一个数，说明在旋转数组的第一段，否则在第二段
            //这个时候在进行正常的二分查找
            if (A[start] < A[mid]) {
                //之所有需要等号是因为在这个范围内，有可能是两端的值，所以需要包含
                if (A[mid] >= target && target >= A[start]) {
                    end = mid;
                } else {
                    start = mid;
                }

            } else {
                if (A[mid] <= target && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }

        }

        if (A[start] == target) {
            return start;
        }

        if (A[end] == target) {
            return end;
        }
        return -1;
    }


}
