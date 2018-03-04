package ninechapter.binarysearch;

import data_stucture.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 找出接近target的k个数
 *
 * @author
 * @create 2018-03-04 下午6:12
 **/
public class FindKCloseElements {


    public static void main(String[] args) {
        int testCase1[] = {1, 2, 3};
        int testTarget1 = 2;
        int testK1 = 3;

        int testCase2[] = {1, 4, 6, 8};
        int testTarget2 = 3;
        int testK2 = 3;


        int testCase3[] = {1, 4, 6, 10, 20};
        int testTarget3 = 21;
        int testK3 = 4;


        PrintUtil.printArray(kClosestNumbers(testCase1, testTarget1, testK1));
//        PrintUtil.printArray(kClosestNumbers(testCase2, testTarget2, testK2));
//        PrintUtil.printArray(kClosestNumbers(testCase3, testTarget3, testK3));


    }


    private static void testFindCloseNumberInList() {
        Integer[] array = {1, 4, 6, 10, 20};
        List<Integer> numberList = Arrays.asList(array);
        PrintUtil.print(findCloseNumber(numberList, 21));


    }


    /**
     * @param A:      an integer array
     * @param target: An integer
     * @param k:      An integer
     * @return: an integer array
     */
    public static int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here

        if (A == null || A.length == 0) {
            return new int[0];
        }

        int[] copyA = new int[k];

        List<Integer> copyList = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            copyList.add(A[i]);
        }

        for (int i = 0; i < k; i++) {
            int mostCloseIndex = findCloseNumber(copyList, target);
            copyA[i] = copyList.get(mostCloseIndex);
            copyList.remove(mostCloseIndex);
        }


        return copyA;
    }


    //该算法思路是首先找出最接近的数，然后把它放在首位，然后从数组总取k-1 个数以后就是结果

    private static int findCloseNumber(int[] A, int target) {

        int left = 0;
        int right = A.length - 1;


        while (left + 1 < right) {
            int mid = (left + right) / 2;

            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }

        }

        //判断最后的两个结果谁更靠近结果
        if (Math.abs(A[left] - target) >= Math.abs(A[right] - target)) {
            return right;
        } else {
            return left;
        }

    }


    //该算法思路是首先找出最接近的数，然后把它放在首位，然后从数组总取k-1 个数以后就是结果

    private static int findCloseNumber(List<Integer> A, int target) {

        int left = 0;
        int right = A.size() - 1;

        if (A.size() == 1) {
            return 0;
        }

        while (left + 1 < right) {
            int mid = (left + right) / 2;

            if (A.get(mid) == target) {
                return mid;
            } else if (A.get(mid) < target) {
                left = mid;
            } else {
                right = mid;
            }

        }


        //判断最后的两个结果谁更靠近结果
        if (Math.abs(A.get(left) - target) > Math.abs(A.get(right) - target)) {
            return right;
        } else {
            return left;
        }

    }


}
