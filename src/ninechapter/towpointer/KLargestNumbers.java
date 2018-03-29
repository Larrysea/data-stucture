package ninechapter.towpointer;

import data_stucture.PrintUtil;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 第k大的数
 *
 * @author
 * @create 2018-03-26 下午11:42
 **/
public class KLargestNumbers {


    public static void main(String[] args) {
        // write your code here
        int[] testParams1 = {9, 3, 2, 4, 8};
        ArrayList<Integer> params = new ArrayList<>();
        for (int i = 0; i < testParams1.length; i++) {
            params.add(testParams1[i]);
        }
        PrintUtil.print(kthLargestElement(3, testParams1));
        PrintUtil.printArray(testParams1);
//        PrintUtil.print(kthLargestElement(4, params));
    }


    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public static int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (k < 1 || nums == null) {
            return 0;
        }
        return quickSelect(nums, k, 0, nums.length - 1);
    }


    private static void swap(int nums[], int i, int k) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }

    //快速选择算法
    private static int quickSelect(int[] nums, int k, int start, int end) {
        int right = end;
        int left = start;

        int pivot = nums[(start + end) / 2];

        while (left <= right) {

            //移动指针，找出不满足大小关系的数组下标
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }


            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
                left++;
            }

        }

        //如果现在的的位置在k以内
        if (start + k - 1 <= right) {
            quickSelect(nums, k, start, right);
        }

        //如果超过k
        if (start + k - 1 >= left) {
            quickSelect(nums, k - (left - start), left, end);
        }

        return nums[right + 1];
    }


}
