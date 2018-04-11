package ninechapter.common_datastructure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 两个交叉数组
 *
 * @author
 * @create 2018-04-11 下午11:34
 **/
public class IntersectionTwoArray {




    /*
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        Set<Integer> numberSet = new HashSet<>();

        if (nums1.length < nums2.length) {
            for (int i = 0; i < nums1.length; i++) {
                numberSet.add(nums1[i]);
            }
        } else {
            for (int i = 0; i < nums2.length; i++) {
                numberSet.add(nums2[i]);
            }
        }
        Set<Integer> resultSet = new HashSet<>();

        int length = nums1.length < nums2.length ? nums2.length : nums1.length;

        boolean nums1LessNums2 = nums1.length < nums2.length;
        for (int j = 0; j < length; j++) {
            //如果数组1的长度小于数组2的长度
            if (nums1LessNums2) {
                if (numberSet.contains(nums2[j])) {
                    resultSet.add(nums2[j]);
                }
            } else {
                if (numberSet.contains(nums1[j])) {
                    resultSet.add(nums1[j]);
                }
            }

        }

        int[] resultArray = new int[resultSet.size()];
        Iterator<Integer> iterator = resultSet.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            resultArray[count++] = iterator.next();
        }
        Arrays.sort(resultArray);

        return resultArray;


    }
}
