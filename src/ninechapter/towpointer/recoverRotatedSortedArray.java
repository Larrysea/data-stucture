package ninechapter.towpointer;

import data_stucture.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 将排序数组组恢复原样
 *
 * @author
 * @create 2018-03-11 上午11:24
 **/
public class recoverRotatedSortedArray {

    public static void main(String[] args) {
        Integer[] testCase1 = {4, 5, 1, 2, 3};
        Integer[] testCase2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        List<Integer> testList1 = Arrays.asList(testCase1);
        testList1 = new ArrayList<>(testList1);
        recoverRotatedSortedArray(testList1);
        PrintUtil.printList(testList1);

        List<Integer> testList2 = Arrays.asList(testCase2);
        testList2 = new ArrayList<>(testList2);
        recoverRotatedSortedArray(testList2);
        PrintUtil.printList(testList2);
    }

    /**
     * @param nums: An integer array
     * @return: nothing
     */
    public static void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here

        if (nums == null || nums.size() == 0) {
            return;
        }

        int lastNumber = Integer.MIN_VALUE;

        int index = 0;

        //找出开始下降的数的下标
        while (index < nums.size()) {
            if (lastNumber > nums.get(index)) {
                break;
            }
            lastNumber = nums.get(index);
            index++;
        }


        //将0 -- index 下标的数从数组前方移动到数组后方
        for (int i = 0; i < index; i++) {
            int firstNumber = nums.get(0);
            nums.remove(0);
            nums.add(firstNumber);
        }
    }

}
