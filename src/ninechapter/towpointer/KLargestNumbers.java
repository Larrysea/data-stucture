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
        return quickSelect(nums, k, 0, nums.length - 1);
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
            return quickSelect(nums, k, start, right);
        }

        //如果超过k
        if (start + k - 1 >= left) {
            return quickSelect(nums, k - (left - start), left, end);
        }

        return nums[right + 1];
    }


    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public static int kthLargestElementII(int k, int[] nums) {
        return quickSelectII(nums, 0, nums.length - 1, k);
    }

    private static int quickSelectII(int[] nums, int start, int end, int k) {
        int left = start, right = end;
        int pivot = nums[(start + end) / 2];

        while (left <= right) {
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

                left++;
                right--;
            }
        }

        if (start + k - 1 <= right) {
            return quickSelectII(nums, start, right, k);
        }

        if (start + k - 1 >= left) {
            return quickSelectII(nums, left, end, k - (left - start));
        }

        return nums[right + 1];
    }


}
