package ninechapter;

import data_stucture.PrintUtil;

/**
 * 二分搜索
 *
 * @author   larrysea
 * @create 2018-01-20 下午6:16
 **/
public class BinarySearch {
    public static void main(String [] args) {
       int test[]={1,2,4,5,70};
       int test1[]={1,4};
       int test2[]={1};
       int test3[]={6};
       PrintUtil.print(binarySearch(test,69));
       PrintUtil.print(binarySearch(test1,4));
       PrintUtil.print(binarySearch(test1,1));
       PrintUtil.print(binarySearch(test2,1));
       PrintUtil.print(binarySearch(test3,7));

    }


    public static  int binarySearch(int nums[], int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }

        return -1;
    }

}
