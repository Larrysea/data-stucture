package ninechapter.common_datastructure;

import data_stucture.PrintUtil;

import java.util.HashSet;

/**
 * 找出数组中重复的数
 *
 * @author
 * @create 2018-04-21 上午11:39
 **/
public class DuplicateInArray {


    public static void main(String[] args) {
        int[] testCase1 = {2, 3, 1, 0, 2, 5, 3};
        int[] duplication = new int[1];
        PrintUtil.print(duplicate(testCase1, 7, duplication) + "");
        PrintUtil.print(duplication[0]);
    }


    public static boolean duplicate(int numbers[], int length, int[] duplication) {

        if (numbers == null || numbers.length == 0) {
            return false;
        }

        HashSet<Integer> hashSet = new HashSet<>();

        boolean result = false;
        for (int i = 0; i < length; i++) {
            if (hashSet.contains(numbers[i])) {
                duplication[0] = numbers[i];
                result = true;
                break;
            }
            hashSet.add(numbers[i]);
        }

        return result;
    }
}
